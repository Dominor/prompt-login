package org.academiadecodigo.splicegirls36.promptlogin.service;

import org.academiadecodigo.splicegirls36.promptlogin.model.User;

public interface UserService {

    void add(User user);
    void remove(User user);
    User getBy(String userName);
    boolean contains(User user);
    boolean authenticate (String userName, String password);

}
