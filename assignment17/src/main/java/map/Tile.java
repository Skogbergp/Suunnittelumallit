package map;

import javafx.scene.canvas.GraphicsContext;

public interface Tile {
    public void draw(GraphicsContext gc);
    public char getCharacter();
    public String getType();
}
