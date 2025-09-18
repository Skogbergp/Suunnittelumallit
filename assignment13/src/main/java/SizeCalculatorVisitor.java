public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int size;
    @Override
    public void visit(File file) {
        this.size += file.getFileSize();
    }

    @Override
    public void visit(Directory directory) {

    }
    public String getSize() {
        return size+" MB";
    }
}
