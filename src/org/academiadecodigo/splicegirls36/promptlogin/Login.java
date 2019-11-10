package org.academiadecodigo.splicegirls36.promptlogin;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.splicegirls36.promptlogin.controller.LoginController;
import org.academiadecodigo.splicegirls36.promptlogin.controller.LoginManager;
import org.academiadecodigo.splicegirls36.promptlogin.factory.UserFactory;
import org.academiadecodigo.splicegirls36.promptlogin.service.UserDatabase;
import org.academiadecodigo.splicegirls36.promptlogin.service.UserService;
import org.academiadecodigo.splicegirls36.promptlogin.view.SimpleLoginLoginView;
import org.academiadecodigo.splicegirls36.promptlogin.view.LoginView;

public class Login {

    public static void main(String[] args) {

        Login login = new Login();
        LoginController loginController = login.bootStrap();
        loginController.init();

    }

    private LoginController bootStrap() {

        Prompt prompt = new Prompt(System.in, System.out);
        LoginView loginView = new SimpleLoginLoginView(prompt);
        UserService userService = new UserDatabase();
        userService.add(UserFactory.newUser("guest", "guest"));
        userService.add(UserFactory.newUser("guest2", "guest"));
        LoginController loginController = new LoginManager(loginView, userService);
        loginView.setController(loginController);

        return loginController;
    }

}
