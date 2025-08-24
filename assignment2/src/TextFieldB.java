public class TextFieldB extends TextField {
    @Override
    public void display(String text) {
        char border = '*';
        int len = text.length();
        for (int i = 0; i < len + 4; i++) {
            System.out.print(border);
        }
        System.out.println();
        System.out.println(border+" " + text + " "+border);
        for (int i = 0; i < len + 4; i++) {
            System.out.print(border);
        }
        System.out.println();
    }
}
