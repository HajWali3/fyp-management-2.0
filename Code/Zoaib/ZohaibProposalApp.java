import javax.swing.*;

public class ZohaibProposalApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FYP System - Zohaib Ahmed");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JButton submitBtn = new JButton("Submit Proposal");
            JButton statusBtn = new JButton("Track Proposal Status");

            panel.add(submitBtn);
            panel.add(statusBtn);
            frame.add(panel);

            submitBtn.addActionListener(e -> {
                frame.setContentPane(new SubmitProposalPanel());
                frame.revalidate();
            });

            statusBtn.addActionListener(e -> {
                frame.setContentPane(new StatusTrackingPanel());
                frame.revalidate();
            });

            frame.setVisible(true);
        });
    }
}