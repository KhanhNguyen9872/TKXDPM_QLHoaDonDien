package com.nhom2.detail.addInvoice;

import com.nhom2.businessRules.addInvoice.AddInvoiceInputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceInputDTO;

public class AddInvoiceController {
    private AddInvoiceInputBoundary addInvoiceInputBoundary;
    
    public AddInvoiceController(AddInvoiceInputBoundary addInvoiceInputBoundary) {
        this.addInvoiceInputBoundary = addInvoiceInputBoundary;
    }

    public void execute(AddInvoiceInputDTO addInvoiceInputDTO) {
        this.addInvoiceInputBoundary.execute(addInvoiceInputDTO);
    }
}
