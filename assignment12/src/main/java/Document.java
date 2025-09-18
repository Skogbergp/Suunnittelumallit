public class Document implements DocumentInterface {
    private final int id;
    private final String title;
    private final String creationDate;
    private final String content;
    private static int counter = 0;


    public Document(String title, String creationDate, String content) {
        this.id = ++counter;
        this.title = title;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getCreationDate() {
        return this.creationDate;
    }

    @Override
    public String getContent(User user) {
        return this.content;
    }
    @Override
    public int getID(){
        return this.id;
    }

}
