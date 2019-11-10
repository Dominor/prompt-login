package org.academiadecodigo.splicegirls36.promptlogin.factory;

import org.academiadecodigo.splicegirls36.promptlogin.model.User;

public class UserFactory {

    public static User newUser(String userName, String password) {

        return new User(userName, password);
    }
}
