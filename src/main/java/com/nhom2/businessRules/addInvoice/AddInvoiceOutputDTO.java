package com.nhom2.businessRules.addInvoice;

public class AddInvoiceOutputDTO {
    private String status;
    private String msg;
    
    public AddInvoiceOutputDTO() {

    }

    public String getMsg() {
        return msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
