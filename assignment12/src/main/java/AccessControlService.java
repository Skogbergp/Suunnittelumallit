import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final HashMap<String, Set<Integer>> allowed = new HashMap<>();

    private AccessControlService() {

    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }
    public void allow(User u, DocumentInterface doc) {
        if (!allowed.containsKey(u.getUsername())) {
            HashSet<Integer> newSet = new HashSet<>();
            newSet.add(doc.getID());
            allowed.put(u.getUsername(),newSet);

        }else {
            allowed.get(u.getUsername()).add(doc.getID());
        }
    }

    public boolean isAllowed(User user, DocumentInterface doc) {
        if (!allowed.containsKey(user.getUsername())) {
            return false;
        }
        return allowed.get(user.getUsername()).contains(doc.getID());
    }
}