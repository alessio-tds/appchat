package umu.tds.apps;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Login {
    public static void showLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = createLoginFrame();
            frame.setVisible(true);
        });
    }

    private static JFrame createLoginFrame() { 
        JFrame frame = new JFrame();
        JPanel dataPanel = new JPanel();

        setupFrame(frame);
        setupDataPanel(dataPanel);

        frame.add(dataPanel);

        return frame;
    }

    private static void setupFrame(JFrame frame) {
        frame.setTitle("AppChat");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void setupDataPanel(JPanel dataPanel) {
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));

        JPanel phoneNumberPanel = createPhoneNumberPanel();
        JPanel passwordPanel = createPasswordPanel();

        dataPanel.add(phoneNumberPanel);
        dataPanel.add(passwordPanel);
    }

    private static JPanel createPhoneNumberPanel() {
        return createDataPanel("Phone Number");
    }

    private static JPanel createPasswordPanel() {
        return createDataPanel("Password");
    }

    private static JPanel createDataPanel(String labelText) {
        JPanel panel = new JPanel();

        JLabel label = new JLabel(labelText);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setColumns(20);
        panel.add(textField);

        return panel;
    }
}
