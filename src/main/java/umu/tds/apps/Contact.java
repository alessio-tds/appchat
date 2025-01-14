package umu.tds.apps;

public class Contact extends Chat {
    private User user;

    public Contact(String name, User user) {
        super(name);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
