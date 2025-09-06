
public class DecryptPrinter implements Printer {

    public DecryptPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String text) {
        super.print(CaesarCipher(text,-1));

    }

     public String CaesarCipher(String text,int shift) {

        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char shifted = (char) ((c-base+shift)%26 + base);
                result.append(shifted);
            }else{
                result.append(c);
            }
        }
        return result.toString();
    }

}
