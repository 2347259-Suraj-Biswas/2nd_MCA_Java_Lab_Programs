package com.consultancy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class ConsultancyClient {
    String name;
    String contact;
    String type;
    int age;
    boolean isActive;

    public ConsultancyClient(String name, String contact, String type, int age, boolean isActive) {
        this.name = name;
        this.contact = contact;
        this.type = type;
        this.age = age;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Contact: " + contact + ", Type: " + type + ", Age: " + age + ", Status: "
                + (isActive ? "Active" : "Inactive");
    }
}

public class ConsultancyApp extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ConsultancyClient> clients;
    private DefaultTableModel tableModel;

    private JTextField nameField;
    private JTextField contactField;
    private JComboBox<String> typeComboBox;
    private JSpinner ageSpinner;
    private JRadioButton activeRadioButton;
    private JRadioButton inactiveRadioButton;

    private static final int REFRESH_INTERVAL = 1000;
    
    public ConsultancyApp() {
        clients = ConsultancyDbOperations.getAllClients();

        setTitle("Consultancy Client Management");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createUI();
        createTable();
        updateClientTable();
        
        // Schedule a task to refresh the data periodically
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                refreshData();
            }
        }, 0, REFRESH_INTERVAL);

        setVisible(true);
    }
    
    private void refreshData() {
        // Refresh the data from the database
        List<ConsultancyClient> updatedClients = ConsultancyDbOperations.getAllClients();

        // Check for changes in the data
        if (!updatedClients.equals(clients)) {
            clients = updatedClients;
            updateClientTable();
        }
    }

    private void createUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        inputPanel.add(new JLabel("Client Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Client Contact:"));
        contactField = new JTextField();
        inputPanel.add(contactField);

        inputPanel.add(new JLabel("Client Type:"));
        String[] clientTypes = {"Regular", "Premium", "VIP"};
        typeComboBox = new JComboBox<>(clientTypes);
        inputPanel.add(typeComboBox);

        inputPanel.add(new JLabel("Client Age:"));
        SpinnerModel ageModel = new SpinnerNumberModel(18, 18, 100, 1);
        ageSpinner = new JSpinner(ageModel);
        JSpinner.NumberEditor ageEditor = new JSpinner.NumberEditor(ageSpinner);
        ageSpinner.setEditor(ageEditor);
        inputPanel.add(ageSpinner);

        inputPanel.add(new JLabel("Client Status:"));
        activeRadioButton = new JRadioButton("Active");
        inactiveRadioButton = new JRadioButton("Inactive");
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(activeRadioButton);
        statusGroup.add(inactiveRadioButton);
        JPanel statusPanel = new JPanel();
        statusPanel.add(activeRadioButton);
        statusPanel.add(inactiveRadioButton);
        inputPanel.add(statusPanel);

        JButton addButton = new JButton("Add Client");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClient(statusGroup);
            }
        });

        inputPanel.add(new JLabel());
        inputPanel.add(addButton);

        mainPanel.add(inputPanel, BorderLayout.WEST);

        add(mainPanel, BorderLayout.NORTH);
        createMenu();
    }
   

    private void createTable() {
        tableModel = new DefaultTableModel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        tableModel.addColumn("Name");
        tableModel.addColumn("Contact");
        tableModel.addColumn("Type");
        tableModel.addColumn("Age");
        tableModel.addColumn("Status");

        JTable clientTable = new JTable(tableModel);
        clientTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane tableScrollPane = new JScrollPane(clientTable);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.CENTER);
    }

    private void addClient(ButtonGroup statusGroup) {
        String name = nameField.getText();
        String contact = contactField.getText();
        String type = (String) typeComboBox.getSelectedItem();
        int age = (int) ageSpinner.getValue();
        boolean isActive = activeRadioButton.isSelected();

        if (validateName(name) && validateContact(contact) && validateStatus()) {
            ConsultancyClient client = new ConsultancyClient(name, contact, type, age, isActive);
            
            // Add client to the database
            ConsultancyDbOperations.addClient(client);
            
            clients.add(client);

            updateClientTable();

            nameField.setText("");
            contactField.setText("");
            typeComboBox.setSelectedIndex(0);
            ageSpinner.setValue(18);

            statusGroup.clearSelection();

            JOptionPane.showMessageDialog(this, "Client details added successfully.", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean validateName(String name) {
        if (name.isEmpty() || !name.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid name with only alphabetic characters.",
                    "Invalid Name", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validateContact(String contact) {
        if (contact.isEmpty() || !contact.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid contact with only numeric characters.",
                    "Invalid Contact", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validateStatus() {
        if (!activeRadioButton.isSelected() && !inactiveRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a client status.", "Invalid Status",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void updateClientTable() {
        clearClientTable();
        for (ConsultancyClient client : clients) {
            tableModel.addRow(new Object[]{client.name, client.contact, client.type, client.age,
                    client.isActive ? "Active" : "Inactive"});
        }
    }

    private void clearClientTable() {
        tableModel.setRowCount(0);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem viewClientsItem = new JMenuItem("View Clients");
        viewClientsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewClients();
            }
        });

        JMenuItem clearClientsItem = new JMenuItem("Delete Clients");
        clearClientsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearClients();
            }
        });

        JMenuItem updateClientItem = new JMenuItem("Update Client");
        updateClientItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClientInfo();
            }
        });

        JMenuItem searchClientItem = new JMenuItem("Search Client");
        searchClientItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchClient();
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(viewClientsItem);
        fileMenu.addSeparator();
        fileMenu.add(clearClientsItem);
        fileMenu.addSeparator();
        fileMenu.add(updateClientItem);
        fileMenu.addSeparator();
        fileMenu.add(searchClientItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    private void viewClients() {
        StringBuilder clientList = new StringBuilder("Client List:\n");
        for (ConsultancyClient client : clients) {
            clientList.append(client.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, clientList.toString(), "View Clients", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearClients() {
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to clear the client list?", "Clear Clients", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            clients.clear();
            updateClientTable();
            // Delete all clients from the database
            ConsultancyDbOperations.deleteAllClients();
        }
    }
    
    private void updateClientInfo() {
        String searchName = JOptionPane.showInputDialog(this, "Enter the name of the client to update:");
        
        if (searchName != null) {
            boolean found = false;
            for (ConsultancyClient client : clients) {
                if (client.name.equalsIgnoreCase(searchName)) {
                    found = true;
                    
                    String newContact = JOptionPane.showInputDialog(this, "Enter the new phone number:");
                    
                    ConsultancyDbOperations.updateClientContact(client.name, newContact);
                    
                    refreshData();
                    
                    JOptionPane.showMessageDialog(this, "Client information updated successfully.", "Update Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Client not found.", "Update Result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


    private void searchClient() {
        String searchName = JOptionPane.showInputDialog(this, "Enter the name of the client to search:");
        if (searchName != null) {
            boolean found = false;
            for (ConsultancyClient client : clients) {
                if (client.name.equalsIgnoreCase(searchName)) {
                    JOptionPane.showMessageDialog(this, client.toString(), "Search Result",
                            JOptionPane.INFORMATION_MESSAGE);
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Client not found.", "Search Result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultancyApp();
            }
        });
    }
}
