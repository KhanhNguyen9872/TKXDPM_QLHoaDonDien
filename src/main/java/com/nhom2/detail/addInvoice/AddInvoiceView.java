package com.nhom2.detail.addInvoice;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddInvoiceView extends JFrame {
    private AddInvoiceController addInvoiceController;

    public AddInvoiceView() {

    }

    public void setAddInvoiceController(AddInvoiceController addInvoiceController) {
        this.addInvoiceController = addInvoiceController;
    }

    public void mainShow() {
        buildPanel();
        this.setVisible(true);
    }

    private void buildPanel() {
        this.setTitle("Thêm hóa đơn tiền điện");
        this.setSize(400, 300);
    }

    public void showResult(AddInvoiceViewModel addInvoiceViewModel) {
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
