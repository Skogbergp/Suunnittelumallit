public class SwampTile implements Tile {
    @Override
    public void getCharacter() {
        // Implementation for getting the character in the swamp tile
        System.out.println("S");
    }

    @Override
    public void getDescription() {
        // Implementation for getting the description of the swamp tile
        System.out.println("This is a swamp tile with murky waters and dense vegetation.");
    }

    @Override
    public void action() {
        // Implementation for performing an action on the swamp tile
        System.out.println("You wade through the swamp, careful not to get stuck.");
    }
}
