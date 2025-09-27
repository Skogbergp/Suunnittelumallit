package map;

import javafx.scene.canvas.Canvas;

public class CityMap extends Map {
    private int x= 0;
    private int y= 0;
    private int width= 832;
    private int height= 640;

    public CityMap(Canvas canvas) {
        this.height = (int) canvas.getHeight();
        this.width = (int)canvas.getWidth();
        this.gc = canvas.getGraphicsContext2D();

    }

    @Override
    public void createTile(){
        int tileSize = 64;
        int tilesX = (int) (width / tileSize);
        int tilesY = (int) (height / tileSize);

        for (int y = 0; y < tilesY; y++) {
            for (int x = 0; x < tilesX; x++) {
                int px = x * tileSize;
                int py = y * tileSize;

                switch ((int) (Math.random() * 3)) {
                    case 0:
                        tiles.add(new RoadTile(px, py));
                        break;
                    case 1:
                        tiles.add(new ForestTile(px, py));
                        break;
                    case 2:
                        tiles.add(new BuildingTile(px, py));
                        break;
                }
            }
        }
    }

}
