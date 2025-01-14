package umu.tds.apps;

import java.time.LocalDate;
import java.time.LocalTime;

public class Message {
    private User sender;
    private User receiver;
    private String text;
    private LocalDate date;
    private LocalTime time;

    public Message(User sender, User receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }

    public void send() {
        date = LocalDate.now();
        time = LocalTime.now();

        sender.addMessage(this);
        receiver.addMessage(this);
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
