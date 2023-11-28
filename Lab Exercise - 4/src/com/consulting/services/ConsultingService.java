package src.com.consulting.services;

import src.com.consulting.core.Consultant;
import src.com.consulting.core.Client;

public interface ConsultingService {
    void performConsultation(Consultant consultant, Client client);
}