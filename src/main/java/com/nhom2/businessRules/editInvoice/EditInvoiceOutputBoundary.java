package com.nhom2.businessRules.editInvoice;

public interface EditInvoiceOutputBoundary {
    public void exportError(EditInvoiceOutputDTO responseError);
    public void present(EditInvoiceOutputDTO outputDTO);
    public void presentFind(EditInvoiceOutputDTO editInvoiceOutputDTO);
}
