package com.nhom2.detail.getListInvoice;

import com.nhom2.businessRules.getListInvoice.GetListInvoiceInputBoundary;

public class GetListInvoiceController {
    private GetListInvoiceInputBoundary getListInvoiceInputBoundary;
    
    public GetListInvoiceController(GetListInvoiceInputBoundary getListInvoiceInputBoundary) {
        this.getListInvoiceInputBoundary = getListInvoiceInputBoundary;
    }

    public void execute() {
        this.getListInvoiceInputBoundary.execute();
    }
}
