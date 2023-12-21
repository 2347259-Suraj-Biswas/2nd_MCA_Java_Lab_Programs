// File: consultancy/GenericConsultant.java
package consultancy;

// Generic class representing a generic consultant
public class GenericConsultant<U> {
    private String name;

    public GenericConsultant(String name) {
        this.name = name;
    }

    public void performConsultation(String client, ConsultancyService<String> service) {
        System.out.println("Consultant " + name + " performing generic consultation:");
        service.provideService(client);
    }
}
