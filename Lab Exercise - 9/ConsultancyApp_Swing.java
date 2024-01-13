import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

public class ConsultancyApp_Swing extends JFrame {
    private List<ConsultancyClient> clients;
    private JTextArea clientListArea;
    private JTextField nameField;
    private JTextField contactField;
    private JComboBox<String> typeComboBox;
    private JSpinner ageSpinner;
    private JRadioButton activeRadioButton;
    private JRadioButton inactiveRadioButton;

    public ConsultancyApp_Swing() {
        clients = new ArrayList<>();

        setTitle("Consultancy Client Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createUI();

        setVisible(true);
    }

    private void createUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        clientListArea = new JTextArea();
        clientListArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(clientListArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        inputPanel.add(new JLabel("Client Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Client Contact:"));
        contactField = new JTextField();
        inputPanel.add(contactField);

        inputPanel.add(new JLabel("Client Type:"));
        String[] clientTypes = { "Regular", "Premium", "VIP" };
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

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem viewClientsItem = new JMenuItem("View Clients");
        viewClientsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewClients();
            }
        });

        JMenuItem clearClientsItem = new JMenuItem("Clear Clients");
        clearClientsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearClients();
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
        fileMenu.add(searchClientItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        add(mainPanel);
    }

    private void addClient(ButtonGroup statusGroup) {
        String name = nameField.getText();
        String contact = contactField.getText();
        String type = (String) typeComboBox.getSelectedItem();
        int age = (int) ageSpinner.getValue();
        boolean isActive = activeRadioButton.isSelected();

        if (validateName(name) && validateContact(contact) && validateStatus()) {
            ConsultancyClient client = new ConsultancyClient(name, contact, type, age, isActive);
            clients.add(client);

            updateClientList();

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
        if (name.isEmpty() || !name.matches("[a-zA-Z]+")) {
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

    private void viewClients() {
        StringBuilder clientList = new StringBuilder("Client List:\n");
        for (ConsultancyClient client : clients) {
            clientList.append(client.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, clientList.toString(), "View Clients", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearClients() {
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to clear the client list?",
                "Clear Clients", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            clients.clear();
            updateClientList();
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

    private void updateClientList() {
        clientListArea.setText("");
        for (ConsultancyClient client : clients) {
            clientListArea.append(client.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultancyApp_Swing();
            }
        });
    }
}
