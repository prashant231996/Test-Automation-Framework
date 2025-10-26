package com.ui.pojo;

public class User {
    private String emailAdresss;
    private String Password;

    public User(String emailAdresss, String password) {
        this.emailAdresss = emailAdresss;
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmailAdresss() {
        return emailAdresss;
    }

    public void setEmailAdresss(String emailAdresss) {
        this.emailAdresss = emailAdresss;
    }
}
