public class MoveCursorLeftCommand implements Command {
    private PixelEditor px;

    public MoveCursorLeftCommand(PixelEditor px) {
        this.px = px;
    }

    @Override
    public void execute() {
        if (px.cursorCol > 0) { px.cursorCol--; px.refreshGrid(); }
    }
}
