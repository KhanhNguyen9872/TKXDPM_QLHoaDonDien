package com.nhom2.detail.deleteInvoice;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DeleteInvoiceView extends JFrame {
    private DeleteInvoiceController deleteInvoiceController;

    public DeleteInvoiceView() {
        
    }

    public void mainShow() {
        build();
        this.setVisible(true);
    }

    private void build() {
        getContentPane().removeAll();
        this.setTitle("Xóa hóa đơn tiền điện");
        this.setSize(400, 300);
    }
    
    public void showMsgResult(DeleteInvoiceViewModel deleteInvoiceViewModel) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                deleteInvoiceViewModel.msg,
                deleteInvoiceViewModel.status,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMsgError(DeleteInvoiceViewModel deleteInvoiceViewModel) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                deleteInvoiceViewModel.msg,
                deleteInvoiceViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }

    public void setDeleteInvoiceController(DeleteInvoiceController deleteInvoiceController) {
        this.deleteInvoiceController = deleteInvoiceController;
    }
}
