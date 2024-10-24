package com.nhom2.businessRules.entity;

import java.util.Date;

public class InvoiceVN extends Invoice {
    private String doiTuongKH;
    private int dinhMuc;

    public InvoiceVN() {

    }

    public InvoiceVN(int maKH, String tenKH, Date ngayHD, int soLuong, int donGia, String doiTuongKH, int dinhMuc) {
        setMaKH(maKH);
        setTenKH(tenKH);
        setNgayHD(ngayHD);
        setSoLuong(soLuong);
        setDonGia(donGia);
        setDoiTuongKH(doiTuongKH);
        setDinhMuc(dinhMuc);
    }

    @Override
    public double tinhThanhTien() {
        double thanhTien = 0.0;

        if (getSoLuong() <= getDinhMuc()) {
            thanhTien = getSoLuong() * getDonGia();
        } else {
            thanhTien = (getSoLuong() * getDonGia()) * (getDinhMuc() + (getDinhMuc() - getSoLuong()) * getDonGia() * 2.5);
        }

        return thanhTien;
    }

    public String getDoiTuongKH() {
        return doiTuongKH;
    }

    public void setDoiTuongKH(String doiTuongKH) {
        this.doiTuongKH = doiTuongKH;
    }


    public int getDinhMuc() {
        return dinhMuc;
    }


    public void setDinhMuc(int dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    
}
