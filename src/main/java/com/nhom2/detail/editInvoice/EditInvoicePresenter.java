package com.nhom2.detail.editInvoice;

import com.nhom2.businessRules.editInvoice.EditInvoiceOutputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceOutputDTO;

public class EditInvoicePresenter implements EditInvoiceOutputBoundary {
    private EditInvoiceView editInvoiceView;
    private EditInvoiceViewModel editInvoiceViewModel;

    public EditInvoicePresenter(EditInvoiceView editInvoiceView, EditInvoiceViewModel editInvoiceViewModel) {
        this.editInvoiceView = editInvoiceView;
        this.editInvoiceViewModel = editInvoiceViewModel;
    }

    public EditInvoiceViewModel getEditInvoiceViewModel() {
        return this.editInvoiceViewModel;
    }

    @Override
    public void exportError(EditInvoiceOutputDTO responseError) {
        editInvoiceViewModel.status = responseError.getStatus();
        editInvoiceViewModel.status = responseError.getStatus();
        String inputNameError;
        String msg;

        try {
            inputNameError = responseError.getMsg().split(",")[0];
            msg = responseError.getMsg().split(",")[1];

            if (inputNameError.equals("tenKH")) {
                this.editInvoiceViewModel.tenKHErr = true;
            } else {
                this.editInvoiceViewModel.tenKHErr = false;
            }
    
            if (inputNameError.equals("ngayHD")) {
                this.editInvoiceViewModel.ngayHDErr = true;
            } else {
                this.editInvoiceViewModel.ngayHDErr = false;
            }
    
            if (inputNameError.equals("soLuong")) {
                this.editInvoiceViewModel.soLuongErr = true;
            } else {
                this.editInvoiceViewModel.soLuongErr = false;
            }
    
            if (inputNameError.equals("donGia")) {
                this.editInvoiceViewModel.donGiaErr = true;
            } else {
                this.editInvoiceViewModel.donGiaErr = false;
            }
    
            if (inputNameError.equals("doiTuongKH")) {
                this.editInvoiceViewModel.doiTuongKHErr = true;
            } else {
                this.editInvoiceViewModel.doiTuongKHErr = false;
            }
    
            if (inputNameError.equals("dinhMuc")) {
                this.editInvoiceViewModel.dinhMucErr = true;
            } else {
                this.editInvoiceViewModel.dinhMucErr = false;
            }
    
            if (inputNameError.equals("quocTich")) {
                this.editInvoiceViewModel.quocTichErr = true;
            } else {
                this.editInvoiceViewModel.quocTichErr = false;
            }
        } catch (Exception e) {
            msg = responseError.getMsg();
        }
        
        this.editInvoiceViewModel.msg = msg;

        if (this.editInvoiceView != null) {
            this.editInvoiceView.showMsgError(this.editInvoiceViewModel);
        }
    }

    @Override
    public void exportResult(EditInvoiceOutputDTO outputDTO) {
        editInvoiceViewModel.msg = outputDTO.getMsg();
        editInvoiceViewModel.status = outputDTO.getStatus();

        if (this.editInvoiceView != null) {
            this.editInvoiceView.showMsgResult(this.editInvoiceViewModel);
        }
    }

    @Override
    public void present(EditInvoiceOutputDTO editInvoiceOutputDTO) {
        editInvoiceViewModel.status = editInvoiceOutputDTO.getStatus();
        editInvoiceViewModel.msg = editInvoiceOutputDTO.getMsg();
        editInvoiceViewModel.maKH = editInvoiceOutputDTO.getMaKH();
        editInvoiceViewModel.tenKH = editInvoiceOutputDTO.getTenKH();
        editInvoiceViewModel.ngayHD = editInvoiceOutputDTO.getNgayHD();
        editInvoiceViewModel.donGia = editInvoiceOutputDTO.getDonGia();
        editInvoiceViewModel.soLuong = editInvoiceOutputDTO.getSoLuong();
        editInvoiceViewModel.quocTich = editInvoiceOutputDTO.getQuocTich();
        editInvoiceViewModel.doiTuongKH = editInvoiceOutputDTO.getDoiTuongKH();
        editInvoiceViewModel.dinhMuc = editInvoiceOutputDTO.getDinhMuc();
        
        if (this.editInvoiceView != null) {
            this.editInvoiceView.showInvoice(this.editInvoiceViewModel);
        }
    }
}
