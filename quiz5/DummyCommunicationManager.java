package quiz5;

public class DummyCommunicationManager implements CommunicationManager {
    @Override
    public void sendData(String data) {
        System.out.println("Sending data to remote service: " + data);
    }

    @Override
    public String receiveData() {
        return "This is a dummy response from the remote service.";
    }

    public static void main(String[] args) {
        CommunicationManager dummyManager = new DummyCommunicationManager();
        UserInteractionManager interactionManager = new UserInteractionManager(dummyManager);

        interactionManager.startInteraction();
    }
}

