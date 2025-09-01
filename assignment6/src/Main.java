public class Main {
    public static void main(String[] args) {
        Printer printer;
        Printer printer2;

        printer = new BasicPrinter();
        printer.print("Hello World");

        printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World");

    }
}
