import java.util.ArrayList;

public class Directory implements FileSystemElement{
ArrayList<FileSystemElement> elements = new ArrayList<>();
public Directory(){
}
    @Override
    public void accept(FileSystemVisitor visitor) {
    visitor.visit(this);
    for(FileSystemElement element : elements){
        element.accept(visitor);
    }

    }

    public void addElement(File file) {
    elements.add(file);
    }
    public void addElement(Directory directory) {
    elements.add(directory);
    }
}
