// File: consultancy/MarketingStrategyService.java
package consultancy;

// Class representing a specific marketing strategy consultancy service
public class MarketingStrategyService implements ConsultancyService<Integer> {
    @Override
    public void provideService(Integer client) {
        System.out.println("Providing marketing strategy consultancy service");
        System.out.println("Client ID: " + client);
    }
}
