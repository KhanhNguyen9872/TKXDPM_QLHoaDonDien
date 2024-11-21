package com.nhom2.detail.login;

import com.nhom2.businessRules.login.LoginUIInputBoundary;
import com.nhom2.businessRules.login.LoginUIInputDTO;

public class LoginUIController {
    private LoginUIInputBoundary loginUIInputBoundary;

    public LoginUIController(LoginUIInputBoundary loginUIInputBoundary) {
        this.loginUIInputBoundary = loginUIInputBoundary;
    }

    public void execute(LoginUIInputDTO loginUIInputDTO) {
        this.loginUIInputBoundary.execute(loginUIInputDTO);
    }

    public void execute() {
        this.loginUIInputBoundary.execute();
    }
}
