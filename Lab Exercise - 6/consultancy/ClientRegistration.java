// File: consultancy/ClientRegistration.java
package consultancy;

// Class representing client registration details
public class ClientRegistration {
    private String clientName;
    private String contactEmail;

    public ClientRegistration(String clientName, String contactEmail) {
        this.clientName = clientName;
        this.contactEmail = contactEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}
