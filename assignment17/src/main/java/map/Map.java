package map;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
public abstract class Map {
    Tile[][] tiles;
    GraphicsContext gc;
    int tileSize = 64;



    public abstract void createTile();

    public void display(){
        for (int y = 0; y < tiles[0].length; y++) {
            for (int x = 0; x < tiles.length; x++) {
                tiles[x][y].draw(gc);
                System.out.print(tiles[x][y].getCharacter());
            }
            System.out.println();
        }

    }

}
