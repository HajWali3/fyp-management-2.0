import java.io.File;
import java.time.LocalDateTime;

public class Submission {
    private String studentName;
    private String projectTitle;
    private File file;
    private LocalDateTime timestamp;

    public Submission(String studentName, String projectTitle, File file) {
        this.studentName = studentName;
        this.projectTitle = projectTitle;
        this.file = file;
        this.timestamp = LocalDateTime.now();
    }

    public String getStudentName() {
        return studentName;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public File getFile() {
        return file;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
