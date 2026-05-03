package ui;

import javax.swing.*;
import java.awt.*;

public class InterviewSchedulePanel extends JPanel {
    private JTextField txtAppId, txtTime;

    public InterviewSchedulePanel() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Assign Interview Slots");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        formPanel.add(new JLabel("Shortlisted Application ID:"));
        txtAppId = new JTextField();
        formPanel.add(txtAppId);

        formPanel.add(new JLabel("Interview Time (HH:MM):"));
        txtTime = new JTextField();
        formPanel.add(txtTime);

        AnimatedButton btnSubmit = new AnimatedButton("Schedule Interview", new Color(192, 57, 43), new Color(231, 76, 60));
        btnSubmit.addActionListener(e -> submit());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(btnSubmit);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void submit() {
        if (txtAppId.getText().trim().isEmpty() || txtTime.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Application ID and Time are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        service.InterviewService interviewService = new service.InterviewService();
        boolean success = interviewService.scheduleInterview(txtAppId.getText().trim(), txtTime.getText().trim());
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Interview Scheduled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            txtAppId.setText(""); txtTime.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to schedule interview. Check if Application ID is valid.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}