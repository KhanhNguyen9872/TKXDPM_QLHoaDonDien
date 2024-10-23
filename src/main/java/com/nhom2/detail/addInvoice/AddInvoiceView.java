package com.nhom2.detail.addInvoice;

import javax.swing.*;

import com.nhom2.businessRules.addInvoice.AddInvoiceInputDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddInvoiceView extends JFrame implements ActionListener {
    private AddInvoiceController addInvoiceController;
    private JTextField tf_TenKH, tf_NgayHD, tf_SoLuong, tf_DonGia, tf_QuocTich, tf_DoiTuongKH, tf_DinhMuc;
    private JLabel lb_TenKH, lb_NgayHD, lb_SoLuong, lb_DonGia, lb_QuocTich, lb_DoiTuongKH, lb_DinhMuc;

    public AddInvoiceView() {
        
    }

    public void setAddInvoiceController(AddInvoiceController addInvoiceController) {
        this.addInvoiceController = addInvoiceController;
    }

    public void mainShow() {
        build();
        setTitle("Add Invoice Form");
        setSize(400, 400);
        setResizable(false);
        setLayout(new GridLayout(8, 2));
        setVisible(true);
    }

    private void build() {
        getContentPane().removeAll();

        // Initialize JLabels as instance variables
        lb_TenKH = new JLabel("Tên khách hàng:");
        lb_NgayHD = new JLabel("Ngày hóa đơn:");
        lb_SoLuong = new JLabel("Số lượng:");
        lb_DonGia = new JLabel("Đơn giá:");
        lb_QuocTich = new JLabel("Quốc tịch:");
        lb_DoiTuongKH = new JLabel("Đối tượng KH:");
        lb_DinhMuc = new JLabel("Định mức:");

        // Initialize JTextFields as instance variables
        tf_TenKH = new JTextField();
        tf_NgayHD = new JTextField();
        tf_SoLuong = new JTextField();
        tf_DonGia = new JTextField();
        tf_QuocTich = new JTextField();
        tf_DoiTuongKH = new JTextField();
        tf_DinhMuc = new JTextField();

        // Add JLabels and JTextFields to the frame
        add(lb_TenKH); add(tf_TenKH);
        add(lb_NgayHD); add(tf_NgayHD);
        add(lb_SoLuong); add(tf_SoLuong);
        add(lb_DonGia); add(tf_DonGia);
        add(lb_QuocTich); add(tf_QuocTich);
        add(lb_DoiTuongKH); add(tf_DoiTuongKH);
        add(lb_DinhMuc); add(tf_DinhMuc);

        // Create and add submit button
        JButton btnSubmit = new JButton("Add");
        btnSubmit.addActionListener(this);
        add(new JLabel()); // Empty cell in grid
        add(btnSubmit);
    }

    public void showMsgResult(AddInvoiceViewModel addInvoiceViewModel) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                addInvoiceViewModel.msg,
                addInvoiceViewModel.status,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMsgError(AddInvoiceViewModel addInvoiceViewModel) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                addInvoiceViewModel.msg,
                addInvoiceViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Add")) {
            AddInvoiceInputDTO addInvoiceInputDTO = new AddInvoiceInputDTO();
            addInvoiceInputDTO.setTenKH(tf_TenKH.getText());
            addInvoiceInputDTO.setNgayHD(tf_NgayHD.getText());
            addInvoiceInputDTO.setSoLuong(tf_SoLuong.getText());
            addInvoiceInputDTO.setDonGia(tf_DonGia.getText());
            addInvoiceInputDTO.setQuocTich(tf_QuocTich.getText());
            addInvoiceInputDTO.setDoiTuongKH(tf_DoiTuongKH.getText());
            addInvoiceInputDTO.setDinhMuc(tf_DinhMuc.getText());

            addInvoiceController.execute(addInvoiceInputDTO);
        }
    }
}
