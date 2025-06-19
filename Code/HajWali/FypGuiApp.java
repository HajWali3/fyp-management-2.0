import javax.swing.*;
import java.awt.*;

public class FypGuiApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FypGuiApp::showLoginScreen);
    }

    // Colors & fonts
    static Color primaryColor = new Color(0x1A73E8);
    static Color bgColor = new Color(240, 248, 255);
    static Font font = new Font("SansSerif", Font.PLAIN, 16);

    public static void showLoginScreen() {
        JFrame frame = new JFrame("FYP Login");
        frame.setSize(400, 260);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("FYP Management Login");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setForeground(primaryColor);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField usernameField = new JTextField(15);
        usernameField.setMaximumSize(new Dimension(300, 30));
        usernameField.setFont(font);

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setMaximumSize(new Dimension(300, 30));
        passwordField.setFont(font);

        JButton loginBtn = new JButton("Login");
        styleButton(loginBtn);

        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(loginBtn);

        frame.setContentPane(panel);
        frame.setVisible(true);

        loginBtn.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (FypAuthSystem.authenticate(username, password)) {
                String role = FypAuthSystem.getUserRole(username);
                frame.dispose();
                showDashboard(role, username);
            } else {
                JOptionPane.showMessageDialog(frame, "❌ Invalid username or password.");
            }
        });
    }

    public static void showDashboard(String role, String username) {
        JFrame dash = new JFrame(role + " Dashboard");
        dash.setSize(500, 300);
        dash.setLocationRelativeTo(null);
        dash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(roleColor(role));
        JLabel title = new JLabel("Welcome, " + username + " (" + role + ")");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);

        JButton logoutBtn = new JButton("Logout");
        styleButton(logoutBtn);

        JPanel bottom = new JPanel();
        bottom.setBackground(roleColor(role));
        bottom.add(logoutBtn);

        panel.add(title, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);

        dash.setContentPane(panel);
        dash.setVisible(true);

        logoutBtn.addActionListener(e -> {
            dash.dispose();
            showLoginScreen();
        });
    }

    private static Color roleColor(String role) {
        return switch (role) {
            case "Student" -> new Color(0x4285F4); // Blue
            case "Supervisor" -> new Color(0x0F9D58); // Green
            case "Admin" -> new Color(0xDB4437); // Red
            default -> new Color(0x616161); // Gray fallback
        };
    }

    private static void styleButton(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBackground(primaryColor);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setPreferredSize(new Dimension(100, 35));
        btn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
    }
}
