package umu.tds.apps;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class SigninView {
    private JFrame frame;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNumberField;
    private JTextField passwordField;
    private JTextField repeatPasswordField;
    private JTextField dateOfBirthField;
    private JTextField greetingField;
    private JButton cancelButton;
    private JButton confirmButton;

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 300;
    private final int FIELD_COLUMNS = 20;

    private final String TITLE_TEXT = "Sign In";
    private final String CANCEL_BUTTON_TEXT = "Cancel";
    private final String CONFIRM_BUTTON_TEXT = "Confirm";
    private final String FIRST_NAME_LABEL_TEXT = "First Name";
    private final String LAST_NAME_LABEL_TEXT = "Last Name";
    private final String PHONE_NUMBER_LABEL_TEXT = "Phone Number";
    private final String PASSWORD_LABEL_TEXT = "Password";
    private final String REPEAT_PASSWORD_LABEL_TEXT = "Repeat Password";
    private final String DATE_OF_BIRTH_LABEL_TEXT = "Date of Birth (dd/mm/yyyy)";
    private final String GREETING_LABEL_TEXT = "Greeting";
    private final Font FONT = new Font("Roboto", Font.BOLD, 30);

    private final int CLOSE_OPERATION = JFrame.EXIT_ON_CLOSE;

    public SigninView() {
        frame = new JFrame();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        phoneNumberField = new JTextField();
        passwordField = new JTextField();
        repeatPasswordField = new JTextField();
        dateOfBirthField = new JTextField();
        greetingField = new JTextField();
        cancelButton = new JButton();
        confirmButton = new JButton();
    }

    public void showLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            setupSigninFrame();
            frame.setVisible(true);
        });
    }

    private void setupSigninFrame() {
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
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // First Name
        dataPanel.add(new JLabel(FIRST_NAME_LABEL_TEXT));
        firstNameField.setColumns(FIELD_COLUMNS);
        dataPanel.add(firstNameField);

        // Last Name
        dataPanel.add(new JLabel(LAST_NAME_LABEL_TEXT));
        lastNameField.setColumns(FIELD_COLUMNS);
        dataPanel.add(lastNameField);

        // Phone Number
        dataPanel.add(new JLabel(PHONE_NUMBER_LABEL_TEXT));
        phoneNumberField.setColumns(FIELD_COLUMNS);
        dataPanel.add(phoneNumberField);

        // Password
        dataPanel.add(new JLabel(PASSWORD_LABEL_TEXT));
        passwordField.setColumns(FIELD_COLUMNS);
        dataPanel.add(passwordField);

        // Repeat Password
        dataPanel.add(new JLabel(REPEAT_PASSWORD_LABEL_TEXT));
        repeatPasswordField.setColumns(FIELD_COLUMNS);
        dataPanel.add(repeatPasswordField);

        // Date of Birth
        dataPanel.add(new JLabel(DATE_OF_BIRTH_LABEL_TEXT));
        dateOfBirthField.setColumns(FIELD_COLUMNS);
        dataPanel.add(dateOfBirthField);

        // Greeting
        dataPanel.add(new JLabel(GREETING_LABEL_TEXT));
        greetingField.setColumns(FIELD_COLUMNS);
        dataPanel.add(greetingField);
    }

    private void setupButtonsPanel(JPanel buttonsPanel) {
        cancelButton.setText(CANCEL_BUTTON_TEXT);
        confirmButton.setText(CONFIRM_BUTTON_TEXT);

        buttonsPanel.add(cancelButton);
        buttonsPanel.add(confirmButton);
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public String getRepeatedPassword() {
        return repeatPasswordField.getText();
    }

    public String getDateOfBirth() {
        return dateOfBirthField.getText();
    }

    public String getGreeting() {
        return greetingField.getText();
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }
}
