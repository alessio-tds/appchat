package umu.tds.apps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {
    private String name;
    private String phoneNumber;
    private String password;
    private Optional<LocalDate> dateOfBirth;
    private Optional<String> image;
    private String greeting;

    private ArrayList<Chat> chats;
    private ArrayList<Message> messages;

    public User(String name, String phoneNumber, String password, Optional<LocalDate> dateOfBirth, Optional<String> image, String greeting) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
        this.greeting = greeting;
        this.chats = new ArrayList<>();
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

    public ArrayList<Chat> getChats() {
        return chats;
    }

    public ArrayList<Contact> getContacts() {
        return chats.stream()
            .filter(chat -> chat instanceof Contact)
            .map(chat -> (Contact) chat)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Group> getGroups() {
        return chats.stream()
            .filter(chat -> chat instanceof Group)
            .map(chat -> (Group) chat)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public ArrayList<Message> getConversation(User user) {
        return messages.stream()
            .filter(message -> message.getReceiver() == user || message.getSender() == user)
            .collect(Collectors.toCollection(ArrayList::new));
    }
}