public abstract class MessageHandler {
    MessageHandler nextHandler;

    private void setNextHandler(MessageHandler handler) {
        nextHandler = handler;
    }
    public abstract void handle(Message message);
}
