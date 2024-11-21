package com.nhom2.businessRules.login;

import com.nhom2.businessRules.forgot.ForgotInputBoundary;
import com.nhom2.businessRules.forgot.ForgotUIInputBoundary;
import com.nhom2.businessRules.register.RegisterInputBoundary;
import com.nhom2.businessRules.register.RegisterUIInputBoundary;

public class LoginUIUseCase implements LoginUIInputBoundary {
    private LoginUIOutputBoundary loginUIOutputBoundary;
    private LoginInputBoundary loginInputBoundary;
    private RegisterUIInputBoundary registerUIInputBoundary;
    private ForgotUIInputBoundary forgotUIInputBoundary;

    public LoginUIUseCase(LoginUIOutputBoundary loginUIOutputBoundary) {
        this.loginUIOutputBoundary = loginUIOutputBoundary;
    }

    

    public void setLoginInputBoundary(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }



    



    public void setRegisterUIInputBoundary(RegisterUIInputBoundary registerUIInputBoundary) {
        this.registerUIInputBoundary = registerUIInputBoundary;
    }



    public void setForgotUIInputBoundary(ForgotUIInputBoundary forgotUIInputBoundary) {
        this.forgotUIInputBoundary = forgotUIInputBoundary;
    }



    @Override
    public void execute(LoginUIInputDTO loginUIInputDTO) {
        String chucNang = loginUIInputDTO.getChucNang();
        if (chucNang.equals("Đăng nhập")) {
            String username = loginUIInputDTO.getUsername();
            String password = loginUIInputDTO.getPassword();

            LoginInputDTO loginInputDTO = new LoginInputDTO();
            loginInputDTO.setUsername(username);
            loginInputDTO.setPassword(password);
            
            this.loginInputBoundary.execute(loginInputDTO);
        } else if (chucNang.equals("Đăng ký")) {
            this.registerUIInputBoundary.execute();

        } else if (chucNang.equals("Quên mật khẩu")) {
            this.forgotUIInputBoundary.execute();
        }
    }

    @Override
    public void execute() {
        this.loginUIOutputBoundary.present();
    }

}
