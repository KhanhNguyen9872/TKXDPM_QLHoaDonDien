package com.nhom2.detail.addInvoice;

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
    public void exportError(AddInvoiceOutputDTO responseError) {
        this.addInvoiceViewModel = new AddInvoiceViewModel();
        this.addInvoiceViewModel.status = responseError.getStatus();
        this.addInvoiceViewModel.msg = responseError.getMsg();

        if (this.addInvoiceView != null) {
            this.addInvoiceView.showMsgError(this.addInvoiceViewModel);
        }
    }

    @Override
    public void present(AddInvoiceOutputDTO outputDTO) {
        this.addInvoiceViewModel = new AddInvoiceViewModel();
        this.addInvoiceViewModel.status = outputDTO.getStatus();
        this.addInvoiceViewModel.msg = outputDTO.getMsg();

        if (this.addInvoiceView != null) {
            this.addInvoiceView.showMsgResult(this.addInvoiceViewModel);
        }
    }
}
