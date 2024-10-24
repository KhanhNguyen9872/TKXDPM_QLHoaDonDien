package com.nhom2.detail.sumKHInvoice;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceInputDTO;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumKHInvoiceView extends JFrame implements ActionListener {
    private SumKHInvoiceController sumKHInvoiceController;
    private JLabel lb_loaiKH;
    private JComboBox<String> cb_loaiKH;
    private JButton sumInvoiceBtn;

    public void mainShow() {
        build();
        setTitle("Sum Customer Invoice Form");
        setSize(400, 400);
        setResizable(false);
        setLayout(new GridLayout(8, 2));
        setVisible(true);
    }

    private void build() {
        getContentPane().removeAll();

        // Initialize JLabels as instance variables
        lb_loaiKH = new JLabel("Loại khách hàng:");

        // Initialize JComboBox as instance variables
        String[] options = {"", "Tất cả", "Nước ngoài", "Việt Nam"};
        cb_loaiKH = new JComboBox<>(options);

        // Add JLabels and JTextFields to the frame
        add(lb_loaiKH); add(cb_loaiKH);

        // Create and add submit button
        sumInvoiceBtn = new JButton("Sum");
        sumInvoiceBtn.addActionListener(this);
        add(new JLabel()); // Empty cell in grid
        add(sumInvoiceBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        
        if (cmd.equals(sumInvoiceBtn.getActionCommand())) {
            SumKHInvoiceInputDTO sumKHInvoiceInputDTO = new SumKHInvoiceInputDTO();
            sumKHInvoiceInputDTO.setLoaiKH(cb_loaiKH.getSelectedItem().toString());
            sumKHInvoiceController.execute(sumKHInvoiceInputDTO);
        }
    }

    public void showMsgError(SumKHInvoiceViewModel sumKHInvoiceViewModel) {
        JOptionPane.showMessageDialog(null,
            sumKHInvoiceViewModel.msg,
            sumKHInvoiceViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }

    public void showMsgResult(SumKHInvoiceViewModel sumKHInvoiceViewModel) {
        JOptionPane.showMessageDialog(null,
            sumKHInvoiceViewModel.msg,
            sumKHInvoiceViewModel.status,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void setSumKHInvoiceController(SumKHInvoiceController sumKHInvoiceController) {
        this.sumKHInvoiceController = sumKHInvoiceController;
    }

}
