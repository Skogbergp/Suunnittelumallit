public class CompensationHandler extends MessageHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("Handling compensation message: " + message.getMessage());
            message.printDetails();
        } else {
            this.nextHandler.handle(message);
        }
    }
}
