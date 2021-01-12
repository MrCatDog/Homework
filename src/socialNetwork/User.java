package socialNetwork;

import java.util.ArrayList;

public class User {
    private static int lastId = 0;
    private int id;
    private String name;
    private ArrayList<User> friends;

    User(String name) {
        this.id = lastId++;
        this.name = name;
        friends = new ArrayList<>();
    }

    void addFriend(User user) {
        friends.add(user);
    }

    public String getName() {
        return name;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void friendsOut() {
        for (User val : friends) {
            System.out.println(val.getName());
        }
    }
}
