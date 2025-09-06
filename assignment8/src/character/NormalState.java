package character;

public class NormalState implements State {



    @Override
    public void train(Character character) {
        character.gainExperience(50);
        
    }

    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " doesn't know how to meditate yet.");
    }

    @Override
    public void fight(Character player, Character enemy) {
        int levelDiff = player.getLevel() - enemy.getLevel();
        ;
    }

    @Override
    public void defend(Character character) {

    }

}