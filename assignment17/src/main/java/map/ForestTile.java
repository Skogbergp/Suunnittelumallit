package map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ForestTile implements Tile{
    private int x;
    private int y;

    Image img = ImageUtil.getForestImage();

    public ForestTile(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(img,x,y);
    }

    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "Forest";
    }
}
