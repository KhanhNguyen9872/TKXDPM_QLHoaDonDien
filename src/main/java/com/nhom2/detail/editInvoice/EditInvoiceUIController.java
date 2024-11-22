package com.nhom2.detail.editInvoice;

import com.nhom2.businessRules.editInvoice.EditInvoiceUIInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUIInputDTO;

public class EditInvoiceUIController {
    private EditInvoiceUIInputBoundary editInvoiceUIInputBoundary;

    public EditInvoiceUIController(EditInvoiceUIInputBoundary editInvoiceUIInputBoundary) {
        this.editInvoiceUIInputBoundary = editInvoiceUIInputBoundary;
    }

    public void execute(EditInvoiceUIInputDTO editInvoiceUIInputDTO) {
        this.editInvoiceUIInputBoundary.execute(editInvoiceUIInputDTO);
    }
}
