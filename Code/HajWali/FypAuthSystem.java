import java.util.*;

public class FypAuthSystem {
    // username -> [password, role]
    public static Map<String, String[]> users = new HashMap<>();

    static {
        users.put("haj", new String[] { "1234", "Student" });
        users.put("super1", new String[] { "5678", "Supervisor" });
        users.put("admin1", new String[] { "admin", "Admin" });
    }

    public static boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username)[0].equals(password);
    }

    public static String getUserRole(String username) {
        return users.get(username)[1];
    }
}
