package com.nhom2.businessRules.quanLyHDTienDien;

public interface QuanLyHDTienDienOutputBoundary {
    public void exportError(QuanLyHDTienDienOutputDTO quanLyHDTienDienOutputDTO);
    public void exportResult(QuanLyHDTienDienOutputDTO quanLyHDTienDienOutputDTO);
    public void present();
}
