package org.academiadecodigo.splicegirls36.promptlogin.service;


import org.academiadecodigo.splicegirls36.promptlogin.model.User;

import java.util.HashSet;
import java.util.Set;

public class UserDatabase implements UserService {

    private Set<User> users;

    public UserDatabase () {

        this.users = new HashSet<>();

    }

    public void add (User user) {

        this.users.add(user);

    }

    public void remove (User user) {

        this.users.remove(user);

    }

    public User getBy (String userName) {

        for (User user : users) {

            if (user.getUserName().equals(userName)) {
                return user;
            }

        }

        return null;

    }

    public boolean contains (User user) {

        for (User otherUser : users) {

            if (otherUser.equals(user)) {

                return true;

            }

        }

        return false;

    }

    @Override
    public boolean authenticate(String userName, String password) {
        User user = getBy(userName);
        return (user != null) && user.getPassword().equals(password);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (User user : users) {

            result.append(user.toString());
            result.append("\n");

        }
        return result.toString();
    }
}
