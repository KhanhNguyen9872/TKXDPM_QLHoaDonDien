package com.nhom2.businessRules.addInvoice;

public class AddInvoiceInputDTO {
    private String tenKH;
    private String ngayHD;
    private String soLuong;
    private String donGia;
    private String doiTuongKH;
    private String dinhMuc;
    private String quocTich;
    
    public AddInvoiceInputDTO() {

    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getNgayHD() {
        return ngayHD;
    }

    public void setNgayHD(String ngayHD) {
        this.ngayHD = ngayHD;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getDoiTuongKH() {
        return doiTuongKH;
    }

    public void setDoiTuongKH(String doiTuongKH) {
        this.doiTuongKH = doiTuongKH;
    }

    public String getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(String dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    
}