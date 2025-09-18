import java.nio.file.FileSystem;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}
