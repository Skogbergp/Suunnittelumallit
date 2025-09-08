//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MessageHandler contactHandler = new ContactHandler();
        MessageHandler general = new GeneralHandler();
        MessageHandler compensationHandler = new CompensationHandler();
        MessageHandler suggestionHandler = new SuggestionHandler();

        general.nextHandler = contactHandler;
        contactHandler.nextHandler = compensationHandler;
        compensationHandler.nextHandler = suggestionHandler;
        for (int i = 0; i < 10; i++) {
            Message msg =  generateMessage();
            System.out.println("Generated message: " + msg.getMessage() + " of type: " + msg.getType());
            general.handle(msg);
            System.out.println("--------------------------------------------------");
        }

    }
    public static Message generateMessage(){
        MessageType types = MessageType.values()[(int)(Math.random()*MessageType.values().length)];

        String msg = "This is a " + types + " message.";
        String email = generateEmail();
        return new Message(types, msg, email);

    }
    public static String generateEmail() {
        String[] names = {"alice", "bob", "charlie", "dave", "eve"};
        String[] lastNames = {"smith", "johnson", "williams", "jones", "brown"};
        String[] domains = {"example.com", "mail.com", "test.org"};
        String username = names[(int)(Math.random() * names.length)] + "." + lastNames[(int)(Math.random() * lastNames.length)];
        String domain = domains[(int)(Math.random() * domains.length)];
        return username + "@" + domain;
    }
}