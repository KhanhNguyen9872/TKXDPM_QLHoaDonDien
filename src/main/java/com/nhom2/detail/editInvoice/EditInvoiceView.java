package com.nhom2.detail.editInvoice;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EditInvoiceView extends JFrame {
    private EditInvoiceController editInvoiceController;

    public EditInvoiceView() {
        
    }

    public void mainShow() {
        buildPanel();
        this.setVisible(true);
    }

    private void buildPanel() {
        this.setTitle("Sửa hóa đơn tiền điện");
        this.setSize(400, 300);
    }
    
    public void showResult(EditInvoiceViewModel editInvoiceViewModel) {
        this.setTitle(editInvoiceViewModel.status);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Show alert dialog
        JOptionPane.showMessageDialog(this,
                editInvoiceViewModel.msg,
                editInvoiceViewModel.status,
                JOptionPane.INFORMATION_MESSAGE);

        this.setVisible(true);
    }

    public void setEditInvoiceController(EditInvoiceController editInvoiceController) {
        this.editInvoiceController = editInvoiceController;
    }
}
