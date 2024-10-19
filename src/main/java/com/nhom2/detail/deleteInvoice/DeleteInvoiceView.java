package com.nhom2.detail.deleteInvoice;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DeleteInvoiceView extends JFrame {

    public DeleteInvoiceView() {
        
    }
    
    public void show(DeleteInvoiceViewModel deleteInvoiceViewModel) {
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
}
