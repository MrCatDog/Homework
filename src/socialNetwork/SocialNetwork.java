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

    public ArrayList<String> findFriends(String name, int deep) {
        User sought = findUser(name);
        if (sought == null) {
            System.out.println("Пользователь не найден!");
            return null;
        }

        HashSet<User> answer = new HashSet<>(sought.getFriends());
        deep--;
        for (User friend : sought.getFriends()) {
            findFriends(friend, answer, deep);
        }
        answer.remove(sought);

        ArrayList<String> arrayAnswer = new ArrayList<>();
        for (User user : answer) {
            arrayAnswer.add(user.getName());
        }
        return arrayAnswer;
    }

    private void findFriends(User sought, HashSet<User> seen, int deep) {
        if (deep <= 0) {
            return;
        } else {
            deep--;
        }
        for (User friend : sought.getFriends()) {
            if (!seen.contains(friend)) {
                seen.add(friend);
                findFriends(friend, seen, deep);
            }
        }
    }
}
