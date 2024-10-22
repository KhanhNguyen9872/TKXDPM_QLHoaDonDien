package com.nhom2.detail.addInvoice;

import com.nhom2.businessRules.addInvoice.AddInvoiceInputBoundary;
import com.nhom2.businessRules.addInvoice.RequestData;

public class AddInvoiceController {
    private AddInvoiceInputBoundary addInvoiceInputBoundary;
    
    public AddInvoiceController(AddInvoiceInputBoundary addInvoiceInputBoundary) {
        this.addInvoiceInputBoundary = addInvoiceInputBoundary;
    }

    public void execute(AddInvoiceViewModel addInvoiceViewModel) {
        RequestData requestData = new RequestData();
        this.addInvoiceInputBoundary.execute(requestData);
    }
}
