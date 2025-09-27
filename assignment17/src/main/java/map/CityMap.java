package map;

import javafx.scene.canvas.Canvas;

public class CityMap extends Map {
    private int x= 0;
    private int y= 0;
    private int width= 832;
    private int height= 640;
    int TILE_SIZE = 64;
    int tilesX = width/TILE_SIZE;
    int tilesY = height/TILE_SIZE;

    public CityMap(Canvas canvas) {
        this.height = (int) canvas.getHeight();
        this.width = (int)canvas.getWidth();
        this.gc = canvas.getGraphicsContext2D();

    }

    @Override
    public void createTile(){

        tiles = new Tile[tilesX][tilesY];

        for (int y = 0; y < tilesY; y++) {
            for (int x = 0; x < tilesX; x++) {
                int px = x * TILE_SIZE;
                int py = y * TILE_SIZE;

                Tile tile;
                switch ((int) (Math.random() * 3)) {
                    case 0: tile = new RoadTile(px, py); break;
                    case 1: tile = new ForestTile(px, py); break;
                    case 2: tile = new BuildingTile(px, py); break;
                    default: tile = new RoadTile(px, py); break;
                }

                tiles[x][y] = tile;
            }
        }
    }

}
