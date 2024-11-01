package com.nhom2.detail.deleteInvoice;

import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputDTO;

public class DeleteInvoicePresenter implements DeleteInvoiceOutputBoundary {
    private DeleteInvoiceView deleteInvoiceView;
    private DeleteInvoiceViewModel deleteInvoiceViewModel;

    public DeleteInvoicePresenter(DeleteInvoiceView deleteInvoiceView, DeleteInvoiceViewModel deleteInvoiceViewModel) {
        this.deleteInvoiceView = deleteInvoiceView;
        this.deleteInvoiceViewModel = deleteInvoiceViewModel;
    }

    @Override
    public void exportError(DeleteInvoiceOutputDTO responseError) {
        this.deleteInvoiceViewModel.status = "error";
        String inputNameError;
        String msg;
        try {
            inputNameError = responseError.getMsg().split(",")[0];
            msg = responseError.getMsg().split(",")[1];

            if (inputNameError.equals("maKH")) {
                this.deleteInvoiceViewModel.maKH = false;
            } else {
                this.deleteInvoiceViewModel.maKH = true;
            }

        } catch (Exception e) {
            msg = responseError.getMsg();
        }
        
        this.deleteInvoiceViewModel.msg = msg;

        if (this.deleteInvoiceView != null) {
            this.deleteInvoiceView.showMsgError(this.deleteInvoiceViewModel);
        }
    }

    @Override
    public void present(DeleteInvoiceOutputDTO outputDTO) {
        this.deleteInvoiceViewModel.status = "success";
        this.deleteInvoiceViewModel.msg = outputDTO.getMsg();
        if (this.deleteInvoiceView != null) {
            this.deleteInvoiceView.showMsgResult(this.deleteInvoiceViewModel);
        }
    }
}
