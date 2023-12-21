// File: consultancy/GenericConsultancyService.java
package consultancy;

// Generic class representing a generic consultancy service
public class GenericConsultancyService<U> implements ConsultancyService<U> {
    @Override
    public void provideService(U client) {
        System.out.println("Providing generic consultancy service");
        System.out.println("Client: " + client);
    }
}
