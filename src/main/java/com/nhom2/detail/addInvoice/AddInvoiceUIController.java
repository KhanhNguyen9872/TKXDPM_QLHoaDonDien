package com.nhom2.detail.addInvoice;

import com.nhom2.businessRules.addInvoice.AddInvoiceUIInputBoundary;

public class AddInvoiceUIController {
    private AddInvoiceUIInputBoundary addInvoiceUIInputBoundary;

    public AddInvoiceUIController(AddInvoiceUIInputBoundary addInvoiceUIInputBoundary) {
        this.addInvoiceUIInputBoundary = addInvoiceUIInputBoundary;
    }

    public void execute() {
        this.addInvoiceUIInputBoundary.execute();
    }
}
