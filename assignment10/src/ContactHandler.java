public class ContactHandler extends MessageHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT) {
            System.out.println("Contact type message is being handled");
            message.printDetails();
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        } else {
            System.out.println("No handler available for this message type.");
        }
    }
}
