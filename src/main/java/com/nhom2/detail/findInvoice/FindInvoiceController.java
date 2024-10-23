package com.nhom2.detail.findInvoice;

import com.nhom2.businessRules.findInvoice.FindInvoiceInputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceInputDTO;

public class FindInvoiceController {
    private FindInvoiceInputBoundary findInvoiceInputBoundary;

    public FindInvoiceController(FindInvoiceInputBoundary findInvoiceInputBoundary) {
        this.findInvoiceInputBoundary = findInvoiceInputBoundary;
    }

    public void execute(FindInvoiceInputDTO findInvoiceInputDTO) {
        this.findInvoiceInputBoundary.execute(findInvoiceInputDTO);
    }
}
