import java.io.*;
import java.nio.file.*;
import java.time.format.DateTimeFormatter;

public class SubmissionManager {
    private static final String SUBMISSION_DIR = "submissions";

    public static boolean saveSubmission(Submission sub) {
        try {
            File dir = new File(SUBMISSION_DIR);
            if (!dir.exists()) {
                dir.mkdir();
            }

            String timeStamp = sub.getTimestamp().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String newFileName = sub.getStudentName().replaceAll("\\s+", "_") + "_" +
                                 sub.getProjectTitle().replaceAll("\\s+", "_") + "_" + timeStamp +
                                 "_" + sub.getFile().getName();

            Path dest = Paths.get(SUBMISSION_DIR, newFileName);
            Files.copy(sub.getFile().toPath(), dest, StandardCopyOption.REPLACE_EXISTING);

            // Optional: Save a log or metadata if needed
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

