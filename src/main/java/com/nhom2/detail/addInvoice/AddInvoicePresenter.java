package com.nhom2.detail.addInvoice;

import com.nhom2.businessRules.addInvoice.AddInvoiceOutputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceOutputDTO;

public class AddInvoicePresenter implements AddInvoiceOutputBoundary {
    private AddInvoiceView addInvoiceView;
    private AddInvoiceViewModel addInvoiceViewModel;

    public AddInvoicePresenter(AddInvoiceView addInvoiceView, AddInvoiceViewModel addInvoiceViewModel) {
        this.addInvoiceView = addInvoiceView;
        this.addInvoiceViewModel = addInvoiceViewModel;
    }

    @Override
    public void exportError(AddInvoiceOutputDTO responseError) {
        this.addInvoiceViewModel.status = responseError.getStatus();
        String inputNameError;
        String msg;

        try {
            inputNameError = responseError.getMsg().split(",")[0];
            msg = responseError.getMsg().split(",")[1];

            if (inputNameError.equals("tenKH")) {
                this.addInvoiceViewModel.tenKHErr = true;
            } else {
                this.addInvoiceViewModel.tenKHErr = false;
            }
    
            if (inputNameError.equals("ngayHD")) {
                this.addInvoiceViewModel.ngayHDErr = true;
            } else {
                this.addInvoiceViewModel.ngayHDErr = false;
            }
    
            if (inputNameError.equals("soLuong")) {
                this.addInvoiceViewModel.soLuongErr = true;
            } else {
                this.addInvoiceViewModel.soLuongErr = false;
            }
    
            if (inputNameError.equals("donGia")) {
                this.addInvoiceViewModel.donGiaErr = true;
            } else {
                this.addInvoiceViewModel.donGiaErr = false;
            }
    
            if (inputNameError.equals("doiTuongKH")) {
                this.addInvoiceViewModel.doiTuongKHErr = true;
            } else {
                this.addInvoiceViewModel.doiTuongKHErr = false;
            }
    
            if (inputNameError.equals("dinhMuc")) {
                this.addInvoiceViewModel.dinhMucErr = true;
            } else {
                this.addInvoiceViewModel.dinhMucErr = false;
            }
    
            if (inputNameError.equals("quocTich")) {
                this.addInvoiceViewModel.quocTichErr = true;
            } else {
                this.addInvoiceViewModel.quocTichErr = false;
            }
        } catch (Exception e) {
            msg = responseError.getMsg();
        }
        
        this.addInvoiceViewModel.msg = msg;
        
        if (this.addInvoiceView != null) {
            this.addInvoiceView.showMsgError(this.addInvoiceViewModel);
        }
    }

    @Override
    public void present(AddInvoiceOutputDTO outputDTO) {
        this.addInvoiceViewModel.status = outputDTO.getStatus();
        this.addInvoiceViewModel.msg = outputDTO.getMsg();

        if (this.addInvoiceView != null) {
            this.addInvoiceView.showMsgResult(this.addInvoiceViewModel);
        }
    }
}
