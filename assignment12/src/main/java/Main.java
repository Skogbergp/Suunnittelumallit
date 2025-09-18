public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create users
        User alice = new User("alice");
        User bob = new User("bob");

        // Create documents
        library.createUnprotectedDocument("Public Doc", "This is public content.");
        library.createProtectedDocument("Secret Doc", "Top secret content.");

        // Get documents by ID (IDs start from 1 in Document)
        DocumentInterface publicDoc = library.getDocument(1);
        DocumentInterface secretDoc = library.getDocument(2);

        // Grant access to Alice for the protected document
        AccessControlService.getInstance().allow(alice, secretDoc);

        // Test access
        System.out.println("=== Access Tests ===");

        try {
            System.out.println("Alice reads public doc: " + publicDoc.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println("Alice blocked from public doc: " + e.getMessage());
        }

        try {
            System.out.println("Bob reads public doc: " + publicDoc.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println("Bob blocked from public doc: " + e.getMessage());
        }

        try {
            System.out.println("Alice reads secret doc: " + secretDoc.getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println("Alice blocked from secret doc: " + e.getMessage());
        }

        try {
            System.out.println("Bob reads secret doc: " + secretDoc.getContent(bob));
        } catch (AccessDeniedException e) {
            System.out.println("Bob blocked from secret doc: " + e.getMessage());
        }
    }
}
