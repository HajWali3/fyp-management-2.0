package model;

public class Supervisor {
    private String username;
    private String password;

    public Supervisor(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }
}
