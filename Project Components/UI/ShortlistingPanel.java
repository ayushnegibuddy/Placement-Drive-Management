package ui;

import javax.swing.*;
import java.awt.*;

public class ShortlistingPanel extends JPanel {
    private JTextField txtAppId;
    private JComboBox<String> comboStatus;

    public ShortlistingPanel() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Shortlist Applications");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        formPanel.add(new JLabel("Application ID:"));
        txtAppId = new JTextField();
        formPanel.add(txtAppId);

        formPanel.add(new JLabel("New Status:"));
        comboStatus = new JComboBox<>(new String[]{"Shortlisted", "Rejected"});
        formPanel.add(comboStatus);

        AnimatedButton btnSubmit = new AnimatedButton("Update Status", new Color(211, 84, 0), new Color(230, 126, 34));
        btnSubmit.addActionListener(e -> submit());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(btnSubmit);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void submit() {
        if (txtAppId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Application ID is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        service.ApplicationService appService = new service.ApplicationService();
        String selectedStatus = (String) comboStatus.getSelectedItem();
        boolean success = appService.updateApplicationStatus(txtAppId.getText().trim(), selectedStatus);
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Status updated successfully to: " + selectedStatus, "Success", JOptionPane.INFORMATION_MESSAGE);
            txtAppId.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update status. Please check Application ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}