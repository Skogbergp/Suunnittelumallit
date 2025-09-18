public class File implements FileSystemElement {
    private String fileName;
    private int fileSize;

    public File(String file, int i) {
        this.fileName = file;
        this.fileSize = i;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
    public int getFileSize() {
        return fileSize;
    }

    public String getFileName() {
        return fileName;
    }
}
