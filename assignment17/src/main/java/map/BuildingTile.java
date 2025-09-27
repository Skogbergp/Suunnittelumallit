package map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BuildingTile implements Tile{

    int x;
    int y;

    Image img;
    public BuildingTile(int x, int y){
        img = TileGraphicFactory .getCityImage();
        this.x = x;
        this.y = y;
    }

    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getType() {
        return "Building";
    }


    public void draw(GraphicsContext gc){
        gc.drawImage(img,x,y);

    }
}
