package org.academiadecodigo.splicegirls36.promptlogin.controller;

import org.academiadecodigo.splicegirls36.promptlogin.model.User;
import org.academiadecodigo.splicegirls36.promptlogin.service.UserService;
import org.academiadecodigo.splicegirls36.promptlogin.view.LoginView;

public class LoginManager implements LoginController {

    private LoginView loginView;
    private UserService userService;

    public LoginManager (LoginView loginView, UserService userService) {

        this.loginView = loginView;
        this.userService = userService;
    }

    public void init() {

        loginView.show();
    }

    @Override
    public void add(User user) {
        userService.add(user);
    }

    @Override
    public boolean validate(String userName) {
        return userService.getBy(userName) != null;
    }

    @Override
    public boolean authenticate(String userName, String password) {
        return userService.authenticate(userName, password);
    }
}
