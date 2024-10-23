package com.nhom2.detail.deleteInvoice;

import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputDTO;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputBoundary;

public class DeleteInvoiceController {
    private DeleteInvoiceInputBoundary deleteInvoiceInputBoundary;
    
    public DeleteInvoiceController(DeleteInvoiceInputBoundary deleteInvoiceInputBoundary) {
        this.deleteInvoiceInputBoundary = deleteInvoiceInputBoundary;
    }

    public void execute(DeleteInvoiceViewModel deleteInvoiceViewModel) {
        DeleteInvoiceInputDTO requestData = new DeleteInvoiceInputDTO();
        // set requestData

        //
        this.deleteInvoiceInputBoundary.execute(requestData);
    }
}
