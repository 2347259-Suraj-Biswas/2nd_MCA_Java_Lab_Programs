// File: ConsultancyMain.java
import consultancy.*;

public class ConsultancyMain {
    public static void main(String[] args) {
        
        // Creating a consultancy project for a software development service
        SoftwareDevelopmentService softwareService = new SoftwareDevelopmentService();
        ConsultancyProject<String> softwareProject = new ConsultancyProject<>("Software Development Project", softwareService);
        Consultant<String> softwareConsultant = new Consultant<>("Sanjay");

        // Performing consultation for software development
        System.out.println("=== Software Development Project ===");
        softwareConsultant.performConsultation("XYZ Corporation", softwareProject);
        ClientFeedback softwareFeedback = softwareProject.requestFeedback();
        System.out.println("Feedback: " + softwareFeedback.getFeedback());
        System.out.println(); 

        // Registering a client for marketing strategy service
        MarketingStrategyService marketingService = new MarketingStrategyService();
        marketingService.registerClient(new ClientRegistration("ABC Inc.", "abc@example.com"));

        // Creating a consultancy project for a marketing strategy service
        ConsultancyProject<Integer> marketingProject = new ConsultancyProject<>("Marketing Strategy Project", marketingService);
        Consultant<Integer> marketingConsultant = new Consultant<>("Suraj");

        // Performing consultation for marketing strategy
        System.out.println("=== Marketing Strategy Project ===");
        marketingConsultant.performConsultation(123, marketingProject);
        ClientFeedback marketingFeedback = marketingProject.requestFeedback();
        System.out.println("Feedback: " + marketingFeedback.getFeedback());

        // Demonstrating generic consultancy service and consultant
        ConsultancyService<String> genericService = new GenericConsultancyService<>();
        GenericConsultant<Double> genericConsultant = new GenericConsultant<>("Jannat");

        // Performing consultation for generic service
        System.out.println("\n=== Consultation ===");
        genericConsultant.performConsultation("ABC Commercial", genericService);

        // Using generic methods
        ClientRegistration genericClientRegistration = new ClientRegistration("Generic Corp.", "generic@example.com");
        registerGenericClient(genericService, genericClientRegistration);

        ClientFeedback genericFeedback = requestGenericFeedback(genericService);
        System.out.println("Feedback: " + genericFeedback.getFeedback());
    }

    // Generic method for requesting feedback
    public static <V> ClientFeedback requestGenericFeedback(ConsultancyService<V> service) {
        System.out.println("\n=== Feedback Request ===");
        return service.requestFeedback();
    }

    // Generic method for registering a client
    public static <W> void registerGenericClient(ConsultancyService<W> service, ClientRegistration registration) {
        System.out.println("\n=== Client Registration ===");
        service.registerClient(registration);
    }
}
