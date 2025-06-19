package view;

import controller.SupervisorController;
import model.Project;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    private SupervisorController controller;

    public DashboardView() {
        setTitle("Supervisor Dashboard");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controller = new SupervisorController();

        DefaultListModel<Project> listModel = new DefaultListModel<>();
        for (Project p : controller.getProjects()) {
            listModel.addElement(p);
        }

        JList<Project> projectList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(projectList);

        JButton reviewBtn = new JButton("Review Project");

        reviewBtn.addActionListener(e -> {
            Project selected = projectList.getSelectedValue();
            if (selected != null) {
                new ReviewView(controller, selected).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Select a project first");
            }
        });

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(reviewBtn, BorderLayout.SOUTH);
    }
}
