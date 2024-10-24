package com.nhom2.detail.avgMoneyInvoiceNuocNgoai;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AvgMoneyInvoiceNuocNgoaiView extends JFrame {
    private AvgMoneyInvoiceNuocNgoaiController avgMoneyInvoiceNuocNgoaiController;

    public AvgMoneyInvoiceNuocNgoaiView() {

    }

    public void mainShow() {
        avgMoneyInvoiceNuocNgoaiController.execute();
    }

    public void showMsgResult(AvgMoneyInvoiceNuocNgoaiViewModel avgMoneyInvoiceNuocNgoaiViewModel) {
        JOptionPane.showMessageDialog(null,
        avgMoneyInvoiceNuocNgoaiViewModel.msg,
        avgMoneyInvoiceNuocNgoaiViewModel.status,
                        JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMsgError(AvgMoneyInvoiceNuocNgoaiViewModel avgMoneyInvoiceNuocNgoaiViewModel) {
        JOptionPane.showMessageDialog(null,
        avgMoneyInvoiceNuocNgoaiViewModel.msg,
        avgMoneyInvoiceNuocNgoaiViewModel.status,
                        JOptionPane.ERROR_MESSAGE);
    }

    public void setAvgMoneyInvoiceNuocNgoaiController(AvgMoneyInvoiceNuocNgoaiController avgMoneyInvoiceNuocNgoaiController) {
        this.avgMoneyInvoiceNuocNgoaiController = avgMoneyInvoiceNuocNgoaiController;
    }
}
