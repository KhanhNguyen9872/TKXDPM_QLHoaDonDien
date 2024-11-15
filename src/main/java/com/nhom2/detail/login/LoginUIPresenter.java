package com.nhom2.detail.login;

import com.nhom2.businessRules.login.LoginUIOutputBoundary;

public class LoginUIPresenter implements LoginUIOutputBoundary {
    private LoginUIView loginUIView;
    private LoginUIViewModel loginUIViewModel;

    public LoginUIPresenter(LoginUIView loginUIView, LoginUIViewModel loginUIViewModel) {
        this.loginUIView = loginUIView;
        this.loginUIViewModel = loginUIViewModel;
    }

    @Override
    public void present() {
        this.loginUIView.mainShow();
    }
}
