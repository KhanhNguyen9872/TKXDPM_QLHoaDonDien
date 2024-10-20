package com.nhom2.detail.deleteInvoice;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DeleteInvoiceView extends JFrame {
    private DeleteInvoiceController deleteInvoiceController;

    public DeleteInvoiceView() {
        
    }

    public void mainShow() {
        buildPanel();
        this.setVisible(true);
    }

    private void buildPanel() {
        this.setTitle("Xóa hóa đơn tiền điện");
        this.setSize(400, 300);
    }
    
    public void showResult(DeleteInvoiceViewModel deleteInvoiceViewModel) {
        this.setTitle(deleteInvoiceViewModel.status);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Show alert dialog
        JOptionPane.showMessageDialog(this,
                deleteInvoiceViewModel.msg,
                deleteInvoiceViewModel.status,
                JOptionPane.INFORMATION_MESSAGE);

        this.setVisible(true);
    }

    public void setDeleteInvoiceController(DeleteInvoiceController deleteInvoiceController) {
        this.deleteInvoiceController = deleteInvoiceController;
    }
}
