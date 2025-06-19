package Zoaib;
import javax.swing.*;

import java.awt.*;
import java.time.LocalDateTime;

public class SubmitProposalPanel extends JPanel {
    public SubmitProposalPanel() {
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Submit Proposal", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(6, 2, 10, 10));
        JTextField titleField = new JTextField();
        JTextField objField = new JTextField();
        JTextField probField = new JTextField();
        JTextField toolField = new JTextField();
        JTextField teamField = new JTextField();

        form.add(new JLabel("Project Title:"));
        form.add(titleField);
        form.add(new JLabel("Objective:"));
        form.add(objField);
        form.add(new JLabel("Problem Statement:"));
        form.add(probField);
        form.add(new JLabel("Tools/Technologies:"));
        form.add(toolField);
        form.add(new JLabel("Team Members:"));
        form.add(teamField);

        JButton submitBtn = new JButton("Submit Proposal");
        JLabel msgLabel = new JLabel("", SwingConstants.CENTER);
JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(submitBtn, BorderLayout.CENTER);
        bottomPanel.add(msgLabel, BorderLayout.SOUTH);

        add(form, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        submitBtn.addActionListener(e -> {
            if (titleField.getText().isEmpty() || objField.getText().isEmpty() ||
                probField.getText().isEmpty() || toolField.getText().isEmpty() || teamField.getText().isEmpty()) {
                msgLabel.setText("Please fill all required fields.");
            } else {
                ProposalModel proposal = new ProposalModel(
                    titleField.getText(),
                    objField.getText(),
                    probField.getText(),
                    toolField.getText(),
                    teamField.getText(),
                    LocalDateTime.now().toString()
                );
                FakeDatabase.submittedProposal = proposal;
                msgLabel.setText("Proposal submitted successfully!");
                System.out.println("Supervisor notified via email (simulation).");
            }
        });
    }
}