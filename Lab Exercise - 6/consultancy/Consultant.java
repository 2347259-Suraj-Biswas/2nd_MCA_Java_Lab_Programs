// File: consultancy/Consultant.java
package consultancy;

// Generic class representing a Consultant
public class Consultant<T> {
    private String name;

    public Consultant(String name) {
        this.name = name;
    }

    public void performConsultation(T client, ConsultancyService<T> service) {
        System.out.println("Consultant " + name + " performing consultation:");
        service.provideService(client);
    }
}
