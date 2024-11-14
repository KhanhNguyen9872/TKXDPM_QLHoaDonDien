package com.nhom2.detail.deleteInvoice;

import javax.swing.JOptionPane;

import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputDTO;

public class DeleteInvoiceUIView {
    private DeleteInvoiceController deleteInvoiceController;

    public void mainShow(DeleteInvoiceUIViewModel deleteInvoiceUIViewModel) {
        String maKH = deleteInvoiceUIViewModel.maKH;
        // build();s
        // setTitle("Xóa hóa đơn tiền điện");
        // setSize(400, 150);
        // setResizable(false);
        // setLayout(new GridLayout(3, 2));
        // setVisible(true);
        int result = JOptionPane.showConfirmDialog(null, 
            "Bạn có muốn xóa KH " + maKH + " ?", 
            "Xác nhận hành động", 
            JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            DeleteInvoiceInputDTO deleteInvoiceInputDTO = new DeleteInvoiceInputDTO();
            deleteInvoiceInputDTO.setMaKH(maKH);

            deleteInvoiceController.execute(deleteInvoiceInputDTO);
        }
    }

    public void setDeleteInvoiceController(DeleteInvoiceController deleteInvoiceController) {
        this.deleteInvoiceController = deleteInvoiceController;
    }

}
