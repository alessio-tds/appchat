package umu.tds.apps;

import java.awt.event.ActionListener;
import java.util.Optional;

public class LoginController {
    private LoginModel model;
    private LoginView view;

    public LoginController() {
        model = new LoginModel();
        view = new LoginView();
    }

    public void run() {
        view.getSignInButton().addActionListener(ev -> {
            SigninController signin = new SigninController();
            signin.run();
            view.disposeFrame();
        });

        view.getConfirmButton().addActionListener(ev -> {
            User user = authenticateUser(model, view);
            if (user != null) {
                MainController main = new MainController(user);
                main.run();
                view.disposeFrame();
            }
        });

        view.showLoginWindow();
    }

    private User authenticateUser(LoginModel model, LoginView view) {
        String phoneNumber = view.getPhoneNumber();
        String password = view.getPassword();

        if (!model.isPhoneNumberValid(phoneNumber)) {
            System.out.println("Phone Number invalid!");
            return null;
        }

        if (!model.isPasswordValid(password)) {
            System.out.println("Password invalid!");
            return null;
        }

        if (!model.isPasswordCorrect(phoneNumber, password)) {
            System.out.println("Password incorrect or user not registered!");
            return null;
        }

        System.out.println("Completed!");
        return model.getUser(phoneNumber, password);
    }
}
