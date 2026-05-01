import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SwingDemo
{
    private static int clickCount = 0;
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Swing Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new FlowLayout());
            JTextField nameField = new JTextField(15);
            JButton greetButton = new JButton("Greet");
            JButton resetButton = new JButton("Reset");
            JLabel outputLabel = new JLabel("Enter your name above");
            // Greet button action
            greetButton.addActionListener(e -> {
                clickCount++;
                String name = nameField.getText();
                outputLabel.setText("Hello " + name + " (Clicks: " + clickCount + ")");
            });
            // Reset button action
            resetButton.addActionListener(e -> {
                clickCount = 0;
                nameField.setText("");
                outputLabel.setText("Enter your name above");
            });
            frame.add(nameField);
            frame.add(greetButton);
            frame.add(resetButton);
            frame.add(outputLabel);
            frame.setVisible(true);
        });
    }
}