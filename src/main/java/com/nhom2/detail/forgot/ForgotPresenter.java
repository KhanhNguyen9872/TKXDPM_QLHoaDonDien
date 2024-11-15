package com.nhom2.detail.forgot;

import com.nhom2.businessRules.forgot.ForgotOutputBoundary;
import com.nhom2.businessRules.forgot.ForgotOutputDTO;

public class ForgotPresenter implements ForgotOutputBoundary {
    private ForgotViewModel forgotViewModel;
    private ForgotUIView forgotUIView;

    public ForgotPresenter(ForgotUIView forgotUIView, ForgotViewModel forgotViewModel) {
        this.forgotUIView = forgotUIView;
        this.forgotViewModel = forgotViewModel;
    }

    @Override
    public void exportError(ForgotOutputDTO forgotOutputDTO) {
        this.forgotViewModel.status = forgotOutputDTO.getStatus();
        String inputNameError;
        String msg;

        try {
            inputNameError = forgotOutputDTO.getMsg().split(",")[0];
            msg = forgotOutputDTO.getMsg().split(",")[1];

            if (inputNameError.equals("username")) {
                this.forgotViewModel.usernameErr = true;
            } else {
                this.forgotViewModel.usernameErr = false;
            }

            if (inputNameError.equals("email")) {
                this.forgotViewModel.emailErr = true;
            } else {
                this.forgotViewModel.emailErr = false;
            }
        } catch (Exception e) {
            msg = forgotOutputDTO.getMsg();
        }
        
        this.forgotViewModel.msg = msg;
        
        if (this.forgotUIView != null) {
            this.forgotUIView.showMsgError(this.forgotViewModel);
        }
    }

    @Override
    public void exportResult(ForgotOutputDTO forgotOutputDTO) {
        this.forgotViewModel.status = forgotOutputDTO.getStatus();
        this.forgotViewModel.msg = forgotOutputDTO.getMsg();
        this.forgotViewModel.newPassword = forgotOutputDTO.getNewPassword();
        
        if (this.forgotUIView != null) {
            this.forgotUIView.showMsgResult(this.forgotViewModel);
        }
    }

}
