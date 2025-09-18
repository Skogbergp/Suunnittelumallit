public class User {
    private final String username;


    public User(String name) {
        this.username = name;
    }
    public String getUsername() {
        return this.username;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
