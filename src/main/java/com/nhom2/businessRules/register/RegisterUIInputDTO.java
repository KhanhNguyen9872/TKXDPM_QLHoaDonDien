package com.nhom2.businessRules.register;

public class RegisterUIInputDTO {
    private String chucNang;
    public RegisterUIInputDTO() {

    }
    public String getChucNang() {
        return chucNang;
    }
    public void setChucNang(String chucNang) {
        this.chucNang = chucNang;
    }


    private String username;
    private String email;
    private String password;
    private String repassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    
}