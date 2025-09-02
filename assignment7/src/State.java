
public interface State {
    public void train(Character character);
    public void meditate(Character character);
    public void fight(Character character);
    public void advanceState(Character character);

}
