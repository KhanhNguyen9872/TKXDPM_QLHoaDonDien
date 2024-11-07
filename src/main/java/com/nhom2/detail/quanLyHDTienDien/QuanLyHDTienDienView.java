package com.nhom2.detail.quanLyHDTienDien;

import javax.swing.*;

import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienInputDTO;

import java.awt.event.*;
import java.awt.*;

public class QuanLyHDTienDienView extends JFrame implements ActionListener {
    private JButton addInvoiceBtn, deleteInvoiceBtn, editInvoiceBtn, exportAllInvoiceBtn, exportInvoiceByMonthBtn, findInvoiceBtn, avgMoneyInvoiceBtn, sumKHInvoiceBtn;
    private QuanLyHDTienDienController quanLyHDTienDienController;

    public QuanLyHDTienDienView() {
        setTitle("Quản lý hóa đơn tiền điện");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 200);

        // Create title label
        JLabel titleLabel = new JLabel("QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Create button
        addInvoiceBtn = new JButton("Thêm");
        deleteInvoiceBtn = new JButton("Xóa");
        editInvoiceBtn = new JButton("Sửa");
        exportAllInvoiceBtn = new JButton("Xuất toàn bộ");
        exportInvoiceByMonthBtn = new JButton("Xuất theo tháng");
        findInvoiceBtn = new JButton("Tìm kiếm");
        avgMoneyInvoiceBtn = new JButton("Tính TB thành tiền nước ngoài");
        sumKHInvoiceBtn = new JButton("Tổng khách hàng");

        // Add ActionListener
        addInvoiceBtn.addActionListener(this);
        deleteInvoiceBtn.addActionListener(this);
        editInvoiceBtn.addActionListener(this);
        exportAllInvoiceBtn.addActionListener(this);
        exportInvoiceByMonthBtn.addActionListener(this);
        findInvoiceBtn.addActionListener(this);
        avgMoneyInvoiceBtn.addActionListener(this);
        sumKHInvoiceBtn.addActionListener(this);

        // Set up layout for the frame
        setLayout(new FlowLayout());
        add(titleLabel);
        add(addInvoiceBtn);
        add(deleteInvoiceBtn);
        add(editInvoiceBtn);
        add(exportAllInvoiceBtn);
        add(exportInvoiceByMonthBtn);
        add(findInvoiceBtn);
        add(avgMoneyInvoiceBtn);
        add(sumKHInvoiceBtn);

        // Make the frame visible
        setLocationRelativeTo(null);
    }

    public void showGUI() {
        setVisible(true);
    }

    
    public void setQuanLyHDTienDienController(QuanLyHDTienDienController quanLyHDTienDienController) {
        this.quanLyHDTienDienController = quanLyHDTienDienController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        
        QuanLyHDTienDienInputDTO quanLyHDTienDienInputDTO = new QuanLyHDTienDienInputDTO();
        quanLyHDTienDienInputDTO.setChucNang(cmd);
        this.quanLyHDTienDienController.execute(quanLyHDTienDienInputDTO);
    }

    public void showMsgError(QuanLyHDTienDienViewModel quanLyHDTienDienViewModel) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
        quanLyHDTienDienViewModel.msg,
        quanLyHDTienDienViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }

    public void showMsgResult(QuanLyHDTienDienViewModel quanLyHDTienDienViewModel) {
        return;
    }
}
