package com.nhom2.detail.findInvoice;

public class FindInvoiceViewModel {
    public String status;
    public String msg;
    public String maKH;
    public String tenKH;
    public String ngayHD;
    public String soLuong;
    public String donGia;
    public String quocTich;
    public String doiTuongKH;
    public String dinhMuc;
    public String thanhTien;

    public FindInvoiceViewModel(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    
    public FindInvoiceViewModel(String status, String msg, String maKH, String tenKH, String ngayHD, String soLuong, String donGia,
            String quocTich, String doiTuongKH, String dinhMuc, String thanhTien) {
        this.status = status;
        this.msg = msg;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngayHD = ngayHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.quocTich = quocTich;
        this.doiTuongKH = doiTuongKH;
        this.dinhMuc = dinhMuc;
        this.thanhTien = thanhTien;
    }

    public FindInvoiceViewModel(String maKH, String tenKH, String ngayHD, String soLuong, String donGia,
            String quocTich, String doiTuongKH, String dinhMuc, String thanhTien) {
        this.status = "success";
        this.msg = "";
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngayHD = ngayHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.quocTich = quocTich;
        this.doiTuongKH = doiTuongKH;
        this.dinhMuc = dinhMuc;
        this.thanhTien = thanhTien;
    }

    public FindInvoiceViewModel() {
        //TODO Auto-generated constructor stub
    }

    
}
