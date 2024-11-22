package com.nhom2.detail.login;

import com.nhom2.businessRules.login.LoginOutputBoundary;
import com.nhom2.businessRules.login.LoginOutputDTO;
import com.nhom2.detail.quanLyHDTienDien.QuanLyHDTienDienView;

public class LoginPresenter implements LoginOutputBoundary {
    private QuanLyHDTienDienView quanLyHDTienDienView;
    private LoginUIView loginUIView;
    private LoginViewModel loginViewModel;

    public LoginPresenter(LoginUIView loginUIView, LoginViewModel loginViewModel, QuanLyHDTienDienView quanLyHDTienDienView) {
        this.loginUIView = loginUIView;
        this.loginViewModel = loginViewModel;
        this.quanLyHDTienDienView = quanLyHDTienDienView;
    }

    @Override
    public void exportError(LoginOutputDTO loginOutputDTO) {
        this.loginViewModel.status = loginOutputDTO.getStatus();
        String inputNameError;
        String msg;

        try {
            inputNameError = loginOutputDTO.getMsg().split(",")[0];
            msg = loginOutputDTO.getMsg().split(",")[1];

            if (inputNameError.equals("username")) {
                this.loginViewModel.usernameErr = true;
            } else {
                this.loginViewModel.usernameErr = false;
            }
    
            if (inputNameError.equals("password")) {
                this.loginViewModel.passwordErr = true;
            } else {
                this.loginViewModel.passwordErr = false;
            }
        } catch (Exception e) {
            msg = loginOutputDTO.getMsg();
        }
        
        this.loginViewModel.msg = msg;
        
        if (this.loginUIView != null) {
            this.loginUIView.showMsgError(this.loginViewModel);
        }
    }

    @Override
    public void exportResult(LoginOutputDTO loginOutputDTO) {
        loginViewModel.status = loginOutputDTO.getStatus();
        loginViewModel.msg = loginOutputDTO.getMsg();

        // this.loginUIView.showMsgResult(loginViewModel);
        if (this.loginUIView != null) {
            this.loginUIView.hideGUI();
        }

        if (this.quanLyHDTienDienView != null) {
            this.quanLyHDTienDienView.setUser(loginOutputDTO.getUsername(), loginOutputDTO.isAdmin());
            this.quanLyHDTienDienView.showGUI();
        }
    }

}
