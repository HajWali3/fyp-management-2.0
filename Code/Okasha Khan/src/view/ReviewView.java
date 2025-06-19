package view;

import controller.SupervisorController;
import model.Project;

import javax.swing.*;
import java.awt.*;

public class ReviewView extends JFrame {
    public ReviewView(SupervisorController controller, Project project) {
        setTitle("Review: " + project.getProjectTitle());
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea reviewArea = new JTextArea(5, 30);
        JTextArea feedbackArea = new JTextArea(5, 30);

        JButton submitBtn = new JButton("Submit");

        submitBtn.addActionListener(e -> {
            controller.submitReview(project, reviewArea.getText(), feedbackArea.getText());
            JOptionPane.showMessageDialog(this, "Review Submitted!");
            dispose();
        });

        setLayout(new GridLayout(5, 1));
        add(new JLabel("Review:")); add(new JScrollPane(reviewArea));
        add(new JLabel("Feedback:")); add(new JScrollPane(feedbackArea));
        add(submitBtn);
    }
}
