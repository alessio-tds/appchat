package umu.tds.apps;

import java.util.ArrayList;

public class MainController {
    private User user;
    private MainModel model;
    private MainView view;

    public MainController(User user) {
        this.user = user;
        model = new MainModel();
        view = new MainView();
    }

    public void run() {
        ArrayList<Chat> chats = model.getChats(user);
        view.showMainWindow(chats);
    }
}
