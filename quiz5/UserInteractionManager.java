package quiz5;

import java.util.Scanner;

public class UserInteractionManager {
    private CommunicationManager communicationManager;

    public UserInteractionManager(CommunicationManager communicationManager) {
        this.communicationManager = communicationManager;
    }

    public void startInteraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your message: ");
        String userMessage = scanner.nextLine();

        sendDataToRemoteService(userMessage);
        String response = receiveDataFromRemoteService();
        System.out.println("Response from chatbot: " + response);
    }

    public void sendDataToRemoteService(String data) {
        communicationManager.sendData(data);
    }

    public String receiveDataFromRemoteService() {
        return communicationManager.receiveData();
    }
}
