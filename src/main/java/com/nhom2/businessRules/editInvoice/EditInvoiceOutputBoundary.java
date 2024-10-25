package com.nhom2.businessRules.editInvoice;

public interface EditInvoiceOutputBoundary {
    public void exportError(EditInvoiceOutputDTO responseError);
    public void exportResult(EditInvoiceOutputDTO outputDTO);
    public void present(EditInvoiceOutputDTO editInvoiceOutputDTO);
}
