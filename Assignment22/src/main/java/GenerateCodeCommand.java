public class GenerateCodeCommand implements Command {
    private PixelEditor pixelEditor;

    public GenerateCodeCommand(PixelEditor pixelEditor) {
        this.pixelEditor = pixelEditor;
    }

    @Override
    public void execute() {
        System.out.println(generateArrayText());
        showDialog();
    }

    private void showDialog() {
        javafx.stage.Stage dialog = new javafx.stage.Stage();
        dialog.setTitle("Pixel Array Export / Import");
        javafx.scene.layout.VBox root = new javafx.scene.layout.VBox(8);
        root.setStyle("-fx-padding: 12;");
        javafx.scene.control.Label lbl = new javafx.scene.control.Label("Edit or copy the pixel array below. Press 'Load From Text' to apply.");
        javafx.scene.control.TextArea area = new javafx.scene.control.TextArea(generateArrayText());
        area.setPrefColumnCount(40);
        area.setPrefRowCount(12);
        javafx.scene.control.Button loadBtn = new javafx.scene.control.Button("Load From Text");
        javafx.scene.control.Button closeBtn = new javafx.scene.control.Button("Close");
        javafx.scene.layout.HBox buttons = new javafx.scene.layout.HBox(10, loadBtn, closeBtn);
        javafx.scene.control.Label status = new javafx.scene.control.Label();
        root.getChildren().addAll(lbl, area, buttons, status);

        loadBtn.setOnAction(e -> {
            try {
                int[][] parsed = parseArray(area.getText());
                pixelEditor.setPixels(parsed);
                pixelEditor.refreshGrid();
                status.setText("Loaded successfully.");
            } catch (IllegalArgumentException ex) {
                status.setText("Error: " + ex.getMessage());
            }
        });
        closeBtn.setOnAction(e -> dialog.close());
        javafx.scene.Scene scene = new javafx.scene.Scene(root, 600, 400);
        dialog.setScene(scene);
        dialog.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        dialog.show();
    }

    private String generateArrayText() {
        int[][] px = pixelEditor.getPixels();
        StringBuilder sb = new StringBuilder();
        sb.append("int[][] pixelArt = {\n");
        for (int r = 0; r < px.length; r++) {
            sb.append("    {");
            for (int c = 0; c < px[r].length; c++) {
                sb.append(px[r][c]);
                if (c < px[r].length - 1) sb.append(", ");
            }
            sb.append("}");
            if (r < px.length - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("}\n");
        sb.append("// You may also paste just 64 numbers separated by commas or whitespace.\n");
        return sb.toString();
    }

    private int[][] parseArray(String text) {
        if (text == null) throw new IllegalArgumentException("Input is null");
        java.util.List<Integer> values = new java.util.ArrayList<>();
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("-?\\d+").matcher(text);
        while (m.find()) {
            values.add(Integer.parseInt(m.group()));
        }
        if (values.size() != 64) {
            throw new IllegalArgumentException("Expected 64 integers (8x8), found " + values.size());
        }
        int[][] out = new int[8][8];
        int idx = 0;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                int v = values.get(idx++);
                if (v != 0 && v != 1) {
                    throw new IllegalArgumentException("Only 0 or 1 allowed, got " + v + " at position " + (idx-1));
                }
                out[r][c] = v;
            }
        }
        return out;
    }
}
