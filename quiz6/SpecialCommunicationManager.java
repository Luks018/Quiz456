package quiz6;

public class SpecialCommunicationManager implements CommunicationManager {
    private String commonServiceUrl;
    private String specialServiceUrl;
    private String response;

    public SpecialCommunicationManager(String commonServiceUrl, String specialServiceUrl) {
        this.commonServiceUrl = commonServiceUrl;
        this.specialServiceUrl = specialServiceUrl;
    }

    @Override
    public void sendData(String data, String conversationHistory) {
        String serviceUrl = commonServiceUrl;

        if (data.contains("help") || conversationHistory.contains("help")) {
            serviceUrl = specialServiceUrl;
        }


        System.out.println("Sending data to " + serviceUrl + ": " + data);
        this.response = "Response from " + serviceUrl;
    }

    @Override
    public String receiveData() {
        return this.response;
    }

    public static void main(String[] args) {
        String commonServiceUrl = "http://common.service.url";
        String specialServiceUrl = "http://special.service.url";

        CommunicationManager specialManager = new SpecialCommunicationManager(commonServiceUrl, specialServiceUrl);
        UserInteractionManager interactionManager = new UserInteractionManager(specialManager);

        interactionManager.startInteraction();
    }
}
