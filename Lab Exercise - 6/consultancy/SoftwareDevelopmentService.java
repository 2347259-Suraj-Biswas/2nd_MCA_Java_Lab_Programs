// File: consultancy/SoftwareDevelopmentService.java
package consultancy;

// Class representing a specific software development consultancy service
public class SoftwareDevelopmentService implements ConsultancyService<String> {
    @Override
    public void provideService(String client) {
        System.out.println("Providing software development consultancy service");
        System.out.println("Client: " + client);
    }
}
