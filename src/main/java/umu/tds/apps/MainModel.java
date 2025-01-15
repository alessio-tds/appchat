package umu.tds.apps;

import java.util.ArrayList;

public class MainModel {
    public ArrayList<Chat> getChats(User user) {
        return user.getChats();
    }
}
