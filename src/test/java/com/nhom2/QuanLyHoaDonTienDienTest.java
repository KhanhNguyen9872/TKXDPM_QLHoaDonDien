package com.nhom2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienInputBoundary;
import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienInputDTO;
import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienOutputBoundary;
import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienUseCase;
import com.nhom2.detail.quanLyHDTienDien.QuanLyHDTienDienPresenter;
import com.nhom2.detail.quanLyHDTienDien.QuanLyHDTienDienViewModel;

public class QuanLyHoaDonTienDienTest {
    private QuanLyHDTienDienInputBoundary quanLyHDTienDienInputBoundary;
    private QuanLyHDTienDienViewModel quanLyHDTienDienViewModel;

    private void prepareUseCase() throws Exception {
        this.quanLyHDTienDienViewModel = new QuanLyHDTienDienViewModel();
        QuanLyHDTienDienOutputBoundary quanLyHDTienDienOutputBoundary = new QuanLyHDTienDienPresenter(null, quanLyHDTienDienViewModel);
        this.quanLyHDTienDienInputBoundary = new QuanLyHDTienDienUseCase(quanLyHDTienDienOutputBoundary);
    }

    private QuanLyHDTienDienInputDTO getRequestData() {
        return new QuanLyHDTienDienInputDTO();
    }

    // SUCCESS
    @Test
    public void quanLyHDTienDienSuccess() throws Exception
    {
        prepareUseCase();

        QuanLyHDTienDienInputDTO quanLyHDTienDienInputDTO = getRequestData();
        quanLyHDTienDienInputDTO.setChucNang("Thêm");
        
        this.quanLyHDTienDienInputBoundary.execute(quanLyHDTienDienInputDTO);

        assertEquals(quanLyHDTienDienViewModel.msg, "Đã mở chức năng [Thêm]");
    }

    // ERROR
    @Test
    public void quanLyHDTienDienError() throws Exception
    {
        prepareUseCase();

        QuanLyHDTienDienInputDTO quanLyHDTienDienInputDTO = getRequestData();
        quanLyHDTienDienInputDTO.setChucNang("Xóa toàn bộ");
        
        this.quanLyHDTienDienInputBoundary.execute(quanLyHDTienDienInputDTO);

        assertEquals(quanLyHDTienDienViewModel.msg, "Chức năng [Xóa toàn bộ] không tồn tại");
    }

}
