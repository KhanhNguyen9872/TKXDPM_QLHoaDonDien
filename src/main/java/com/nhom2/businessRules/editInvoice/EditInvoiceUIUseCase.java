package com.nhom2.businessRules.editInvoice;

import com.nhom2.detail.editInvoice.EditInvoiceView;

public class EditInvoiceUIUseCase implements EditInvoiceUIInputBoundary {
    private EditInvoiceView editInvoiceView;

    public EditInvoiceUIUseCase(EditInvoiceView editInvoiceView) {
        this.editInvoiceView = editInvoiceView;
    } 

    @Override
    public void execute() {
        this.editInvoiceView.mainShow();
    }
}
