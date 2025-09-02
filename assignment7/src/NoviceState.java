public class NoviceState implements State{

    

    @Override
    public void train(Character character) {
        character.gainExperience(50);
        
    }

    @Override
    public void meditate(Character character) {
        System.out.println(character.getName() + " doesn't know how to meditate yet.");
    }

    @Override
    public void fight(Character character) {
        System.out.println(character.getName() + " is too weak to fight.");
    }

    @Override
    public void advanceState(Character character) {
        if (character.getLevel() >= 5) {
            System.out.println(character.getName() + " has advanced to Intermediate State!");
            character.setCurrentState(new IntermediateState());
        } else {
            System.out.println(character.getName() + " needs to reach level 5 to advance to Intermediate State.");
        }
        
    }

}