package com.nhom2.businessRules.addInvoice;

public interface AddInvoiceOutputBoundary {
    public void exportError(AddInvoiceOutputDTO outputDTO);
    public void present(AddInvoiceOutputDTO outputDTO);
}
