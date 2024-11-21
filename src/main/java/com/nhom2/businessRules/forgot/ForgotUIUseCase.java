package com.nhom2.businessRules.forgot;

public class ForgotUIUseCase implements ForgotUIInputBoundary {
    private ForgotUIOutputBoundary forgotUIOutputBoundary;
    private ForgotInputBoundary forgotInputBoundary;

    public ForgotUIUseCase(ForgotUIOutputBoundary forgotUIOutputBoundary) {
        this.forgotUIOutputBoundary = forgotUIOutputBoundary;
    }

    

    public void setForgotInputBoundary(ForgotInputBoundary forgotInputBoundary) {
        this.forgotInputBoundary = forgotInputBoundary;
    }



    @Override
    public void execute() {
        this.forgotUIOutputBoundary.present();
    }

    @Override
    public void execute(ForgotUIInputDTO forgotUIInputDTO) {
        
        String chucNang = forgotUIInputDTO.getChucNang();
        if (chucNang.equals("Quên mật khẩu")) {
            String username = forgotUIInputDTO.getUsername();
            String email = forgotUIInputDTO.getEmail();

            ForgotInputDTO forgotInputDTO = new ForgotInputDTO();
            forgotInputDTO.setUsername(username);
            forgotInputDTO.setEmail(email);

            this.forgotInputBoundary.execute(forgotInputDTO);
        }
    }

    

}
