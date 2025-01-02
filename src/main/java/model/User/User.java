package model.User;

public class User {
    private String email;
    private String password;
    private final boolean isAdmin;
    public User(String email) {
        this.email = email;
        this.isAdmin = false;
        this.password = "password";
    }

    public User(String email, boolean isAdmin) {
        this.email = email;
        this.isAdmin = isAdmin;
        this.password = "password";
    }

    public User(String email, String password, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.isAdmin = false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
