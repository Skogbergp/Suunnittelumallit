public class AFactory extends UIFactory {
    @Override
    public void createButton(String text) {
        ButtonA buttonA = new ButtonA();
        buttonA.display(text);
    }

    @Override
    public void createTextField(String text) {
        TextFieldA textFieldA = new TextFieldA();
        textFieldA.display(text);

    }

    @Override
    public void createCheckbox(String text) {
        CheckboxA checkboxA = new CheckboxA();
        checkboxA.display(text);

    }
}
