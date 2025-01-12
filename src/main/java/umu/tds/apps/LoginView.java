package umu.tds.apps;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;

public class LoginView {
    private JFrame frame;
    private JTextField phoneNumberField;
    private JTextField passwordField;
    private JButton signInButton;
    private JButton confirmButton;

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 300;
    private final int FIELD_COLUMNS = 20;

    private final String TITLE_TEXT = "Login";
    private final String SIGN_IN_BUTTON_TEXT = "Sign In";
    private final String CONFIRM_BUTTON_TEXT = "Confirm";
    private final String PHONE_NUMBER_LABEL_TEXT = "Phone Number";
    private final String PASSWORD_LABEL_TEXT = "Password";
    private final Font FONT = new Font("Roboto", Font.BOLD, 30);

    private final int CLOSE_OPERATION = JFrame.EXIT_ON_CLOSE;

    public LoginView() {
        frame = new JFrame();
        phoneNumberField = new JTextField();
        passwordField = new JTextField();
        signInButton = new JButton();
        confirmButton = new JButton();
    }

    public void showLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            setupLoginFrame();
            frame.setVisible(true);
        });
    }

    private void setupLoginFrame() { 
        JPanel titlePanel = new JPanel();
        JPanel dataPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        
        setupFrame();

        setupTitlePanel(titlePanel);
        frame.add(titlePanel, BorderLayout.NORTH);

        setupDataPanel(dataPanel);
        frame.add(dataPanel, BorderLayout.CENTER);

        setupButtonsPanel(buttonsPanel);
        frame.add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void setupFrame() {
        frame.setTitle(App.name);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(CLOSE_OPERATION);
    }

    private void setupTitlePanel(JPanel titlePanel) {
        JLabel title = new JLabel();
        title.setText(TITLE_TEXT);
        title.setFont(FONT);
        titlePanel.add(title);
    }

    private void setupDataPanel(JPanel dataPanel) {
        JPanel phoneNumberPanel = createPhoneNumberPanel();
        JPanel passwordPanel = createPasswordPanel();

        dataPanel.add(phoneNumberPanel, BorderLayout.CENTER);
        dataPanel.add(passwordPanel, BorderLayout.CENTER);
    }

    private void setupButtonsPanel(JPanel buttonsPanel) {
        signInButton.setText(SIGN_IN_BUTTON_TEXT);
        confirmButton.setText(CONFIRM_BUTTON_TEXT);

        buttonsPanel.add(signInButton);
        buttonsPanel.add(confirmButton);
    }

    private JPanel createPhoneNumberPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
            
        label.setText(PHONE_NUMBER_LABEL_TEXT);
        panel.add(label, BorderLayout.WEST);

        phoneNumberField.setColumns(FIELD_COLUMNS);
        panel.add(phoneNumberField, BorderLayout.EAST);

        return panel;
    }

    private JPanel createPasswordPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();

        label.setText(PASSWORD_LABEL_TEXT);
        panel.add(label, BorderLayout.WEST);

        passwordField.setColumns(FIELD_COLUMNS);
        panel.add(passwordField, BorderLayout.EAST);

        return panel;
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    public String getPasssord() {
        return passwordField.getText();
    }

    public JButton getSignInButton() {
        return signInButton;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }
}
