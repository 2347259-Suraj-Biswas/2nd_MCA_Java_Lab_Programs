package src.com.consulting.services;

import src.com.consulting.core.Consultant;
import src.com.consulting.core.Client;

public class BasicConsultingService implements ConsultingService {
    @Override
    public void performConsultation(Consultant consultant, Client client) {
        System.out.println("Consultation started...");
        System.out.println("Consultant: " + consultant.getName() + " with expertise in " + consultant.getExpertise());
        System.out.println("Client: " + client.getName() + " with contact person " + client.getContactPerson());
        System.out.println("Providing consultation...");
        System.out.println("Consultation completed.");
    }
}