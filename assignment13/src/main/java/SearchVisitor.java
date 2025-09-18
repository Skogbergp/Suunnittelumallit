import java.util.ArrayList;

public class SearchVisitor implements FileSystemVisitor {
    private String keyword;
    ArrayList<File> files = new ArrayList<>();

    public SearchVisitor(String report) {
        keyword = report;
    }

    @Override
    public void visit(File file) {
        if(file.getFileName().contains(keyword)) {
            files.add(file);
        }

    }

    @Override
    public void visit(Directory directory) {

    }
    public void printList() {
        for(File file : files) {
            System.out.println(file.getFileName());
        }
    }
}
