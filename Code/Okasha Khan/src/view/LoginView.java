package view;

import javax.swing.*;
import java.awt.*;
import model.Supervisor;

public class LoginView extends JFrame {
    public LoginView() {
        setTitle("Supervisor Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            Supervisor supervisor = new Supervisor("admin", "1234");
            if (supervisor.login(username, password)) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new DashboardView().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
            }
        });

        setLayout(new GridLayout(3, 2, 10, 10));
        add(userLabel); add(userField);
        add(passLabel); add(passField);
        add(new JLabel()); add(loginBtn);
    }
}
