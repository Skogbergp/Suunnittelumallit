public class DocumentProxy implements DocumentInterface {
    private Document document;





    public String getContent() {
        //TODO returns the document content for an allowed user. For a protected document, the proxy uses the AccessControlService object to check if the user is allowed to access the document.
        return "";


    }
    public String getCreationDate(){
        //TODO: return the document creation date no need for accessControl
        return "";
    }
}
