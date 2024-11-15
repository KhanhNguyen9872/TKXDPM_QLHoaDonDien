package com.nhom2.businessRules.forgot;

public class ForgotOutputDTO {
    private String status;
    private String msg;
    private String newPassword;

    public ForgotOutputDTO() {

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



    public String getNewPassword() {
        return newPassword;
    }



    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
