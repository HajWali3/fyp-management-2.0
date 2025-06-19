package Zoaib;
import javax.swing.*;

import java.awt.*;

public class StatusTrackingPanel extends JPanel {
    public StatusTrackingPanel() {
        setLayout(new BorderLayout());
        JLabel heading = new JLabel("Proposal Status", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        JTextArea statusArea = new JTextArea();
        statusArea.setEditable(false);
        add(new JScrollPane(statusArea), BorderLayout.CENTER);

        
        // Auto-load proposal status on panel load
        ProposalModel proposal = FakeDatabase.submittedProposal;
        if (proposal == null) {
            statusArea.setText("No proposal submitted yet.\nRedirecting to submission form...");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Title: ").append(proposal.getTitle()).append("\n");
            sb.append("Status: ").append(proposal.getStatus()).append("\n");
            if (proposal.getStatus().equals("Rejected")) {
                sb.append("Feedback: ").append(proposal.getFeedback()).append("\n");
            } else if (proposal.getStatus().equals("Pending")) {
                sb.append("Awaiting supervisor review.\n");
            }
            sb.append("Submitted On: ").append(proposal.getTimestamp());
            statusArea.setText(sb.toString());
        }


        JButton refreshBtn = new JButton("Refresh Status");
        add(refreshBtn, BorderLayout.SOUTH);

        refreshBtn.addActionListener(e -> {
            ProposalModel refreshedProposal = FakeDatabase.submittedProposal;
            if (refreshedProposal == null) {
                statusArea.setText("No proposal submitted yet.\nRedirecting to submission form...");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Title: ").append(refreshedProposal.getTitle()).append("\n");
                sb.append("Status: ").append(refreshedProposal.getStatus()).append("\n");
                if (refreshedProposal.getStatus().equals("Rejected")) {
                    sb.append("Feedback: ").append(refreshedProposal.getFeedback()).append("\n");
                } else if (refreshedProposal.getStatus().equals("Pending")) {
                    sb.append("Awaiting supervisor review.\n");
                }
                sb.append("Submitted On: ").append(refreshedProposal.getTimestamp());
                statusArea.setText(sb.toString());
            }
        });
    }
}