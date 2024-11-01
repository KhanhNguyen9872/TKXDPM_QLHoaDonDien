package com.nhom2.businessRules.findInvoice;

public class FindInvoiceInputDTO {
    private String findType = null;
    private String maKH = null;
    private String tenKH = null;
    private String ngayHD = null;

    public FindInvoiceInputDTO() {

    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setNgayHD(String ngayHD) {
        this.ngayHD = ngayHD;
    }

    public String getNgayHD() {
        return ngayHD;
    }

    public String getFindType() {
        return findType;
    }

    public void setFindType(String findType) {
        this.findType = findType;
    }

    

}
