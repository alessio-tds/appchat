package umu.tds.apps;

import java.util.HashMap;

public class UserRepository {
    private static HashMap<String, User> userMap = new HashMap<>();

    public void saveUser(User user) {
        userMap.put(user.getPhoneNumber(), user);
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        return userMap.get(phoneNumber);
    }

    public void updateUser(User user) {
        userMap.replace(user.getPhoneNumber(), user);
    }

    public void deleteUserByPhoneNumber(String phoneNumber) {
        userMap.remove(phoneNumber);
    }
}
