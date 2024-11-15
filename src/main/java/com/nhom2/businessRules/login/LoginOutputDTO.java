package com.nhom2.businessRules.login;

public class LoginOutputDTO {
    private String status;
    private String msg;
    private String username;
    private boolean isAdmin;

    public LoginOutputDTO() {

    }

    

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public boolean isAdmin() {
        return isAdmin;
    }



    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
