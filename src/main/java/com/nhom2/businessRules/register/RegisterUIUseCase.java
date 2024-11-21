package com.nhom2.businessRules.register;

public class RegisterUIUseCase implements RegisterUIInputBoundary {
    private RegisterUIOutputBoundary registerUIOutputBoundary;
    private RegisterInputBoundary registerInputBoundary;

    public RegisterUIUseCase(RegisterUIOutputBoundary registerUIOutputBoundary) {
        this.registerUIOutputBoundary = registerUIOutputBoundary;
    }

    

    public void setRegisterInputBoundary(RegisterInputBoundary registerInputBoundary) {
        this.registerInputBoundary = registerInputBoundary;
    }



    @Override
    public void execute(RegisterUIInputDTO registerUIInputDTO) {
        
        String chucNang = registerUIInputDTO.getChucNang();
        if (chucNang.equals("Đăng ký")) {
            String username = registerUIInputDTO.getUsername();
            String email = registerUIInputDTO.getEmail();
            String password = registerUIInputDTO.getPassword();
            String rePassword = registerUIInputDTO.getRepassword();

            RegisterInputDTO registerInputDTO = new RegisterInputDTO();
            registerInputDTO.setUsername(username);
            registerInputDTO.setEmail(email);
            registerInputDTO.setPassword(password);
            registerInputDTO.setRepassword(rePassword);

            if (this.registerInputBoundary != null) {
                this.registerInputBoundary.execute(registerInputDTO);
            }
        }
    }

    @Override
    public void execute() {
        this.registerUIOutputBoundary.present();
    }

}
