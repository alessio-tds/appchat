package umu.tds.apps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class SigninModel {
    public boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^\\+?[0-9. ()-]{7,15}$");  
    }

    public boolean isPhoneNumberNotRegistered(String phoneNumber) {
        UserRepository repository = UserRepository.getInstance();
        return repository.getUserByPhoneNumber(phoneNumber) == null;
    }

    public boolean isPasswordValid(String password) {
        // TODO: Add a check (minimum number of characters, special characters, ...)
        return true;
    }

    public boolean isPasswordRepeatedCorrectly(String password, String repeatedPassword) {
        return password.equals(repeatedPassword);
    }

    public boolean isDateOfBirthValid(Optional<LocalDate> dateOfBirth) {
        return true;
    }

    public Optional<LocalDate> stringToLocalDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return Optional.of(LocalDate.parse(date, formatter));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void createNewUser(String firstName, String lastName, String phoneNumber, String password, Optional<LocalDate> dateOfBirth, Optional<String> image, String greeting) {
        String name = firstName + " " + lastName;
        User newUser = new User(name, phoneNumber, password, dateOfBirth, image, greeting);
        UserRepository repository = UserRepository.getInstance();
        repository.saveUser(newUser);
    }
}
