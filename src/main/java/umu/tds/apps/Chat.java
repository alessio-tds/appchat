package umu.tds.apps;

public abstract class Chat {
    private String name;

    public Chat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}