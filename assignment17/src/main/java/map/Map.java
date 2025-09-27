package map;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
public abstract class Map {
    ArrayList<Tile> tiles = new ArrayList<>();
    GraphicsContext gc;


    public abstract void createTile();

    public void display(){
        for (Tile tile : tiles) {
            tile.draw(gc);
        }
    }

}
