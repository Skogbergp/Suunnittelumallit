package map;

import javafx.scene.image.Image;

public class TileGraphicFactory  {

    static Image forestTile = new Image("ForestTile.png");
    static Image cityTile = new Image("BuildingTile.png");
    static Image roadTile = new Image("RoadTile.png");

    public static Image getCityImage(){
        return cityTile;
    }
    public static Image getForestImage(){
        return forestTile;
    }
    public static Image getRoadImage(){
        return roadTile;
    }
}
