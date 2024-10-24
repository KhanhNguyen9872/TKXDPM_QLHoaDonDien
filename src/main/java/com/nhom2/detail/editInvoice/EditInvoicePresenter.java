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
        editInvoiceViewModel.msg = responseError.getMsg();

        if (this.editInvoiceView != null) {
            this.editInvoiceView.showMsgError(this.editInvoiceViewModel);
        }
    }

    @Override
    public void present(EditInvoiceOutputDTO outputDTO) {
        editInvoiceViewModel.msg = outputDTO.getMsg();
        editInvoiceViewModel.status = outputDTO.getStatus();

        if (this.editInvoiceView != null) {
            this.editInvoiceView.showMsgResult(this.editInvoiceViewModel);
        }
    }

    @Override
    public void presentFind(EditInvoiceOutputDTO editInvoiceOutputDTO) {
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