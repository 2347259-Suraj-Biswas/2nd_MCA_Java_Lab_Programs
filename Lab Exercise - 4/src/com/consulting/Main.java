package src.com.consulting;

import src.com.consulting.core.AbstractClient;
import src.com.consulting.core.AbstractConsultant;
import src.com.consulting.core.Consultant;
import src.com.consulting.core.Client;
import src.com.consulting.services.BasicConsultingService;
import src.com.consulting.services.ConsultingService;

public class Main {
    public static void main(String[] args) {
        // Create a default consultant
        Consultant defaultConsultant = new AbstractConsultant("Suraj") {
        };
        defaultConsultant.setExpertise("IT");

        // Create a customized consultant
        Consultant customizedConsultant = new AbstractConsultant("Hrishabh") {
            @Override
            public void provideConsultation() {
                System.out.println("Customized consultation provided by " + getName());
                System.out.println("Expertise: " + getExpertise());
            }
        };
        customizedConsultant.setExpertise("Business Strategy");

        // Create a default client
        Client defaultClient = new AbstractClient("Pavan") {
        };
        defaultClient.setContactPerson("Jannat");

        // Create a customized client
        Client customizedClient = new AbstractClient("Manoswita") {
            @Override
            public void requestConsultation() {
                System.out.println("Customized consultation requested by " + getName());
                System.out.println("Contact Person: " + getContactPerson());
            }
        };
        customizedClient.setContactPerson("Suvajit");

        ConsultingService consultingService = new BasicConsultingService();

        System.out.println("\nDefault consultant and client methods called:");
        // Perform consultation with the default consultant and client
        consultingService.performConsultation(defaultConsultant, defaultClient);
        System.out.println("\n");

        System.out.println("Overrided and customized the consultant and client methods:");
        // Perform consultation with the customized consultant and client
        consultingService.performConsultation(customizedConsultant, customizedClient);
    }
}