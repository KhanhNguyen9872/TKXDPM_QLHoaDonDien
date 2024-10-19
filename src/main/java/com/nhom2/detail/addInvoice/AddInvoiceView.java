package com.nhom2.detail.addInvoice;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddInvoiceView extends JFrame {

    public AddInvoiceView() {

    }

    public void show(AddInvoiceViewModel addInvoiceViewModel) {
        this.setTitle(addInvoiceViewModel.status);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Show alert dialog
        JOptionPane.showMessageDialog(this,
                addInvoiceViewModel.msg,
                addInvoiceViewModel.status,
                JOptionPane.INFORMATION_MESSAGE);

        this.setVisible(true);
    }
}
