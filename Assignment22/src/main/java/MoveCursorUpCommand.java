public class MoveCursorUpCommand implements Command {
    private PixelEditor px;

    public MoveCursorUpCommand(PixelEditor pixelEditor) {
        this.px = pixelEditor;
    }

    @Override
    public void execute() {
        if (px.cursorRow > 0) { px.cursorRow--; px.refreshGrid(); }
    }
}
