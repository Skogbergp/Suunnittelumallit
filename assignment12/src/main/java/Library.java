import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private final HashMap<Integer,DocumentInterface> library = new HashMap<>();
    public void createUnprotectedDocument(String title , String content) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Document doc = new Document(title,timestamp,content);
        library.put(doc.getID(),doc);
    }
    public void createProtectedDocument(String title , String content) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Document doc = new Document(title,timestamp,content);
        library.put(doc.getID(),new DocumentProxy(doc));
    }
    public DocumentInterface getDocument(int ID) {
        return library.get(ID);
    }
   public ArrayList<DocumentInterface> getDocument(String title) {
       ArrayList<DocumentInterface>documents = new ArrayList<>();
        for (DocumentInterface doc : library.values()) {
            if (doc.getTitle().equalsIgnoreCase(title)) {
                documents.add(doc);
            }
        }
       return documents;
   }
}
