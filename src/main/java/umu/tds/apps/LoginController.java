package umu.tds.apps;

import java.awt.event.ActionListener;

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
            authenticateUser(model, view);
            view.disposeFrame();
        });

        view.showLoginWindow();
    }

    private ActionListener authenticateUser(LoginModel model, LoginView view) {
        return e -> {
            String phoneNumber = view.getPhoneNumber();
            String password = view.getPassword();
    
            if (!model.isPhoneNumberValid(phoneNumber)) {
                System.out.println("Phone Number invalid!");
                return;
            }
    
            if (!model.isPasswordValid(password)) {
                System.out.println("Password invalid!");
                return;
            }
    
            if (!model.isPasswordCorrect(phoneNumber, password)) {
                System.out.println("Password incorrect or user not registered!");
                return;
            }
    
            System.out.println("Completed!");
            return;
        };
    }
}
