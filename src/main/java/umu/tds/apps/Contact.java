package umu.tds.apps;

public class Contact extends Chat {
    private User user;

    public Contact(User user) {
        super(user.getName());
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
