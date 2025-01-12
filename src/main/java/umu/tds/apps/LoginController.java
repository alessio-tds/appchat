package umu.tds.apps;

public class LoginController {
    public static void run() {
        LoginModel model = new LoginModel();
        LoginView view = new LoginView();

        view.getSignInButton().addActionListener(ev -> {
            // TODO
        });

        view.getConfirmButton().addActionListener(ev -> {
            String phoneNumber = view.getPhoneNumber();
            String password = view.getPasssord();

            if (model.authenticateUser(phoneNumber, password)) {
                // TODO: Login completed!
            }
        });

        view.showLoginWindow();
    }
}
