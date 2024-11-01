package com.nhom2.detail.exportInvoiceByMonth;

public class ExportInvoiceByMonthViewModel {
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

    public boolean monthErr;

    public ExportInvoiceByMonthViewModel(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    
    public ExportInvoiceByMonthViewModel(String status, String msg, String maKH, String tenKH, String ngayHD, String soLuong, String donGia,
            String quocTich, String doiTuongKH, String dinhMuc, String thanhTien) {
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

    public ExportInvoiceByMonthViewModel(String maKH, String tenKH, String ngayHD, String soLuong, String donGia,
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

    public ExportInvoiceByMonthViewModel() {
        
    }

}
