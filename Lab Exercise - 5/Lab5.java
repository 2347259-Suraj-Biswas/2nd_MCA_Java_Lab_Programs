import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ConsultancyTask implements Runnable {
    private String clientName;
    private String service;
    private ClientFeedbackRepository feedbackRepository;

    public ConsultancyTask(String clientName, String service, ClientFeedbackRepository feedbackRepository) {
        this.clientName = clientName;
        this.service = service;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public void run() {
        // Simulate processing for the client request based on the service type
        processRequest();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Processing request for client: " + clientName);

        // Provide feedback after processing the request
        ClientFeedback feedback = generateFeedback();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nConsultancy work completed for client: " + clientName + ". Feedback received:\n" +
                "Rating: " + feedback.getRating() + "\nComment: " + feedback.getComment() + "\n");

        feedbackRepository.addFeedback(feedback);
    }

    private void processRequest() {
        // Simulate processing for different types of services
        if ("TaxAdvice".equalsIgnoreCase(service)) {
            System.out.println("Providing tax advice for client: " + clientName);
        } else if ("LegalGuidance".equalsIgnoreCase(service)) {
            System.out.println("Offering legal guidance for client: " + clientName);
        } else if ("BusinessStrategy".equalsIgnoreCase(service)) {
            System.out.println("Developing business strategy for client: " + clientName);
        } else {
            System.out.println("Invalid service type for client: " + clientName);
        }
    }

    private ClientFeedback generateFeedback() {
        // Simulate generating feedback with random ratings and comments
        int rating = (int) (Math.random() * 5) + 1; // Rating between 1 and 5
        String[] comments = {"Excellent service!", "Good advice, very helpful.", "Satisfactory experience.", "Needs improvement.", "Unsatisfactory service."};
        String comment = comments[(int) (Math.random() * comments.length)];

        return new ClientFeedback(rating, comment);
    }
}

class ClientFeedback {
    private int rating;
    private String comment;

    public ClientFeedback(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}

class ClientFeedbackRepository {
    private List<ClientFeedback> feedbackList;

    public ClientFeedbackRepository() {
        this.feedbackList = new ArrayList<>();
    }

    public void addFeedback(ClientFeedback feedback) {
        feedbackList.add(feedback);
    }

    public List<ClientFeedback> getAllFeedback() {
        return new ArrayList<>(feedbackList);
    }
}

class ConsultancyReport {
    private ClientFeedbackRepository feedbackRepository;

    public ConsultancyReport(ClientFeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void generateReport() {
        List<ClientFeedback> feedbackList = feedbackRepository.getAllFeedback();

        System.out.println("\nConsultancy Report:");
        System.out.println("-------------------");

        for (ClientFeedback feedback : feedbackList) {
            System.out.println("Client: " + feedback + ", Rating: " + feedback.getRating() + ", Comment: " + feedback.getComment());
        }
    }
}

public class Lab5 {
    public static void main(String[] args) {
        // Create a thread pool with a fixed number of threads
        int numberOfThreads = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        ClientFeedbackRepository feedbackRepository = new ClientFeedbackRepository();

        // Simulate multiple client requests with different services
        for (int i = 1; i <= 10; i++) {
            String clientName = "Client " + i;

            // Randomly select a service for each client
            String[] services = {"TaxAdvice", "LegalGuidance", "BusinessStrategy"};
            String service = services[(int) (Math.random() * services.length)];

            // Submit each client request as a task to the thread pool
            executorService.submit(new ConsultancyTask(clientName, service, feedbackRepository));
        }

        executorService.shutdown();
        System.out.println("\n");

        ConsultancyReport consultancyReport = new ConsultancyReport(feedbackRepository);
        consultancyReport.generateReport();
    }
}
