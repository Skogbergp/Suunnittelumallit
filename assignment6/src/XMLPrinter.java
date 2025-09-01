public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer printer) {
        super(printer);
    }
    public void print(String text) {
        super.print(XMLPrint(text));
    }
    private String XMLPrint(String Text){
        return "<Message>"+Text+"</Message>";
    }
}
