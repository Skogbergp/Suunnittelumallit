public class ExpertState implements State{

    @Override
    public void train(Character character) {
        character.gainExperience(500);
        
    }

    @Override
    public void meditate(Character character) {
        character.addHealth(50);
    }

    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " fights bravely and gains experience!");
        character.gainExperience(700);
    }

    @Override
    public void advanceState(Character character) {
        if (character.getLevel() >= 50) {
            character.setCurrentState(new ExpertState());
            System.out.println(character.getName() + " has advanced to Expert State!");
        } else {
            System.out.println(character.getName() + " needs to reach level 50 to advance to Master State.");
        }
    }

}