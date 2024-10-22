package com.nhom2.detail.deleteInvoice;

import com.nhom2.businessRules.deleteInvoice.ResponseData;
import com.nhom2.businessRules.deleteInvoice.ResponseError;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputDTO;

public class DeleteInvoicePresenter implements DeleteInvoiceOutputBoundary {
    private DeleteInvoiceView deleteInvoiceView;
    private DeleteInvoiceViewModel deleteInvoiceViewModel;

    public DeleteInvoicePresenter(DeleteInvoiceView deleteInvoiceView) {
        this.deleteInvoiceView = deleteInvoiceView;
    }

    @Override
    public void exportError(ResponseError responseError) {
        this.deleteInvoiceViewModel = new DeleteInvoiceViewModel();
        this.deleteInvoiceViewModel.status = "error";
        this.deleteInvoiceViewModel.msg = responseError.getMsg();
        viewShow();

    }

    @Override
    public void exportResult(ResponseData responseData) {
        this.deleteInvoiceViewModel = new DeleteInvoiceViewModel();
        this.deleteInvoiceViewModel.status = "success";
        this.deleteInvoiceViewModel.msg = responseData.getMsg();
        viewShow();
    }

    @Override
    public void present(DeleteInvoiceOutputDTO outputDTO) {
        this.deleteInvoiceViewModel = new DeleteInvoiceViewModel();
        this.deleteInvoiceViewModel.status = "success";
        this.deleteInvoiceViewModel.msg = outputDTO.getMsg();
        viewShow();
    }

    private void viewShow() {
        if (this.deleteInvoiceView != null) {
            this.deleteInvoiceView.showResult(this.deleteInvoiceViewModel);
        }
    }

    public DeleteInvoiceViewModel getDeleteInvoiceViewModel() {
        return this.deleteInvoiceViewModel;
    }
}
