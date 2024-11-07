package com.nhom2.detail.quanLyHDTienDien;

import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienOutputBoundary;
import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienOutputDTO;

public class QuanLyHDTienDienPresenter implements QuanLyHDTienDienOutputBoundary {
    private QuanLyHDTienDienViewModel quanLyHDTienDienViewModel;
    private QuanLyHDTienDienView quanLyHDTienDienView;

    public QuanLyHDTienDienPresenter(QuanLyHDTienDienView quanLyHDTienDienView, QuanLyHDTienDienViewModel quanLyHDTienDienViewModel) {
        this.quanLyHDTienDienView = quanLyHDTienDienView;
        this.quanLyHDTienDienViewModel = quanLyHDTienDienViewModel;
    }

    @Override
    public void exportError(QuanLyHDTienDienOutputDTO quanLyHDTienDienOutputDTO) {
        this.quanLyHDTienDienViewModel.status = "error";
        this.quanLyHDTienDienViewModel.msg = quanLyHDTienDienOutputDTO.getMsg();
        
        if (this.quanLyHDTienDienView != null) {
            this.quanLyHDTienDienView.showMsgError(this.quanLyHDTienDienViewModel);
        }
    }

    @Override
    public void exportResult(QuanLyHDTienDienOutputDTO quanLyHDTienDienOutputDTO) {
        this.quanLyHDTienDienViewModel.status = "success";
        this.quanLyHDTienDienViewModel.msg = quanLyHDTienDienOutputDTO.getMsg();
        
        if (this.quanLyHDTienDienView != null) {
            this.quanLyHDTienDienView.showMsgResult(this.quanLyHDTienDienViewModel);
        }
    }

    @Override
    public void present() {
        if (this.quanLyHDTienDienView != null) {
            this.quanLyHDTienDienView.showGUI();
        }
    }

}
