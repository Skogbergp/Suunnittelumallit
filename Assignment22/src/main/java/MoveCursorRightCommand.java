public class MoveCursorRightCommand implements Command {
    private PixelEditor px;

    public MoveCursorRightCommand(PixelEditor px) {
        this.px = px;
    }

    @Override
    public void execute() {
        if (px.cursorCol < px.size - 1) { px.cursorCol++; px.refreshGrid(); }
    }
}
