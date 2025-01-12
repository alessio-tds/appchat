package umu.tds.apps;

public class LoginModel {
    public boolean authenticateUser(String phoneNumber, String password) {
        if (!isPhoneNumberValid(phoneNumber)) {
            // TODO
            return false;
        }

        if (!isPasswordValid(password)) {
            // TODO
            return false;
        }

        if (!isPasswordCorrect(password)) {
            // TODO
            return false;
        }

        return true;
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO
        return false;
    }

    private boolean isPasswordValid(String password) {
        // TODO
        return false;
    }

    private boolean isPasswordCorrect(String password) {
        // TODO
        return false;
    }
}
