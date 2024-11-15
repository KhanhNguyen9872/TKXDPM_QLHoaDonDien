package com.nhom2.businessRules.register;

public class RegisterUseCase implements RegisterInputBoundary {
    private RegisterDatabaseBoundary registerDatabaseBoundary;
    private RegisterOutputBoundary registerOutputBoundary;

    public RegisterUseCase(RegisterDatabaseBoundary registerDatabaseBoundary, RegisterOutputBoundary registerOutputBoundary) {
        this.registerDatabaseBoundary = registerDatabaseBoundary;
        this.registerOutputBoundary = registerOutputBoundary;
    }

    @Override
    public void execute(RegisterInputDTO registerInputDTO) {
        RegisterOutputDTO registerOutputDTO = new RegisterOutputDTO();
        
        if (!verify(registerInputDTO, registerOutputDTO)) {
            this.registerOutputBoundary.exportError(registerOutputDTO);
            return;
        }

        String username = registerInputDTO.getUsername();
        String email = registerInputDTO.getEmail();
        String password = registerInputDTO.getPassword();

        if (this.registerDatabaseBoundary.isExist(username)) {
            registerOutputDTO.setStatus("error");
            registerOutputDTO.setMsg("username,Tên tài khoản này đã tồn tại!");
            this.registerOutputBoundary.exportError(registerOutputDTO);
            return;
        }

        this.registerDatabaseBoundary.register(username, email, password);

        registerOutputDTO.setStatus("success");
        registerOutputDTO.setMsg("Đăng ký thành công!");
        this.registerOutputBoundary.exportResult(registerOutputDTO);
    }
        
    private boolean verify(RegisterInputDTO registerInputDTO, RegisterOutputDTO registerOutputDTO) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";


        String username = registerInputDTO.getUsername();
        String email = registerInputDTO.getEmail();
        String password = registerInputDTO.getPassword();
        String repassword = registerInputDTO.getRepassword();

        try {
            if (username == null || username.isEmpty()) {
                throw new Exception("username,Tên tài khoản không được để trống!");
            }
            if (email == null || email.isEmpty()) {
                throw new Exception("email,Email không được để trống!");
            }
            if (password == null || password.isEmpty()) {
                throw new Exception("password,Mật khẩu không được để trống!");
            }
            if (repassword == null || repassword.isEmpty()) {
                throw new Exception("repassword,Nhập lại mật khẩu không được để trống!");
            }
            if (!password.equals(repassword)) {
                throw new Exception("repassword,Nhập lại mật khẩu không trùng khớp!");
            }
            if (password.length() < 8) {
                throw new Exception("password,Mật khẩu không được nhỏ hơn 8 ký tự!");
            }
            if (!email.matches(emailRegex)) {
                throw new Exception("email,Email không đúng định dạng!");
            }
        } catch (Exception e) {
            registerOutputDTO.setStatus("error");
            registerOutputDTO.setMsg(e.getMessage());
            return false;
        }

        return true;
    }

}
