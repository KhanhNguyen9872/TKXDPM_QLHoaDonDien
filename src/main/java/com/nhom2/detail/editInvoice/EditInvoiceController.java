package com.nhom2.detail.editInvoice;

import com.nhom2.businessRules.editInvoice.EditInvoiceInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputDTO;

public class EditInvoiceController {
    private EditInvoiceInputBoundary editInvoiceInputBoundary;

    public EditInvoiceController(EditInvoiceInputBoundary editInvoiceInputBoundary) {
        this.editInvoiceInputBoundary = editInvoiceInputBoundary;
    }

    public void execute(EditInvoiceInputDTO editInvoiceInputDTO) {
        this.editInvoiceInputBoundary.execute(editInvoiceInputDTO);
    }

}
