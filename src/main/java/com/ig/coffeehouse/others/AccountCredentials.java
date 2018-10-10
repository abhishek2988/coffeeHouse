package com.riskblock.theinstitutes.security.jwt;

public class AccountCredentials {

    private String user;
    private String password;

    String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
