package umu.tds.apps;

public class SigninController {
    private SigninModel model;
    private SigninView view;

    public SigninController() {
        model = new SigninModel();
        view = new SigninView();
    }

    public void run() {
        view.showLoginWindow();
    }
}
