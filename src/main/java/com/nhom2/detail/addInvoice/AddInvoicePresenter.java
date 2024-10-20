package com.nhom2.detail.addInvoice;

import com.nhom2.businessRules.ResponseData;
import com.nhom2.businessRules.ResponseError;
import com.nhom2.businessRules.addInvoice.AddInvoiceOutputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceOutputDTO;

public class AddInvoicePresenter implements AddInvoiceOutputBoundary {
    private AddInvoiceView addInvoiceView;
    private AddInvoiceViewModel addInvoiceViewModel;

    public AddInvoicePresenter(AddInvoiceView addInvoiceView) {
        this.addInvoiceView = addInvoiceView;
    }

    public AddInvoiceViewModel getAddInvoiceViewModel() {
        return this.addInvoiceViewModel;
    }

    @Override
    public void exportError(ResponseError responseError) {
        this.addInvoiceViewModel = new AddInvoiceViewModel();
        this.addInvoiceViewModel.status = "error";
        this.addInvoiceViewModel.msg = responseError.getMsg();
        viewShow();
    }

    @Override
    public void exportResult(ResponseData responseData) {
        this.addInvoiceViewModel = new AddInvoiceViewModel();
        this.addInvoiceViewModel.status = "success";
        this.addInvoiceViewModel.msg = responseData.getMsg();
        viewShow();
    }

    @Override
    public void present(AddInvoiceOutputDTO outputDTO) {
        this.addInvoiceViewModel = new AddInvoiceViewModel();
        this.addInvoiceViewModel.status = "success";
        this.addInvoiceViewModel.msg = outputDTO.getMsg();
        viewShow();
    }

    private void viewShow() {
        this.addInvoiceView.showResult(this.addInvoiceViewModel);
    }
}
