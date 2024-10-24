package com.nhom2.businessRules.sumKHInvoice;

public interface SumKHInvoiceOutputBoundary {
    public void exportError(SumKHInvoiceOutputDTO responseError);
    public void present(SumKHInvoiceOutputDTO sumKHInvoiceOutputDTO);
}
