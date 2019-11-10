package org.academiadecodigo.splicegirls36.promptlogin.controller;

import org.academiadecodigo.splicegirls36.promptlogin.model.User;

public interface LoginController {

    void add(User user);
    boolean validate(String userName);
    boolean authenticate(String userName, String password);
    void init();
}
