package com.nhom2.businessRules.addInvoice;

import com.nhom2.detail.addInvoice.AddInvoiceView;

public class AddInvoiceUIUseCase implements AddInvoiceUIInputBoundary {
    private AddInvoiceView addInvoiceView;

    public AddInvoiceUIUseCase(AddInvoiceView addInvoiceView) {
        this.addInvoiceView = addInvoiceView;
    } 

    @Override
    public void execute() {
        
        this.addInvoiceView.mainShow();
    }

}
