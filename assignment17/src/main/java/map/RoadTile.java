package map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class RoadTile  implements Tile {
    private int x;
    private int y;
    private Image img = TileGraphicFactory .getRoadImage();
    public RoadTile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(img,x,y);
    }

    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getType() {
        return "Road";
    }
}
