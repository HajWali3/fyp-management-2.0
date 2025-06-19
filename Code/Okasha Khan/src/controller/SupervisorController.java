package controller;

import model.Project;
import java.util.ArrayList;

public class SupervisorController {
    private ArrayList<Project> projects;

    public SupervisorController() {
        projects = new ArrayList<>();
        seedProjects();
    }

    private void seedProjects() {
        projects.add(new Project("Ali", "AI Chatbot"));
        projects.add(new Project("Sara", "E-Commerce System"));
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void submitReview(Project project, String review, String feedback) {
        project.setReview(review);
        project.setFeedback(feedback);
    }
}
