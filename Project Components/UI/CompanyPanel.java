package ui;

import javax.swing.*;
import java.awt.*;

public class CompanyPanel extends JPanel {
    private JTextField txtName, txtLocation;

    public CompanyPanel() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Register New Company");
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 20));
        formPanel.add(new JLabel("Company Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Location:"));
        txtLocation = new JTextField();
        formPanel.add(txtLocation);

        AnimatedButton btnSubmit = new AnimatedButton("Add Company", new Color(39, 174, 96), new Color(46, 204, 113));
        btnSubmit.addActionListener(e -> submit());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(btnSubmit);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void submit() {
        if (txtName.getText().trim().isEmpty() || txtLocation.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        service.CompanyService companyService = new service.CompanyService();
        boolean success = companyService.registerCompany(txtName.getText().trim(), txtLocation.getText().trim());
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Company added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            txtName.setText(""); txtLocation.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add company. Please check your database connection.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
