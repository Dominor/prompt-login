package org.academiadecodigo.splicegirls36.promptlogin.model;

public class User {

    public static final String DEFAULT_PASSWORD = "youshouldnothavethispassword";

    private String userName;
    private String password;

    public User (String userName) {

        this.userName = userName;
        this.password = DEFAULT_PASSWORD;

    }

    public User (String userName, String password) {

        this.userName = userName;
        this.password = password;

    }

    public String getUserName() {

        return userName;

    }

    public String getPassword () {

        return password;

    }

    @Override
    public String toString() {
        return userName.toString() + " " + password.toString();
    }
}
