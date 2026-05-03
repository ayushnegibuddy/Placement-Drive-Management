package ui;

import javax.swing.*;
import java.awt.*;

public class DrivePanel extends JPanel {
    private JTextField txtCompanyId, txtDate;

    public DrivePanel() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Create Placement Drive");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        formPanel.add(new JLabel("Company ID:"));
        txtCompanyId = new JTextField();
        formPanel.add(txtCompanyId);

        formPanel.add(new JLabel("Drive Date (YYYY-MM-DD):"));
        txtDate = new JTextField();
        formPanel.add(txtDate);

        AnimatedButton btnSubmit = new AnimatedButton("Create Drive", new Color(142, 68, 173), new Color(155, 89, 182));
        btnSubmit.addActionListener(e -> submit());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(btnSubmit);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void submit() {
        if (txtCompanyId.getText().trim().isEmpty() || txtDate.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Company ID and Date are required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        service.DriveService driveService = new service.DriveService();
        boolean success = driveService.createDrive(txtCompanyId.getText().trim(), txtDate.getText().trim());
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Drive scheduled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            txtCompanyId.setText(""); txtDate.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to schedule drive. Check if Company ID is valid.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}