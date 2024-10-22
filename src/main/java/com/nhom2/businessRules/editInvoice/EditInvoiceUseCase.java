package com.nhom2.businessRules.editInvoice;

public class EditInvoiceUseCase implements EditInvoiceInputBoundary {
    private EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary;
    private EditInvoiceOutputBoundary editInvoiceOutputBoundary;

    public EditInvoiceUseCase(EditInvoiceOutputBoundary editInvoiceOutputBoundary,
            EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary) {
        this.editInvoiceDatabaseBoundary = editInvoiceDatabaseBoundary;
        this.editInvoiceOutputBoundary = editInvoiceOutputBoundary;
    }

    @Override
    public void execute(RequestData requestData) {
        
    }
    
}
