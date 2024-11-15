package com.nhom2.businessRules.login;

public class LoginUseCase implements LoginInputBoundary {
    private LoginDatabaseBoundary loginDatabaseBoundary;
    private LoginOutputBoundary loginOutputBoundary;

    public LoginUseCase(LoginDatabaseBoundary loginDatabaseBoundary, LoginOutputBoundary loginOutputBoundary) {
        this.loginDatabaseBoundary = loginDatabaseBoundary;
        this.loginOutputBoundary = loginOutputBoundary;
    }

    @Override
    public void execute(LoginInputDTO loginInputDTO) {
        LoginOutputDTO loginOutputDTO = new LoginOutputDTO();

        if (!verity(loginInputDTO, loginOutputDTO)) {
            this.loginOutputBoundary.exportError(loginOutputDTO);
            return;
        }

        String username = loginInputDTO.getUsername();
        String password = loginInputDTO.getPassword();

        if (this.loginDatabaseBoundary.login(username, password)) {
            boolean isAdmin = this.loginDatabaseBoundary.isAdmin(username, password);
            loginOutputDTO.setStatus("success");
            loginOutputDTO.setMsg("Đăng nhập thành công!");
            loginOutputDTO.setAdmin(isAdmin);
            loginOutputDTO.setUsername(username);
            this.loginOutputBoundary.exportResult(loginOutputDTO);
        } else {
            loginOutputDTO.setStatus("error");
            loginOutputDTO.setMsg("Tài khoản hoặc mật khẩu không chính xác!");
            this.loginOutputBoundary.exportError(loginOutputDTO);
            return;
        }
    }

    private boolean verity(LoginInputDTO loginInputDTO, LoginOutputDTO loginOutputDTO) {
        String username = loginInputDTO.getUsername();
        String password = loginInputDTO.getPassword();

        try {
            if (username == null || username.isEmpty()) {
                throw new Exception("username,Tên tài khoản không được để trống!");
            }
            if (password == null || password.isEmpty()) {
                throw new Exception("password,Mật khẩu không được để trống!");
            }
        } catch (Exception e) {
            loginOutputDTO.setStatus("error");
            loginOutputDTO.setMsg(e.getMessage());
            return false;
        }
        

        return true;
    }

}
