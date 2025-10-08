public class RemoteController {
    private PixelEditor pixelEditor;
    private Command moveUpCommand;
    private Command moveDownCommand;
    private Command moveLeftCommand;
    private Command moveRightCommand;
    private Command pixelToggleCommand;
    private Command generateCodeCommand; // new

    public RemoteController(PixelEditor px) {
        this.pixelEditor = px;
        this.moveUpCommand = new MoveCursorUpCommand(pixelEditor);
        this.moveDownCommand = new MoveCursorDownCommand(pixelEditor);
        this.moveLeftCommand = new MoveCursorLeftCommand(pixelEditor);
        this.moveRightCommand = new MoveCursorRightCommand(pixelEditor);
        this.pixelToggleCommand = new TogglePixelCommand(pixelEditor);
        this.generateCodeCommand = new GenerateCodeCommand(pixelEditor); // init
    }

    public RemoteController(PixelEditor px, Command up, Command down, Command left, Command right, Command pxtoggle) {
        this.pixelEditor = px;
        this.moveUpCommand = up;
        this.moveDownCommand = down;
        this.moveLeftCommand = left;
        this.moveRightCommand = right;
        this.pixelToggleCommand = pxtoggle;
        this.generateCodeCommand = new GenerateCodeCommand(pixelEditor); // default generate
    }

    public void moveUp(){
        moveUpCommand.execute();
    }
    public void moveDown(){
        moveDownCommand.execute();
    }
    public void moveLeft(){
        moveLeftCommand.execute();
    }
    public void moveRight(){
        moveRightCommand.execute();
    }
    public void togglePixelToggle(){
        pixelToggleCommand.execute();
    }
    public void generateCode(){ generateCodeCommand.execute(); } // new
}
