// File: consultancy/ConsultancyService.java
package consultancy;

import java.util.Random;

// Generic interface representing a consultancy service
public interface ConsultancyService<T> {
    void provideService(T client);

    default ClientFeedback requestFeedback() {
        System.out.println("Requesting client feedback...");
        String feedbackText = getRandomFeedback();
        return new ClientFeedback(feedbackText);
    }

    default void registerClient(ClientRegistration registration) {
        System.out.println("Registering client: " + registration.getClientName());
    }

    private String getRandomFeedback() {
        Random random = new Random();
        boolean isPositive = random.nextBoolean();
        return isPositive ? "Positive feedback received" : "Negative feedback received";
    }
}
