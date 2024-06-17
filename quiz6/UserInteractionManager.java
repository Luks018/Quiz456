package quiz6;

import java.util.Scanner;

public class UserInteractionManager {
    private CommunicationManager communicationManager;
    private StringBuilder conversationHistory;

    public UserInteractionManager(CommunicationManager communicationManager) {
        this.communicationManager = communicationManager;
        this.conversationHistory = new StringBuilder();
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
        conversationHistory.append(data).append("\n");
        communicationManager.sendData(data, conversationHistory.toString());
    }

    public String receiveDataFromRemoteService() {
        return communicationManager.receiveData();
    }
}
