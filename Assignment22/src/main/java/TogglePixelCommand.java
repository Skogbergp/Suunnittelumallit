public class TogglePixelCommand implements Command {
    private PixelEditor px;

    public TogglePixelCommand(PixelEditor px) {
        this.px = px;
    }

    @Override
    public void execute() {
        px.pixels[px.cursorRow][px.cursorCol] = px.pixels[px.cursorRow][px.cursorCol] == 0 ? 1 : 0;
        px.refreshGrid();
    }
}
