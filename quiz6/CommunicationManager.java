package quiz6;

public interface CommunicationManager {
    void sendData(String data, String conversationHistory);
    String receiveData();
}
