package com.nhom2.detail.register;

import com.nhom2.businessRules.register.RegisterOutputBoundary;
import com.nhom2.businessRules.register.RegisterOutputDTO;

public class RegisterPresenter implements RegisterOutputBoundary {
    private RegisterUIView registerUIView;
    private RegisterViewModel registerViewModel;

    public RegisterPresenter(RegisterUIView registerUIView, RegisterViewModel registerViewModel) {
        this.registerUIView = registerUIView;
        this.registerViewModel = registerViewModel;
    } 

    @Override
    public void exportResult(RegisterOutputDTO registerOutputDTO) {
        this.registerViewModel.status = registerOutputDTO.getStatus();
        this.registerViewModel.msg = registerOutputDTO.getMsg();
        
        if (this.registerUIView != null) {
            this.registerUIView.showMsgResult(this.registerViewModel);
        }
    }

    @Override
    public void exportError(RegisterOutputDTO registerOutputDTO) {
        this.registerViewModel.status = registerOutputDTO.getStatus();
        String inputNameError;
        String msg;

        try {
            inputNameError = registerOutputDTO.getMsg().split(",")[0];
            msg = registerOutputDTO.getMsg().split(",")[1];

            if (inputNameError.equals("username")) {
                this.registerViewModel.usernameErr = true;
            } else {
                this.registerViewModel.usernameErr = false;
            }

            if (inputNameError.equals("email")) {
                this.registerViewModel.emailErr = true;
            } else {
                this.registerViewModel.emailErr = false;
            }
    
            if (inputNameError.equals("password")) {
                this.registerViewModel.passwordErr = true;
            } else {
                this.registerViewModel.passwordErr = false;
            }

            if (inputNameError.equals("repassword")) {
                this.registerViewModel.repasswordErr = true;
            } else {
                this.registerViewModel.repasswordErr = false;
            }
        } catch (Exception e) {
            msg = registerOutputDTO.getMsg();
        }
        
        this.registerViewModel.msg = msg;
        
        if (this.registerUIView != null) {
            this.registerUIView.showMsgError(this.registerViewModel);
        }
    }

}
