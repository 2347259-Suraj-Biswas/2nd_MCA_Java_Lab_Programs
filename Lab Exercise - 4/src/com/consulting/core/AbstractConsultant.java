package src.com.consulting.core;

public abstract class AbstractConsultant implements Consultant {
    private String name;
    private String expertise;

    public AbstractConsultant(String name) {
        this.name = name;
    }

    @Override
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    @Override
    public void provideConsultation() {
        System.out.println("Consultant providing consultation...");
    }
}
