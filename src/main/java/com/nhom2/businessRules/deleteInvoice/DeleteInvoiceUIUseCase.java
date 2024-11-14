package com.nhom2.businessRules.deleteInvoice;

import com.nhom2.detail.deleteInvoice.DeleteInvoiceUIPresenter;

public class DeleteInvoiceUIUseCase implements DeleteInvoiceUIInputBoundary {
    private DeleteInvoiceUIPresenter deleteInvoiceUIPresenter;

    public DeleteInvoiceUIUseCase(DeleteInvoiceUIPresenter deleteInvoiceUIPresenter) {
        this.deleteInvoiceUIPresenter = deleteInvoiceUIPresenter;
    } 

    @Override
    public void execute(DeleteInvoiceUIInputDTO deleteInvoiceUIInputDTO) {
        DeleteInvoiceUIOutputDTO deleteInvoiceUIOutputDTO = new DeleteInvoiceUIOutputDTO();
        deleteInvoiceUIOutputDTO.setMaKH(deleteInvoiceUIInputDTO.getMaKH());
        this.deleteInvoiceUIPresenter.present(deleteInvoiceUIOutputDTO);
    }

}
