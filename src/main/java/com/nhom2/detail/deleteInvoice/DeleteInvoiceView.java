package com.nhom2.detail.deleteInvoice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputDTO;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteInvoiceView extends JFrame implements ActionListener {
    private DeleteInvoiceController deleteInvoiceController;
    private JLabel lb_maKH;
    private JTextField tf_maKH;

    public DeleteInvoiceView() {
        
    }

    public void mainShow() {
        build();
        setTitle("Xóa hóa đơn tiền điện");
        setSize(400, 300);
        setResizable(false);
        setLayout(new GridLayout(4, 2));
        setVisible(true);
        setVisible(true);
    }

    private void build() {
        getContentPane().removeAll();
        
        // Initialize JLabels as instance variables
        lb_maKH = new JLabel("Mã khách hàng:");

        // Initialize JTextFields as instance variables
        tf_maKH = new JTextField();

        // Add JLabels and JTextFields to the frame
        add(lb_maKH); add(tf_maKH);

        // Create and add submit button
        JButton btnSubmit = new JButton("Delete");
        btnSubmit.addActionListener(this);
        add(new JLabel()); // Empty cell in grid
        add(btnSubmit);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Delete")) {
            DeleteInvoiceInputDTO deleteInvoiceInputDTO = new DeleteInvoiceInputDTO();
            deleteInvoiceInputDTO.setMaKH(tf_maKH.getText());

            deleteInvoiceController.execute(deleteInvoiceInputDTO);
        }
    }
}
