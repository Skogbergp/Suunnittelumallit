import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PixelEditor extends Application {
    public int size;
    public int[][] pixels;
    public int cursorRow=0;
    public int cursorCol=0;
    private RemoteController controller = new RemoteController(this);
    private GridPane grid; // grid retained for refresh

    public PixelEditor() {}

    @Override
    public void start(Stage stage) throws Exception {
        size = 8;
        pixels = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                pixels[row][col] = 0;
            }
        }
        grid = buildGrid();
        // New button replacing G key shortcut
        Button exportImportBtn = new Button("Export / Import");
        exportImportBtn.setOnAction(e -> {
            controller.generateCode();
            grid.requestFocus(); // return focus for continued keyboard movement
        });
        VBox root = new VBox(8, exportImportBtn, grid);
        root.setStyle("-fx-padding:10; -fx-background-color:#f5f5f5;");
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(e -> {
            KeyCode code = e.getCode();
            switch (code) {
                case UP: case W: controller.moveUp(); break;
                case DOWN: case S: controller.moveDown(); break;
                case LEFT: case A: controller.moveLeft(); break;
                case RIGHT: case D: controller.moveRight(); break;
                case SPACE: controller.togglePixelToggle(); break;
                // Removed G key binding per request
                default: break;
            }
        });
        stage.setTitle("Pixel Editor");
        stage.setScene(scene);
        stage.show();
        grid.requestFocus();
    }

    private GridPane buildGrid() {
        GridPane g = new GridPane();
        int cellSize = 40;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle rect = new Rectangle(cellSize, cellSize);
                rect.setFill(pixels[row][col] == 0 ? Color.WHITE : Color.BLACK);
                if (row == cursorRow && col == cursorCol) {
                    rect.setStroke(Color.RED);
                    rect.setStrokeWidth(3);
                } else {
                    rect.setStroke(Color.LIGHTGRAY);
                    rect.setStrokeWidth(1);
                }
                g.add(rect, col, row);
            }
        }
        return g;
    }


    public void toggleCurrentPixel() {

    }

    void refreshGrid() { // package-private so commands can call indirectly via methods above
        grid.getChildren().clear();
        int cellSize = 40;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle rect = new Rectangle(cellSize, cellSize);
                rect.setFill(pixels[row][col] == 0 ? Color.WHITE : Color.BLACK);
                if (row == cursorRow && col == cursorCol) {
                    rect.setStroke(Color.RED);
                    rect.setStrokeWidth(3);
                } else {
                    rect.setStroke(Color.LIGHTGRAY);
                    rect.setStrokeWidth(1);
                }
                grid.add(rect, col, row);
            }
        }
        grid.requestFocus();
    }


    public int getCursorRow() { return cursorRow; }
    public int getCursorCol() { return cursorCol; }
    public int[][] getPixels() { return pixels; }
    public void setPixels(int[][] pixels){ this.pixels = pixels; }
}