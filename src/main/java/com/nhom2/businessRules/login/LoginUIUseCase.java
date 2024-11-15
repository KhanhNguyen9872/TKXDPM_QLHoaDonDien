package com.nhom2.businessRules.login;

public class LoginUIUseCase implements LoginUIInputBoundary {
    private LoginUIOutputBoundary loginUIOutputBoundary;

    public LoginUIUseCase(LoginUIOutputBoundary loginUIOutputBoundary) {
        this.loginUIOutputBoundary = loginUIOutputBoundary;
    }

    @Override
    public void execute() {
        this.loginUIOutputBoundary.present();
    }

}
