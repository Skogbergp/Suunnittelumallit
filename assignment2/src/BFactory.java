public class BFactory extends UIFactory{
    @Override
    public void createButton(String text) {
        ButtonB buttonB = new ButtonB();
        buttonB.display(text);

    }

    @Override
    public void createTextField(String text) {
        TextFieldB textFieldB = new TextFieldB();
        textFieldB.display(text);

    }

    @Override
    public void createCheckbox(String text) {
        CheckboxB checkboxB = new CheckboxB();
        checkboxB.display(text);

    }
}
