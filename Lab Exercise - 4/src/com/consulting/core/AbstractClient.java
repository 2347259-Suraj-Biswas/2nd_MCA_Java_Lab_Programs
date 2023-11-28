package src.com.consulting.core;

public abstract class AbstractClient implements Client {
    private String name;
    private String contactPerson;

    public AbstractClient(String name) {
        this.name = name;
    }

    @Override
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    @Override
    public void requestConsultation() {
        System.out.println("Client requesting consultation...");
    }
}