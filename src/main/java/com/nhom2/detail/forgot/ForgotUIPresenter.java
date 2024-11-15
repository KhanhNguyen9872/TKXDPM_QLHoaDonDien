package com.nhom2.detail.forgot;

import com.nhom2.businessRules.forgot.ForgotUIOutputBoundary;

public class ForgotUIPresenter implements ForgotUIOutputBoundary {
    private ForgotUIView forgotUIView;
    private ForgotUIViewModel forgotUIViewModel;

    public ForgotUIPresenter(ForgotUIView forgotUIView, ForgotUIViewModel forgotUIViewModel) {
        this.forgotUIView = forgotUIView;
        this.forgotUIViewModel = forgotUIViewModel;
    }

    @Override
    public void present() {
        this.forgotUIView.mainShow();
    }

}
