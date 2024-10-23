package com.nhom2.businessRules.getListInvoice;

import java.util.Date;

public class GetListInvoiceOutputDTO {
    private String status;
    private String msg;
    private int maKH;
    private String tenKH;
    private Date ngayHD;
    private int soLuong;
    private int donGia;
    private String quocTich;
    private String doiTuongKH;
    private int dinhMuc;
    private double thanhTien;

    public GetListInvoiceOutputDTO(int maKH, String tenKH, Date ngayHD, int soLuong, int donGia, String quocTich,
            String doiTuongKH, int dinhMuc, double thanhTien) {
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

    

    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }



    public String getMsg() {
        return msg;
    }



    public void setMsg(String msg) {
        this.msg = msg;
    }



    public int getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public Date getNgayHD() {
        return ngayHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public String getDoiTuongKH() {
        return doiTuongKH;
    }

    public int getDinhMuc() {
        return dinhMuc;
    }

    public double getThanhTien() {
        return thanhTien;
    }
}
