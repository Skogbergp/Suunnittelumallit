public class WildernessMap extends Map{
    @Override
    public void createTile() {
        for (int i = 0; i < 9; i++) {
            switch ((int) (Math.random() * 3)) {
                case 0:
                    tiles.add(new WaterTile());
                    break;
                case 1:
                    tiles.add(new ForestTile());
                    break;
                case 2:
                    tiles.add(new SwampTile());
                    break;
            }
        }
    }
}
