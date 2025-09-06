package character;

public class BerserkState implements State {

    @Override
    public void train(Character character) {
        character.gainExperience(500);
        
    }

    @Override
    public void meditate(Character character) {
        character.addHealth(50);
    }

    @Override
    public void fight(Character character, Character enemyCharacter) {

    }

    @Override
    public void defend(Character character) {

    }


}