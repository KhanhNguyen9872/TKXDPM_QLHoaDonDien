package com.nhom2.businessRules.quanLyHDTienDien;

import com.nhom2.businessRules.addInvoice.AddInvoiceUIInputBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiUIInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUIInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUIInputDTO;
import com.nhom2.businessRules.editInvoice.EditInvoiceUIInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUIInputDTO;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthUIInputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceUIInputBoundary;
import com.nhom2.businessRules.login.LoginUIInputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceUIInputBoundary;

public class QuanLyHDTienDienUseCase implements QuanLyHDTienDienInputBoundary {
    private AddInvoiceUIInputBoundary addInvoiceUIInputBoundary;
    private DeleteInvoiceUIInputBoundary deleteInvoiceUIInputBoundary;
    private EditInvoiceUIInputBoundary editInvoiceUIInputBoundary;
    private FindInvoiceUIInputBoundary findInvoiceUIInputBoundary;
    private ExportInvoiceByMonthUIInputBoundary exportInvoiceByMonthUIInputBoundary;
    private AvgMoneyInvoiceNuocNgoaiUIInputBoundary avgMoneyInvoiceNuocNgoaiUIInputBoundary;
    private SumKHInvoiceUIInputBoundary sumKHInvoiceUIInputBoundary;
    private LoginUIInputBoundary loginUIInputBoundary;

    private QuanLyHDTienDienOutputBoundary quanLyHDTienDienOutputBoundary;
    
    public QuanLyHDTienDienUseCase(QuanLyHDTienDienOutputBoundary quanLyHDTienDienOutputBoundary) {
        this.quanLyHDTienDienOutputBoundary = quanLyHDTienDienOutputBoundary;
    }

    @Override
    public void execute(QuanLyHDTienDienInputDTO quanLyHDTienDienInputDTO) {
        String chucNang = quanLyHDTienDienInputDTO.getChucNang();
        QuanLyHDTienDienOutputDTO quanLyHDTienDienOutputDTO = new QuanLyHDTienDienOutputDTO();

        if (chucNang.equals("Thêm")) {
            if (this.addInvoiceUIInputBoundary != null) {
                this.addInvoiceUIInputBoundary.execute();
            }

        } else if (chucNang.equals("Xóa")) {
            if (this.deleteInvoiceUIInputBoundary != null) {
                String maKH = quanLyHDTienDienInputDTO.getMaKH();
                if (maKH == null || maKH.isEmpty()) {
                    quanLyHDTienDienOutputDTO.setMsg("Vui lòng chọn thông tin!");
                    this.quanLyHDTienDienOutputBoundary.exportError(quanLyHDTienDienOutputDTO);
                    return;
                }
                DeleteInvoiceUIInputDTO deleteInvoiceUIInputDTO = new DeleteInvoiceUIInputDTO();
                deleteInvoiceUIInputDTO.setMaKH(maKH);
                this.deleteInvoiceUIInputBoundary.execute(deleteInvoiceUIInputDTO);
            }

        } else if (chucNang.equals("Sửa")) {
            if (this.editInvoiceUIInputBoundary != null) {
                String maKH = quanLyHDTienDienInputDTO.getMaKH();
                if (maKH == null || maKH.isEmpty()) {
                    quanLyHDTienDienOutputDTO.setMsg("Vui lòng chọn thông tin!");
                    this.quanLyHDTienDienOutputBoundary.exportError(quanLyHDTienDienOutputDTO);
                    return;
                }
                String tenKH = quanLyHDTienDienInputDTO.getTenKH();
                String ngayHD = quanLyHDTienDienInputDTO.getNgayHD();
                String soLuong = quanLyHDTienDienInputDTO.getSoLuong();
                String donGia = quanLyHDTienDienInputDTO.getDonGia();
                String quocTich = quanLyHDTienDienInputDTO.getQuocTich();
                String doiTuongKH = quanLyHDTienDienInputDTO.getDoiTuongKH();
                String dinhMuc = quanLyHDTienDienInputDTO.getDinhMuc();
                String thanhTien = quanLyHDTienDienInputDTO.getThanhTien();

                EditInvoiceUIInputDTO editInvoiceUIInputDTO = new EditInvoiceUIInputDTO();
                editInvoiceUIInputDTO.setMaKH(maKH);
                editInvoiceUIInputDTO.setTenKH(tenKH);
                editInvoiceUIInputDTO.setNgayHD(ngayHD);
                editInvoiceUIInputDTO.setSoLuong(soLuong);
                editInvoiceUIInputDTO.setDonGia(donGia);
                editInvoiceUIInputDTO.setQuocTich(quocTich);
                editInvoiceUIInputDTO.setDoiTuongKH(doiTuongKH);
                editInvoiceUIInputDTO.setDinhMuc(dinhMuc);
                editInvoiceUIInputDTO.setThanhTien(thanhTien);
                
                this.editInvoiceUIInputBoundary.execute(editInvoiceUIInputDTO);
            }

        } else if (chucNang.equals("Xuất theo tháng")) {
            if (this.exportInvoiceByMonthUIInputBoundary != null) {
                this.exportInvoiceByMonthUIInputBoundary.execute();
            }

        } else if (chucNang.equals("Tìm kiếm")) {
            if (this.findInvoiceUIInputBoundary != null) {
                this.findInvoiceUIInputBoundary.execute();
            }

        } else if (chucNang.equals("Tính TB thành tiền nước ngoài")) {
            if (this.avgMoneyInvoiceNuocNgoaiUIInputBoundary != null) {
                this.avgMoneyInvoiceNuocNgoaiUIInputBoundary.execute();
            }

        } else if (chucNang.equals("Tổng khách hàng")) {
            if (this.sumKHInvoiceUIInputBoundary != null) {
                this.sumKHInvoiceUIInputBoundary.execute();
            }
        } else if (chucNang.equals("Đăng xuất")) {
            if (this.loginUIInputBoundary != null) {
                this.loginUIInputBoundary.execute();
            }
        } else {
            quanLyHDTienDienOutputDTO.setMsg("Chức năng [" + chucNang + "] không tồn tại");
            this.quanLyHDTienDienOutputBoundary.exportError(quanLyHDTienDienOutputDTO);
            return;
        }

        quanLyHDTienDienOutputDTO.setMsg("Đã mở chức năng [" + chucNang + "]");
        this.quanLyHDTienDienOutputBoundary.exportResult(quanLyHDTienDienOutputDTO);
    }

    @Override
    public void setAddInvoiceUIInputBoundary(AddInvoiceUIInputBoundary addInvoiceUIInputBoundary) {
        this.addInvoiceUIInputBoundary = addInvoiceUIInputBoundary;
    }

    @Override
    public void setDeleteInvoiceUIInputBoundary(DeleteInvoiceUIInputBoundary deleteInvoiceUIInputBoundary) {
        this.deleteInvoiceUIInputBoundary = deleteInvoiceUIInputBoundary;
    }

    @Override
    public void setEditInvoiceUIInputBoundary(EditInvoiceUIInputBoundary editInvoiceUIInputBoundary) {
        this.editInvoiceUIInputBoundary = editInvoiceUIInputBoundary;
    }

    @Override
    public void setFindInvoiceUIInputBoundary(FindInvoiceUIInputBoundary findInvoiceUIInputBoundary) {
        this.findInvoiceUIInputBoundary = findInvoiceUIInputBoundary;
    }

    

    @Override
    public void setExportInvoiceByMonthUIInputBoundary(
            ExportInvoiceByMonthUIInputBoundary exportInvoiceByMonthUIInputBoundary) {
        this.exportInvoiceByMonthUIInputBoundary = exportInvoiceByMonthUIInputBoundary;
    }

    @Override
    public void setAvgMoneyInvoiceNuocNgoaiUIInputBoundary(
            AvgMoneyInvoiceNuocNgoaiUIInputBoundary avgMoneyInvoiceNuocNgoaiUIInputBoundary) {
        this.avgMoneyInvoiceNuocNgoaiUIInputBoundary = avgMoneyInvoiceNuocNgoaiUIInputBoundary;
    }

    @Override
    public void setSumKHInvoiceUIInputBoundary(SumKHInvoiceUIInputBoundary sumKHInvoiceUIInputBoundary) {
        this.sumKHInvoiceUIInputBoundary = sumKHInvoiceUIInputBoundary;
    }

    @Override
    public void setLoginUIInputBoundary(LoginUIInputBoundary loginUIInputBoundary) {
        this.loginUIInputBoundary = loginUIInputBoundary;
    }
}
