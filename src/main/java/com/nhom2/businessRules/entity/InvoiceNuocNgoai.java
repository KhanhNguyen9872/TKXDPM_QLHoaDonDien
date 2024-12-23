package com.nhom2.businessRules.entity;

import java.util.Date;

public class InvoiceNuocNgoai extends Invoice {
    private String quocTich;

    public InvoiceNuocNgoai() {

    }

    public InvoiceNuocNgoai(int maKH, String tenKH, Date ngayHD, int soLuong, int donGia, String quocTich) {
        setMaKH(maKH);
        setTenKH(tenKH);
        setNgayHD(ngayHD);
        setSoLuong(soLuong);
        setDonGia(donGia);
        setQuocTich(quocTich);
    }

    @Override
    public double tinhThanhTien() {
        return this.getSoLuong() * this.getDonGia();
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }
}
