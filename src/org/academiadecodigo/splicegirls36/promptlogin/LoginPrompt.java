package org.academiadecodigo.splicegirls36.promptlogin;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.splicegirls36.promptlogin.model.User;
import org.academiadecodigo.splicegirls36.promptlogin.service.UserDatabase;

import java.util.HashSet;
import java.util.Set;

public class LoginPrompt {

    private UserDatabase userDB;

    public LoginPrompt() {

        this.userDB = new UserDatabase();

    }

    public void start () {

        Prompt prompt = new Prompt(System.in, System.out);
        String userName = null;
        String password = null;
        User user = null;

        System.out.println(userDB);

        while (true) {
            StringInputScanner askUsername = new StringInputScanner();
            askUsername.setMessage("Username: ");
            userName = prompt.getUserInput(askUsername);

            user = userDB.getBy(userName);

            if (user != null) {

                break;

            }
            System.out.println("Incorrect username");
        }

        Set<String> valid_passwords = new HashSet<>();
        valid_passwords.add(user.getPassword());

        PasswordInputScanner askPassword = new PasswordInputScanner();
        askPassword.setMessage("Password: ");
        password = prompt.getUserInput(askPassword);

        while (!user.getPassword().equals(password)) {

            System.out.println("Incorrect password.");
            password = prompt.getUserInput(askPassword);

        }

        System.out.println("Login Successful");
        System.out.println("Welcome home, " + userName);

    }

    public void addUser (String userName, String password) {

        userDB.add(new User(userName, password));

    }

}
