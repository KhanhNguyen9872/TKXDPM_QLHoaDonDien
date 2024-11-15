package com.nhom2.detail.register;

import com.nhom2.businessRules.register.RegisterUIOutputBoundary;

public class RegisterUIPresenter implements RegisterUIOutputBoundary {
    private RegisterUIView registerUIView;
    private RegisterUIViewModel registerUIViewModel;

    public RegisterUIPresenter(RegisterUIView registerUIView, RegisterUIViewModel registerUIViewModel) {
        this.registerUIView = registerUIView;
        this.registerUIViewModel = registerUIViewModel;
    }

    @Override
    public void present() {
        this.registerUIView.mainShow();
    }
    
}
