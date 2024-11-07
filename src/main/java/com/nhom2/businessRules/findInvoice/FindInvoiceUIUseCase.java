package com.nhom2.businessRules.findInvoice;

import com.nhom2.detail.findInvoice.FindInvoiceView;

public class FindInvoiceUIUseCase implements FindInvoiceUIInputBoundary {
    private FindInvoiceView findInvoiceView;

    public FindInvoiceUIUseCase(FindInvoiceView findInvoiceView) {
        this.findInvoiceView = findInvoiceView;
    } 

    @Override
    public void execute() {
        this.findInvoiceView.mainShow();
    }
}
