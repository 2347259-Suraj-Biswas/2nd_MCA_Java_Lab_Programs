import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

// Consultant class representing a consultant entity
class Consultant {
    private String consultantId;
    private String name;

    public Consultant(String consultantId, String name) {
        this.consultantId = consultantId;
        this.name = name;
    }

    public String getConsultantId() {
        return consultantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}

// Project class representing a project entity
class Project {
    private String projectId;
    private String projectName;

    public Project(String projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }
}

// Client class representing a client entity
class Client {
    private String clientId;
    private String clientName;

    public Client(String clientId, String clientName) {
        this.clientId = clientId;
        this.clientName = clientName;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }
}

class ConsultantCollection {
    private List<Consultant> consultants;

    public ConsultantCollection() {
        this.consultants = new ArrayList<>();
    }

    public void addConsultant(Consultant consultant) {
        consultants.add(consultant);
    }

    public List<Consultant> getConsultants() {
        return consultants;
    }

    public void updateConsultant(String consultantId, String newName) {
        for (Consultant consultant : consultants) {
            if (consultant.getConsultantId().equals(consultantId)) {
                consultant.setName(newName);
                System.out.println("Consultant updated: ID - " + consultantId + ", New Name - " + newName);
                return;
            }
        }
        System.out.println("Consultant not found with ID: " + consultantId);
    }

    public void deleteConsultant(String consultantId) {
        consultants.removeIf(consultant -> consultant.getConsultantId().equals(consultantId));
        System.out.println("Consultant deleted with ID: " + consultantId);
    }

    public Consultant findConsultantById(String consultantId) {
        for (Consultant consultant : consultants) {
            if (consultant.getConsultantId().equals(consultantId)) {
                return consultant;
            }
        }
        return null; // Consultant not found
    }
}

class ProjectCollection {
    private Map<String, Project> projects;

    public ProjectCollection() {
        this.projects = new HashMap<>();
    }

    public void addProject(Project project) {
        projects.put(project.getProjectId(), project);
    }

    public Project getProject(String projectId) {
        return projects.get(projectId);
    }

    public Map<String, Project> getProjects() {
        return projects;
    }

    public boolean isProjectExist(String projectId) {
        return projects.containsKey(projectId);
    }
}

class ClientCollection {
    private Vector<Client> clients;

    public ClientCollection() {
        this.clients = new Vector<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public Vector<Client> getClients() {
        return clients;
    }

    public void displayClientDetails() {
        System.out.println("\nClient Details:");
        for (Client client : clients) {
            System.out.println("ID: " + client.getClientId() + ", Name: " + client.getClientName());
        }
    }
}

public class Lab8 {
    public static void main(String[] args) {
        ConsultantCollection consultantCollection = new ConsultantCollection();
        consultantCollection.addConsultant(new Consultant("C001", "Suraj Biswas"));
        consultantCollection.addConsultant(new Consultant("C002", "Hrishabh Gautam"));

        ProjectCollection projectCollection = new ProjectCollection();
        projectCollection.addProject(new Project("P001", "Project A"));
        projectCollection.addProject(new Project("P002", "Project B"));

        ClientCollection clientCollection = new ClientCollection();
        clientCollection.addClient(new Client("CL001", "Client X"));
        clientCollection.addClient(new Client("CL002", "Client Y"));

        // Retrieve consultants from ConsultantCollection
        List<Consultant> consultants = consultantCollection.getConsultants();
        System.out.println("Consultants:");
        for (Consultant consultant : consultants) {
            System.out.println("ID: " + consultant.getConsultantId() + ", Name: " + consultant.getName());
        }

        // Retrieve projects from ProjectCollection
        Map<String, Project> projects = projectCollection.getProjects();
        System.out.println("\nProjects:");
        for (Project project : projects.values()) {
            System.out.println("ID: " + project.getProjectId() + ", Name: " + project.getProjectName());
        }

        // Retrieve clients from ClientCollection
        Vector<Client> clients = clientCollection.getClients();
        System.out.println("\nClients:");
        for (Client client : clients) {
            System.out.println("ID: " + client.getClientId());
        }

        // Update and delete consultants
        consultantCollection.updateConsultant("C001", "Suvajit Karmakar");
        consultantCollection.deleteConsultant("C002");

        // Display the updated consultants list
        System.out.println("\nUpdated Consultants:");
        for (Consultant consultant : consultantCollection.getConsultants()) {
            System.out.println("ID: " + consultant.getConsultantId() + ", Name: " + consultant.getName());
        }

        // Find a consultant by ID
        String searchConsultantId = "C001";
        Consultant foundConsultant = consultantCollection.findConsultantById(searchConsultantId);

        if (foundConsultant != null) {
            System.out.println("\nConsultant found: ID - " + foundConsultant.getConsultantId() +
                    ", Name - " + foundConsultant.getName());
        } else {
            System.out.println("\nConsultant not found with ID: " + searchConsultantId);
        }

        String checkProjectId = "P001";
        boolean projectExists = projectCollection.isProjectExist(checkProjectId);
        System.out.println("\nProject with ID " + checkProjectId + " exists: " + projectExists);

        clientCollection.displayClientDetails();
    }
}
