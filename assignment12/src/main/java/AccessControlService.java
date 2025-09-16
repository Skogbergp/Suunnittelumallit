public class AccessControlService {
    private static AccessControlService instance;

    public AccessControlService() {
        if (instance == null) {
            instance = new AccessControlService();
        }
    }
}
