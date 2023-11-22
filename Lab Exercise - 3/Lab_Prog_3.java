//Lab Program 3
abstract class ConsultancyService {
    private String serviceName;

    public ConsultancyService(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public abstract void provideService();

    public final void processPayment() {
        System.out.println("Payment processed for " + serviceName + " service.");
    }

    public void requestFeedback() {
        System.out.println("Please provide feedback for the " + serviceName + " service.\n");
    }
}

class Consultant extends ConsultancyService {
    private String consultantName;

    public Consultant(String serviceName, String consultantName) {
        super(serviceName);
        this.consultantName = consultantName;
    }

    @Override
    public void provideService() {
        System.out.println("\n" + consultantName + " is providing " + getServiceName() + " service.");
    }

    public void manageAppointments() {
        System.out.println(consultantName + " is managing appointments.");
    }
}

class ITConsultant extends Consultant {
    private String expertise;

    public ITConsultant(String serviceName, String consultantName, String expertise) {
        super(serviceName, consultantName);
        this.expertise = expertise;
    }

    @Override
    public void provideService() {
        super.provideService();
        System.out.println("Specialized in " + expertise);
    }

    public void conductCodeReview() {
        System.out.println("Conducting code review for " + getServiceName() + " service.\n");
    }
}

class LegalConsultant extends ConsultancyService {
    private String lawyerName;

    public LegalConsultant(String serviceName, String lawyerName) {
        super(serviceName);
        this.lawyerName = lawyerName;
    }

    @Override
    public void provideService() {
        System.out.println(lawyerName + " is providing " + getServiceName() + " service.");
    }

    public void provideLegalAdvice() {
        System.out.println(lawyerName + " is providing legal advice.");
    }
}

public class Lab_Prog_3 {
    public static void main(String[] args) {
        System.out.println("\n-------------Consultation Services-------------\n");
        Consultant consultant = new Consultant("HR Consultation", "Lakshmi");
        consultant.manageAppointments();

        ITConsultant itConsultant = new ITConsultant("IT Consultation", "Suraj", "Software Development");
        itConsultant.provideService();
        itConsultant.conductCodeReview();
        itConsultant.processPayment();
        itConsultant.requestFeedback();

        LegalConsultant legalConsultant = new LegalConsultant("Legal Consultation", "Vijay");
        legalConsultant.provideService();
        legalConsultant.provideLegalAdvice();
        legalConsultant.processPayment();
        legalConsultant.requestFeedback();

    }
}
