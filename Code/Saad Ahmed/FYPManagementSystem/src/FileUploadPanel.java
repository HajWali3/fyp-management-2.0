import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FileUploadPanel extends JPanel {
    private JTextField nameField, projectTitleField;
    private JLabel selectedFileLabel;
    private File selectedFile;

    public FileUploadPanel() {
        setLayout(new GridLayout(5, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        nameField = new JTextField();
        projectTitleField = new JTextField();
        selectedFileLabel = new JLabel("No file selected.");

        JButton chooseFileBtn = new JButton("Choose File");
        chooseFileBtn.addActionListener(e -> chooseFile());

        JButton uploadBtn = new JButton("Upload Submission");
        uploadBtn.addActionListener(e -> uploadFile());

        add(new JLabel("Student Name:"));
        add(nameField);
        add(new JLabel("Project Title:"));
        add(projectTitleField);
        add(chooseFileBtn);
        add(selectedFileLabel);
        add(uploadBtn);
    }

    private void chooseFile() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            selectedFileLabel.setText("Selected: " + selectedFile.getName());
        }
    }

    private void uploadFile() {
        String name = nameField.getText().trim();
        String project = projectTitleField.getText().trim();

        if (name.isEmpty() || project.isEmpty() || selectedFile == null) {
            JOptionPane.showMessageDialog(this, "Please fill all fields and select a file.");
            return;
        }

        boolean success = SubmissionManager.saveSubmission(new Submission(name, project, selectedFile));
        if (success) {
            JOptionPane.showMessageDialog(this, "File uploaded successfully!");
            nameField.setText("");
            projectTitleField.setText("");
            selectedFileLabel.setText("No file selected.");
            selectedFile = null;
        } else {
            JOptionPane.showMessageDialog(this, "Failed to upload file.");
        }
    }
}
