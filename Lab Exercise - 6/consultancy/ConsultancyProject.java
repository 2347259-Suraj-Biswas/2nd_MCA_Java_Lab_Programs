// File: ConsultancyProject.java
package consultancy;

// Generic class representing a ConsultancyProject
public class ConsultancyProject<T> implements ConsultancyService<T> {
    private String projectName;
    private ConsultancyService<T> service;

    public ConsultancyProject(String projectName, ConsultancyService<T> service) {
        this.projectName = projectName;
        this.service = service;
    }

    @Override
    public void provideService(T client) {
        System.out.println("Providing consultancy service for project: " + projectName);
        System.out.println("Client: " + client);
        service.provideService(client); // Delegating to the provided service
    }
}
