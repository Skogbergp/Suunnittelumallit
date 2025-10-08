import java.awt.*;

public class PixelEditor {
    private int size;
    private int[][] pixels;
    private int cursorRow=0;
    private int cursorCol=0;

    private final Rectangle[][] views;

    public PixelEditor(int size,Rectangle[][] views) {
        this.size = size;
        views = new Rectangle[size][size];
        this.views = views;
        this.pixels = new int[size][size];
        refreshAll();
    }

}
