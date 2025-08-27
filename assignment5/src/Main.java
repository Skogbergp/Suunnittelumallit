//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFileName("new_log.txt"); // Change file name
        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Processing data...");
        logger.write("Current Time is: " + java.time.LocalDateTime.now());
        logger.write("Simulation finished");
        logger.close();
        System.out.println("Log written to new_log.txt");
    }
}