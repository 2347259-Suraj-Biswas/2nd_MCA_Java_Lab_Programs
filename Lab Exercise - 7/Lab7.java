import java.util.ArrayList;
import java.util.List;

class Consultant {
    private String name;
    private String expertise;
    private int yearsOfExperience;
    private List<ConsultationResult> consultationHistory;

    public Consultant(String name, String expertise, int yearsOfExperience) {
        this.name = name;
        this.expertise = expertise;
        this.yearsOfExperience = yearsOfExperience;
        this.consultationHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void updateExpertise(String newExpertise) {
        this.expertise = newExpertise;
    }

    public void updateExperience(int newExperience) {
        this.yearsOfExperience = newExperience;
    }

    public void addConsultationToHistory(ConsultationResult result) {
        consultationHistory.add(result);
    }

    public List<ConsultationResult> getConsultationHistory() {
        return consultationHistory;
    }
}

class ConsultationResult {
    private String resultDetails;

    public ConsultationResult(String resultDetails) {
        this.resultDetails = resultDetails;
    }

    public String getResultDetails() {
        return resultDetails;
    }
}

@FunctionalInterface
interface ConsultationTask {
    ConsultationResult performTask(Consultant consultant, int duration);
}

interface ConsultancyService {
    ConsultationResult performConsultation(ConsultationTask task, Consultant consultant, int duration);
    void updateConsultant(Consultant consultant, String newExpertise, int newExperience);
}

class ConsultationReport {
    public void generateReport(ConsultationResult result, int duration) {
        System.out.println("Generating consultation report...");
        System.out.println("Consultation Result: " + result.getResultDetails());
        System.out.println("Consultation Duration: " + duration + " hours");
    }
}

public class Lab7 {
    public static void main(String[] args) {

        List<Consultant> consultants = new ArrayList<>();
        consultants.add(new Consultant("Suraj", "Software Development", 8));
        consultants.add(new Consultant("Suvajit", "Marketing", 10));
        consultants.add(new Consultant("Jannat", "Software Development", 5));

        ConsultancyService consultancyService = new ConsultancyService() {
            @Override
            public ConsultationResult performConsultation(ConsultationTask task, Consultant consultant, int duration) {

                System.out.println("\nConsultation with " + consultant.getName() +
                        " (Expertise: " + consultant.getExpertise() +
                        ", Experience: " + consultant.getYearsOfExperience() + " years)");

                ConsultationResult result = task.performTask(consultant, duration);

                System.out.println("Performing post-consultation tasks...");

                return result;
            }

            @Override
            public void updateConsultant(Consultant consultant, String newExpertise, int newExperience) {
                System.out.println("Updating consultant information...");
                consultant.updateExpertise(newExpertise);
                consultant.updateExperience(newExperience);
            }
        };

        ConsultationReport consultationReport = new ConsultationReport();

        ConsultationTask softwareConsultation = (consultant, duration) -> {
            System.out.println("Providing software consultancy services");

            return new ConsultationResult(consultant.getExpertise() + " Consultation Successful");
        };

        ConsultationTask marketingConsultation = (consultant, duration) -> {
            System.out.println("Providing marketing consultancy services");

            return new ConsultationResult(consultant.getExpertise() + " Consultation Successful");
        };

        Consultant consultantToUpdate = consultants.get(0); 
        String newExpertise = "Data Science";
        int newExperience = 9;
        consultancyService.updateConsultant(consultantToUpdate, newExpertise, newExperience);

        System.out.println("\nConsultant Information Updated:");
        System.out.println(consultantToUpdate.getName() + " - " +
                consultantToUpdate.getExpertise() + " - " +
                consultantToUpdate.getYearsOfExperience() + " years of experience");

        for (Consultant consultant : consultants) {
            if (consultant.getExpertise().equals("Software Development")) {
                int customDuration = 2;
                ConsultationResult softwareResult = consultancyService.performConsultation(softwareConsultation, consultant, customDuration);
                consultant.addConsultationToHistory(softwareResult);
                consultationReport.generateReport(softwareResult, customDuration);
            } 
            else if (consultant.getExpertise().equals("Marketing")) {
                int customDuration = 1; 
                ConsultationResult marketingResult = consultancyService.performConsultation(marketingConsultation, consultant, customDuration);
                consultant.addConsultationToHistory(marketingResult);
                consultationReport.generateReport(marketingResult, customDuration);
            }
        }

        List<Consultant> filteredConsultants = filterConsultants(consultants,
                consultant -> consultant.getExpertise().equals("Software Development") &&
                        consultant.getYearsOfExperience() >= 5);

        System.out.println("\nFiltered Consultants:");
        for (Consultant consultant : filteredConsultants) {
            System.out.println(consultant.getName() + " - " +
                    consultant.getExpertise() + " - " +
                    consultant.getYearsOfExperience() + " years of experience");
        }
    }

    private static List<Consultant> filterConsultants(List<Consultant> consultants, ConsultantFilter filter) {
        List<Consultant> filteredList = new ArrayList<>();
        for (Consultant consultant : consultants) {
            if (filter.test(consultant)) {
                filteredList.add(consultant);
            }
        }
        return filteredList;
    }

    @FunctionalInterface
    interface ConsultantFilter {
        boolean test(Consultant consultant);
    }
}
