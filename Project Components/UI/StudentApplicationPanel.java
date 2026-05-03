package ui;

import javax.swing.*;
import java.awt.*;

public class StudentApplicationPanel extends JPanel {
    private JTextField txtStudentId, txtDriveId;

    public StudentApplicationPanel() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Apply for Drive");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        formPanel.add(new JLabel("Your Student ID:"));
        txtStudentId = new JTextField();
        formPanel.add(txtStudentId);

        formPanel.add(new JLabel("Drive ID:"));
        txtDriveId = new JTextField();
        formPanel.add(txtDriveId);

        AnimatedButton btnSubmit = new AnimatedButton("Submit Application", new Color(41, 128, 185), new Color(52, 152, 219));
        btnSubmit.addActionListener(e -> submit());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(btnSubmit);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void submit() {
        if (txtStudentId.getText().trim().isEmpty() || txtDriveId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Valid IDs are required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        service.ApplicationService appService = new service.ApplicationService();
        boolean success = appService.applyForDrive(txtStudentId.getText().trim(), txtDriveId.getText().trim());
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Application Submitted with Status 'Applied'!", "Success", JOptionPane.INFORMATION_MESSAGE);
            txtStudentId.setText(""); txtDriveId.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to submit application. Check if Student and Drive IDs are valid.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}