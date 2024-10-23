package com.nhom2.detail.deleteInvoice;

import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputDTO;

public class DeleteInvoicePresenter implements DeleteInvoiceOutputBoundary {
    private DeleteInvoiceView deleteInvoiceView;
    private DeleteInvoiceViewModel deleteInvoiceViewModel;

    public DeleteInvoicePresenter(DeleteInvoiceView deleteInvoiceView) {
        this.deleteInvoiceView = deleteInvoiceView;
    }

    @Override
    public void exportError(DeleteInvoiceOutputDTO responseError) {
        this.deleteInvoiceViewModel = new DeleteInvoiceViewModel();
        this.deleteInvoiceViewModel.status = "error";
        this.deleteInvoiceViewModel.msg = responseError.getMsg();

        if (this.deleteInvoiceView != null) {
            this.deleteInvoiceView.showMsgError(this.deleteInvoiceViewModel);
        }
    }

    @Override
    public void present(DeleteInvoiceOutputDTO outputDTO) {
        this.deleteInvoiceViewModel = new DeleteInvoiceViewModel();
        this.deleteInvoiceViewModel.status = "success";
        this.deleteInvoiceViewModel.msg = outputDTO.getMsg();
        if (this.deleteInvoiceView != null) {
            this.deleteInvoiceView.showMsgResult(this.deleteInvoiceViewModel);
        }
    }

    public DeleteInvoiceViewModel getDeleteInvoiceViewModel() {
        return this.deleteInvoiceViewModel;
    }
}
