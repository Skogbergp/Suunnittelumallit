public class Main {
    public static void main(String[] args) {
        // Create files
        File file1 = new File("report.txt", 120);
        File file2 = new File("notes.txt", 80);
        File file3 = new File("image.png", 200);
        File file4 = new File("report_final.txt", 150);

        // Create directories
        Directory root = new Directory();
        Directory subDir = new Directory();

        // Add files to directories
        root.addElement(file1);
        root.addElement(file2);
        subDir.addElement(file3);
        subDir.addElement(file4);
        root.addElement(subDir);

        // Search for files containing "report"
        SearchVisitor searchVisitor = new SearchVisitor("report");
        root.accept(searchVisitor);
        System.out.println("Files containing 'report':");
        searchVisitor.printList();

        // Calculate total size
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getSize());
    }
}
