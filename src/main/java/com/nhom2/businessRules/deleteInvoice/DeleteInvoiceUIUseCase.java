package com.nhom2.businessRules.deleteInvoice;

import com.nhom2.detail.deleteInvoice.DeleteInvoiceView;

public class DeleteInvoiceUIUseCase implements DeleteInvoiceUIInputBoundary {
    private DeleteInvoiceView deleteInvoiceView;

    public DeleteInvoiceUIUseCase(DeleteInvoiceView deleteInvoiceView) {
        this.deleteInvoiceView = deleteInvoiceView;
    } 

    @Override
    public void execute() {
        this.deleteInvoiceView.mainShow();
    }

}
