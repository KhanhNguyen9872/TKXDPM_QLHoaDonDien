package com.nhom2.businessRules.register;

public class RegisterOutputDTO {
    private String status;
    private String msg;

    public RegisterOutputDTO() {

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
}