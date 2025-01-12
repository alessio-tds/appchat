package umu.tds.apps;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;

public class Login {
    private static int frameWidth = 400;
    private static int frameHeight = 300;

    private static String titleText = "Login";
    private static String signInButtonText = "Sign In";
    private static String confirmButtonText = "Confirm";
    private static String phoneNumberLabelText = "Phone Number";
    private static String passwordLabelText = "Password";
    private static Font font = new Font("Roboto", Font.BOLD, 30);

    private static int closeOperation = JFrame.EXIT_ON_CLOSE;

    public static void showLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = createLoginFrame();
            frame.setVisible(true);
        });
    }

    private static JFrame createLoginFrame() { 
        JFrame frame = new JFrame();
        JPanel titlePanel = new JPanel();
        JPanel dataPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        setupFrame(frame);

        setupTitlePanel(titlePanel);
        frame.add(titlePanel, BorderLayout.NORTH);

        setupDataPanel(dataPanel);
        frame.add(dataPanel, BorderLayout.CENTER);

        setupButtonsPanel(buttonsPanel);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        return frame;
    }

    private static void setupFrame(JFrame frame) {
        frame.setTitle(App.name);
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(closeOperation);
    }

    private static void setupTitlePanel(JPanel titlePanel) {
        JLabel title = new JLabel();
        title.setText(titleText);
        title.setFont(font);
        titlePanel.add(title);
    }

    private static void setupDataPanel(JPanel dataPanel) {
        JPanel phoneNumberPanel = createPhoneNumberPanel();
        JPanel passwordPanel = createPasswordPanel();

        dataPanel.add(phoneNumberPanel, BorderLayout.CENTER);
        dataPanel.add(passwordPanel, BorderLayout.CENTER);
    }

    private static void setupButtonsPanel(JPanel buttonsPanel) {
        JButton signIn = new JButton(signInButtonText);
        JButton confirm = new JButton(confirmButtonText);

        signIn.addActionListener(ev -> {
            JOptionPane.showMessageDialog(buttonsPanel, "TODO: Sign In");
        });

        confirm.addActionListener(ev -> {
            JOptionPane.showMessageDialog(buttonsPanel, "TODO: Confirm");
        });

        buttonsPanel.add(signIn);
        buttonsPanel.add(confirm);
    }

    private static JPanel createPhoneNumberPanel() {
        return createDataPanel(phoneNumberLabelText);
    }

    private static JPanel createPasswordPanel() {
        return createDataPanel(passwordLabelText);
    }

    private static JPanel createDataPanel(String labelText) {
        JPanel panel = new JPanel();

        JLabel label = new JLabel(labelText);
        panel.add(label, BorderLayout.WEST);

        JTextField textField = new JTextField();
        textField.setColumns(20);
        panel.add(textField, BorderLayout.EAST);

        return panel;
    }
}
