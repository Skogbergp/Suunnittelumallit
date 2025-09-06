package character;

public class DefenseState implements State {

    @Override
    public void train(Character character) {
        System.out.println(character.getName() + " is thoo strong to train");
    }

    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " is too strong to meditate");
    }

    @Override
    public void fight(Character character, Character enemyCharacter) {

    }

    @Override
    public void defend(Character character) {

    }

    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " is too strong to fight and enemies run away in fear");
        
    }

}