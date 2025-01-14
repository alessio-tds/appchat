package umu.tds.apps;

public class LoginModel {
    public boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^\\+?[0-9. ()-]{7,15}$");  
    }

    public boolean isPasswordValid(String password) {
        // TODO: Add a check (minimum number of characters, special characters, ...)
        return true;
    }

    public boolean isPasswordCorrect(String phoneNumber, String password) {
        UserRepository repository = UserRepository.getInstance();
        User user = repository.getUserByPhoneNumber(phoneNumber);
        return user != null && user.getPassword().equals(password);
    }
}
