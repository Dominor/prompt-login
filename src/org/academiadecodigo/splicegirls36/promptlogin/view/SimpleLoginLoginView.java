package org.academiadecodigo.splicegirls36.promptlogin.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.splicegirls36.promptlogin.Messages;
import org.academiadecodigo.splicegirls36.promptlogin.controller.LoginController;

public class SimpleLoginLoginView implements LoginView {

    private Prompt prompt;
    private LoginController controller;

    public SimpleLoginLoginView(Prompt prompt) {

        this.prompt = prompt;
    }

    public void show() {

        String userName;
        String password;

        System.out.println(Messages.WELCOME_MESSAGE);
        StringInputScanner askUsername = new StringInputScanner();
        askUsername.setMessage("Username: ");
        userName = prompt.getUserInput(askUsername);
        if (!controller.validate(userName)) {
            System.out.println(Messages.USERNAME_INPUT_ERROR);
            show();
            return;
        }
        PasswordInputScanner askPassword = new PasswordInputScanner();
        askPassword.setMessage("Password: ");
        password = prompt.getUserInput(askPassword);
        if (!controller.authenticate(userName, password)) {
            System.out.println(Messages.PASSWORD_INPUT_ERROR);
            show();
            return;
        }
        System.out.println(Messages.WELCOME_BACK + userName);
    }

    @Override
    public void setController(LoginController controller) {
        this.controller = controller;
    }
}
