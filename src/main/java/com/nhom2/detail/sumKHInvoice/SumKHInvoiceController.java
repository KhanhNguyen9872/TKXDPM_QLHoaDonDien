package com.nhom2.detail.sumKHInvoice;

import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceInputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceInputDTO;

public class SumKHInvoiceController {
    private SumKHInvoiceInputBoundary sumKHInvoiceInputBoundary;

    public SumKHInvoiceController(SumKHInvoiceInputBoundary sumKHInvoiceInputBoundary) {
        this.sumKHInvoiceInputBoundary = sumKHInvoiceInputBoundary;
    }

    public void execute(SumKHInvoiceInputDTO sumKHInvoiceInputDTO) {
        this.sumKHInvoiceInputBoundary.execute(sumKHInvoiceInputDTO);
    }
}
