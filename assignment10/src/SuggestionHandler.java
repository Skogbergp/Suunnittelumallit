public class SuggestionHandler extends MessageHandler {
    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.SUGGESTION) {
            System.out.println("Handling suggestion message: " + message.getMessage());
            message.printDetails();
        } else {
            this.nextHandler.handle(message);

        }
    }
}
