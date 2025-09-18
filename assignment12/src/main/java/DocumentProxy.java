public class DocumentProxy implements DocumentInterface {
    private final Document document;



    public DocumentProxy(Document document) {
        this.document = document;
    }

    @Override
    public String getContent(User user) {
        //TODO returns the document content for an allowed user. For a protected document, the proxy uses the AccessControlService object to check if the user is allowed to access the document.
       if (AccessControlService.getInstance().isAllowed(user, document)) {
           return document.getContent(user);
       }
        throw new AccessDeniedException("access denied for user: " + user);
    }

    @Override
    public int getID() {
        return document.getID();
    }

    @Override
    public String getTitle() {
        return "";
    }
    @Override
    public String getCreationDate(){
        //TODO: return the document creation date no need for accessControl
        return document.getCreationDate();
    }
}
