public class CityMap extends Map{

    @Override
    public Tile createTile() {
        switch((int) (Math.random() * 3)){
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            case 2: return new BuildingTile();
            default: return null;
        }

    }
}
