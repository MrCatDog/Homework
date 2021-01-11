package socialNetwork;

import java.util.ArrayList;
import java.util.HashSet;

public class SocialNetwork {
    private ArrayList<User> users;

    public SocialNetwork() {
        users = new ArrayList<>();
    }

    public void addUser(String name) {
        users.add(new User(name));
    }

    private User findUser(String name) {
        for (User val : users) {
            if (val.getName().equals(name)) {
                return val;
            }
        }
        return null;
    }

    public void makeFriends(String first, String second) {
        User firstUser = findUser(first);
        User secondUser = findUser(second);
        if (firstUser != null && secondUser != null) {
            firstUser.addFriend(secondUser);
            secondUser.addFriend(firstUser);
        }
    }

    public void findFriends(String name) {
        User sought = findUser(name);
        if (sought == null) {
            System.out.println("Пользователь не найден!");
            return;
        }
        System.out.println("Друзья:");
        sought.friendsOut();
        HashSet<User> friendsOfFriends = new HashSet<>();
        System.out.println("Друзья друзей:");
        for (User val : sought.getFriends()) {
            friendsOfFriends.addAll(val.getFriends());
        }
        friendsOfFriends.remove(sought);
        for (User val : sought.getFriends()) {
            friendsOfFriends.remove(val);
        }
        for (User val : friendsOfFriends) {
            System.out.println(val.getName());
        }
    }
}
