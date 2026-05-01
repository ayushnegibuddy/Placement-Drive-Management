package ui;

import javax.swing.*;
import java.awt.*;

public class MainDashboard extends JFrame {
    private JPanel contentPanel;
    private CardLayout cardLayout;

    public MainDashboard() {
        setTitle("Placement Drive Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Sidebar
        JPanel sidebar = new JPanel(new GridLayout(7, 1, 10, 15));
        sidebar.setBackground(new Color(44, 62, 80));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        JLabel titleLabel = new JLabel("PDMS Portal");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sidebar.add(titleLabel);

        // Interactive Buttons
        AnimatedButton btnCompany = new AnimatedButton("Company Management", new Color(52, 73, 94), new Color(41, 128, 185));
        AnimatedButton btnDrive = new AnimatedButton("Drive Management", new Color(52, 73, 94), new Color(41, 128, 185));
        AnimatedButton btnApply = new AnimatedButton("Student Application", new Color(52, 73, 94), new Color(41, 128, 185));
        AnimatedButton btnShortlist = new AnimatedButton("Shortlisting", new Color(52, 73, 94), new Color(41, 128, 185));
        AnimatedButton btnInterview = new AnimatedButton("Interview Schedule", new Color(52, 73, 94), new Color(41, 128, 185));

        sidebar.add(btnCompany);
        sidebar.add(btnDrive);
        sidebar.add(btnApply);
        sidebar.add(btnShortlist);
        sidebar.add(btnInterview);

        // Content Area
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(new CompanyPanel(), "Company");
        contentPanel.add(new DrivePanel(), "Drive");
        contentPanel.add(new StudentApplicationPanel(), "Application");
        contentPanel.add(new ShortlistingPanel(), "Shortlist");
        contentPanel.add(new InterviewSchedulePanel(), "Interview");

        // Navigation Actions
        btnCompany.addActionListener(e -> cardLayout.show(contentPanel, "Company"));
        btnDrive.addActionListener(e -> cardLayout.show(contentPanel, "Drive"));
        btnApply.addActionListener(e -> cardLayout.show(contentPanel, "Application"));
        btnShortlist.addActionListener(e -> cardLayout.show(contentPanel, "Shortlist"));
        btnInterview.addActionListener(e -> cardLayout.show(contentPanel, "Interview"));

        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainDashboard().setVisible(true));
    }
}