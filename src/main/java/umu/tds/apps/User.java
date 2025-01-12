package umu.tds.apps;

import java.time.LocalDate;
import java.util.Optional;

public class User {
    private String name;
    private String phoneNumber;
    private String password;
    private Optional<LocalDate> dateOfBirth;
    private Optional<String> image;
    private String greeting;

    public User(String name, String phoneNumber, String password, Optional<LocalDate> dateOfBirth, Optional<String> image, String greeting) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
        this.greeting = greeting;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public Optional<LocalDate> getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Optional<LocalDate> newDateOfBirth) {
        dateOfBirth = newDateOfBirth;
    }

    public Optional<String> getImage() {
        return image;
    }

    public void setImage(Optional<String> newImage) {
        image = newImage;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String newGreeting) {
        greeting = newGreeting;
    }
}