//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new AFactory();
        factoryA.createButton("Button A");
        factoryA.createTextField("TextField A");
        factoryA.createCheckbox("Checkbox A");

        UIFactory factoryB = new BFactory();
        factoryB.createButton("Button B");
        factoryB.createTextField("TextField B");
        factoryB.createCheckbox("Checkbox B");
    }
}