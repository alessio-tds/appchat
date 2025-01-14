package umu.tds.apps;

import java.util.Optional;
import java.time.LocalDate;

public class SigninController {
    private SigninModel model;
    private SigninView view;

    public SigninController() {
        model = new SigninModel();
        view = new SigninView();
    }

    public void run() {
        view.getCancelButton().addActionListener(ev -> {
            LoginController login = new LoginController();
            login.run();
            view.disposeFrame();
        });

        view.getConfirmButton().addActionListener(ev -> {
            String firstName = view.getFirstName();
            String lastName = view.getLastName();
            String phoneNumber = view.getPhoneNumber();
            String password = view.getPassword();
            String repeatedPassword = view.getRepeatedPassword();
            Optional<LocalDate> dateOfBirth = model.stringToLocalDate(view.getDateOfBirth());
            String greeting = view.getGreeting();

            if (!model.isPhoneNumberValid(phoneNumber)) {
                // TODO: popup
                System.out.println("Phone Number not valid");
            } else if (!model.isPhoneNumberNotRegistered(phoneNumber)) {
                // TODO: popup
                System.out.println("An account with the phone number already exists");
            } else if (!model.isPasswordValid(password)) {
                // TODO: popup
                System.out.println("Password not valid");
            } else if (!model.isPasswordRepeatedCorrectly(password, repeatedPassword)) {
                // TODO: popup
                System.out.println("The passwords don't match. Please try again.");
            } else if (!model.isDateOfBirthValid(dateOfBirth)) {
                // TODO: popup
                System.out.println("The date of birth format is not valid.");
            } else {
                model.createNewUser(firstName, lastName, phoneNumber, password, dateOfBirth, null, greeting);
                // Popup: user successfully created!
                LoginController login = new LoginController();
                login.run();
                view.disposeFrame();
            }
        });

        view.showLoginWindow();
    }
}
