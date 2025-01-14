package umu.tds.apps;

import java.util.ArrayList;

public class Group extends Chat {
    private ArrayList<Contact> contacts;
    private String image;

    public Group(String name, ArrayList<Contact> contacts, String image) {
        super(name);
        this.contacts = contacts;
        this.image = image;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public String getImage() {
        return image;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void setImage(String image) {
        this.image = image;
    }
}
