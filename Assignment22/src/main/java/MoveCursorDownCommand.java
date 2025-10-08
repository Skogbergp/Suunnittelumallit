public class MoveCursorDownCommand implements Command {
    private PixelEditor px;

    public MoveCursorDownCommand(PixelEditor px) {
        this.px = px;
    }

    @Override
    public void execute() {
        if (px.cursorRow < px.size - 1) { px.cursorRow++; px.refreshGrid(); }
    }
}
