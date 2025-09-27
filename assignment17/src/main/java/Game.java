import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import map.BuildingTile;
import map.CityMap;

import java.awt.*;

public class Game extends Application{
    CityMap map;
    @Override
    public void start(Stage mainStage) throws Exception {

        final Canvas canvas = new Canvas(832, 640);
        Image image = new Image("ForestTile.png");

        GraphicsContext gc = canvas.getGraphicsContext2D();
        map = new CityMap(canvas);
        map.createTile();
        map.display();
        Group group = new Group(canvas);
        Scene scene = new Scene(group, 832, 640);


        mainStage.setScene(scene);
        mainStage.show();
        mainStage.setTitle("Game");

    }
}
