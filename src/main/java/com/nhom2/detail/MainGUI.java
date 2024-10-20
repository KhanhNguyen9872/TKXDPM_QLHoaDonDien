package com.nhom2.detail;

import java.awt.Font;

import javax.swing.*;

import com.nhom2.detail.addInvoice.AddInvoiceView;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceView;
import com.nhom2.detail.getListInvoice.GetListInvoiceView;

import java.awt.event.*;
import java.awt.*;

public class MainGUI extends JFrame implements ActionListener {
    private AddInvoiceView addInvoiceView;
    private DeleteInvoiceView deleteInvoiceView;
    private GetListInvoiceView getListInvoiceView;

    public MainGUI() {
        setTitle("Invoice management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 150);

        // Create title label
        JLabel titleLabel = new JLabel("QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Create button
        JButton addInvoiceBtn = new JButton("Thêm");
        JButton deleteInvoiceBtn = new JButton("Xóa");
        JButton editInvoiceBtn = new JButton("Sửa");
        JButton exportInvoiceBtn = new JButton("Xuất");

        // Add ActionListener
        addInvoiceBtn.addActionListener(this);
        deleteInvoiceBtn.addActionListener(this);
        editInvoiceBtn.addActionListener(this);
        exportInvoiceBtn.addActionListener(this);

        // Set up layout for the frame
        setLayout(new FlowLayout());
        add(titleLabel);
        add(addInvoiceBtn);
        add(deleteInvoiceBtn);
        add(editInvoiceBtn);
        add(exportInvoiceBtn);

        // Make the frame visible
        setLocationRelativeTo(null);
    }

    public void showGUI() {
        setVisible(true);
    }

    public void setAddInvoiceView(AddInvoiceView addInvoiceView) {
        this.addInvoiceView = addInvoiceView;
    }

    public void setDeleteInvoiceView(DeleteInvoiceView deleteInvoiceView) {
        this.deleteInvoiceView = deleteInvoiceView;
    }

    public void setGetListInvoiceView(GetListInvoiceView getListInvoiceView) {
        this.getListInvoiceView = getListInvoiceView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        
        if (cmd.equals("Thêm")) {
            if (addInvoiceView != null) {
                addInvoiceView.mainShow();
            }
        }

        if (cmd.equals("Xóa")) {
            if (deleteInvoiceView != null) {
                deleteInvoiceView.mainShow();
            }
        }

        if (cmd.equals("Sửa")) {

        }

        if (cmd.equals("Xuất")) {
            if (getListInvoiceView != null) {
                getListInvoiceView.mainShow();
            }
        }
    }
}
