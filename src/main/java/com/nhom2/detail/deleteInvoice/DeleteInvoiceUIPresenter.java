package com.nhom2.detail.deleteInvoice;

import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUIOutputDTO;

public class DeleteInvoiceUIPresenter {
    private DeleteInvoiceUIView deleteInvoiceUIView;
    private DeleteInvoiceUIViewModel deleteInvoiceUIViewModel;

    public DeleteInvoiceUIPresenter(DeleteInvoiceUIView deleteInvoiceUIView, DeleteInvoiceUIViewModel deleteInvoiceUIViewModel) {
        this.deleteInvoiceUIView = deleteInvoiceUIView;
        this.deleteInvoiceUIViewModel = deleteInvoiceUIViewModel;
    }

    public void present(DeleteInvoiceUIOutputDTO deleteInvoiceUIOutputDTO) {
        String maKH = deleteInvoiceUIOutputDTO.getMaKH();

        deleteInvoiceUIViewModel.maKH = maKH;
        this.deleteInvoiceUIView.mainShow(deleteInvoiceUIViewModel);
    }

}
