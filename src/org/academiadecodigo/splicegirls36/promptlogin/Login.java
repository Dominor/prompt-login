package org.academiadecodigo.splicegirls36.promptlogin;

public class Login {

    public static void main(String[] args) {

        LoginPrompt handler = new LoginPrompt();
        handler.addUser("guest", "guest");

        handler.start();

    }

}
