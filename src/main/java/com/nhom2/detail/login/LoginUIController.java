package com.nhom2.detail.login;

import com.nhom2.businessRules.login.LoginUIInputBoundary;

public class LoginUIController {
    private LoginUIInputBoundary loginUIInputBoundary;

    public LoginUIController(LoginUIInputBoundary loginUIInputBoundary) {
        this.loginUIInputBoundary = loginUIInputBoundary;
    }

    public void execute() {
        this.loginUIInputBoundary.execute();
    }
}
