public class GeneralHandler extends MessageHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL) {
            System.out.println("Handling general suggestion message: ");
            message.printDetails();
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        } else {
            System.out.println("No handler available for this message type.");
        }
    }
}
