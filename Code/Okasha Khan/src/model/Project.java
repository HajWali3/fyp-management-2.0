package model;
import java.io.Serializable;

public class Project implements Serializable {
    private String studentName;
    private String projectTitle;
    private String review;
    private String feedback;

    public Project(String studentName, String projectTitle) {
        this.studentName = studentName;
        this.projectTitle = projectTitle;
    }

    public String getStudentName() { return studentName; }
    public String getProjectTitle() { return projectTitle; }
    public String getReview() { return review; }
    public String getFeedback() { return feedback; }

    public void setReview(String review) { this.review = review; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    @Override
    public String toString() {
        return projectTitle + " by " + studentName;
    }
}

