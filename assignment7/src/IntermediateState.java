public class IntermediateState implements State{

    @Override
    public void train(Character character) {
        character.gainExperience(200);
        character.checkLevelUp();
    }
    @Override
    public void meditate(Character character) {
        character.addHealth(20);
        character.checkLevelUp();
    }
    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " is too weak to fight.");
    }
    @Override
    public void advanceState(Character character) {
        if (character.getLevel() >= 20) {
            character.setCurrentState(new ExpertState());
            System.out.println(character.getName() + " has advanced to Expert State!");
        } else {
            System.out.println(character.getName() + " needs to reach level 20 to advance to Expert State.");
        }
    }

}