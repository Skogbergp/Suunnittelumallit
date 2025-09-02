public class MasterState implements State{

    @Override
    public void train(Character character) {
        System.out.println(character.getName() + " is thoo strong to train");
    }

    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " is too strong to meditate");
    }

    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " is too strong to fight and enemies run away in fear");
        
    }

    @Override
    public void advanceState(Character character) {
        System.out.println(character.getName() + " is already at the highest state: Master");
    }

}