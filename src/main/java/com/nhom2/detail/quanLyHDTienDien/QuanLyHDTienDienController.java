package com.nhom2.detail.quanLyHDTienDien;

import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienInputBoundary;
import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienInputDTO;

public class QuanLyHDTienDienController {
    private QuanLyHDTienDienInputBoundary quanLyHDTienDienInputBoundary;

    public QuanLyHDTienDienController(QuanLyHDTienDienInputBoundary quanLyHDTienDienInputBoundary) {
        this.quanLyHDTienDienInputBoundary = quanLyHDTienDienInputBoundary;
    }

    public void execute(QuanLyHDTienDienInputDTO quanLyHDTienDienInputDTO) {
        this.quanLyHDTienDienInputBoundary.execute(quanLyHDTienDienInputDTO);
    }
}
