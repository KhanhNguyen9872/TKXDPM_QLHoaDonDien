package com.nhom2.detail.editInvoice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

import com.nhom2.businessRules.editInvoice.EditInvoiceInputDTO;
import com.nhom2.businessRules.editInvoice.EditInvoiceOutputDTO;

public class EditInvoiceView extends JFrame implements ActionListener {
    private EditInvoiceController editInvoiceController;
    private JTextField tf_MaKH, tf_TenKH, tf_NgayHD, tf_SoLuong, tf_DonGia, tf_QuocTich, tf_DinhMuc;
    private JLabel lb_MaKH, lb_TenKH, lb_NgayHD, lb_SoLuong, lb_DonGia, lb_QuocTich, lb_DoiTuongKH, lb_DinhMuc;
    private JComboBox<String> cb_DoiTuongKH;
    private JButton editBtn;
    private JFrame jFrameEdit;

    public EditInvoiceView() {
        
    }

    public void mainShow() {
        buildFind();
        setTitle("Sửa hóa đơn tiền điện");
        setSize(400, 400);
        setResizable(false);
        setLayout(new GridLayout(6, 2));
        setVisible(true);
    }

    private void mainShowEdit() {
        jFrameEdit.setTitle("Sửa hóa đơn tiền điện");
        jFrameEdit.setSize(400, 400);
        jFrameEdit.setResizable(false);
        jFrameEdit.setLayout(new GridLayout(9, 2));
        jFrameEdit.setVisible(true);
    }

    private void build() {
        this.jFrameEdit = new JFrame();

        // Initialize JLabels as instance variables
        lb_MaKH = new JLabel("Mã khách hàng:");
        lb_TenKH = new JLabel("Tên khách hàng:");
        lb_NgayHD = new JLabel("Ngày hóa đơn:");
        lb_SoLuong = new JLabel("Số lượng:");
        lb_DonGia = new JLabel("Đơn giá:");
        lb_QuocTich = new JLabel("Quốc tịch:");
        lb_DoiTuongKH = new JLabel("Đối tượng KH:");
        lb_DinhMuc = new JLabel("Định mức:");

        // Initialize JTextFields as instance variables
        tf_MaKH = new JTextField(10);
        tf_TenKH = new JTextField(10);
        tf_NgayHD = new JTextField(10);
        tf_SoLuong = new JTextField(10);
        tf_DonGia = new JTextField(10);
        tf_QuocTich = new JTextField(10);
        tf_DinhMuc = new JTextField(10);

        // Initialize JComboBox as instance variables
        String[] options = {"", "Sinh hoạt", "Kinh doanh", "Sản xuất"};
        cb_DoiTuongKH = new JComboBox<>(options);

        // Add JLabels and JTextFields to the frame
        jFrameEdit.add(lb_MaKH); jFrameEdit.add(tf_MaKH);
        jFrameEdit.add(lb_TenKH); jFrameEdit.add(tf_TenKH);
        jFrameEdit.add(lb_NgayHD); jFrameEdit.add(tf_NgayHD);
        jFrameEdit.add(lb_SoLuong); jFrameEdit.add(tf_SoLuong);
        jFrameEdit.add(lb_DonGia); jFrameEdit.add(tf_DonGia);
        jFrameEdit.add(lb_QuocTich); jFrameEdit.add(tf_QuocTich);
        jFrameEdit.add(lb_DoiTuongKH); jFrameEdit.add(cb_DoiTuongKH);
        jFrameEdit.add(lb_DinhMuc); jFrameEdit.add(tf_DinhMuc);

        // Create and add submit button
        editBtn = new JButton("Update");
        editBtn.addActionListener(this);
        jFrameEdit.add(new JLabel());
        jFrameEdit.add(editBtn);
    }

    private void buildFind() {
        getContentPane().removeAll();
        
        // Initialize JLabels as instance variables
        lb_MaKH = new JLabel("Mã khách hàng: ");

        // Initialize JTextFields as instance variables
        tf_MaKH = new JTextField();

        // Add JLabels and JTextFields to the frame
        add(lb_MaKH); add(tf_MaKH);

        // Create and add submit button
        JButton btnSubmit = new JButton("Find");
        btnSubmit.addActionListener(this);
        add(new JLabel()); // Empty cell in grid
        add(btnSubmit);
    }

    public void setEditInvoiceController(EditInvoiceController editInvoiceController) {
        this.editInvoiceController = editInvoiceController;
    }

    public void showInvoice(EditInvoiceViewModel editInvoiceViewModel) {
        String maKH = editInvoiceViewModel.maKH;
        String tenKH = editInvoiceViewModel.tenKH;
        String ngayHD = editInvoiceViewModel.ngayHD;
        String soLuong = editInvoiceViewModel.soLuong;
        String donGia = editInvoiceViewModel.donGia;
        String quocTich = editInvoiceViewModel.quocTich;
        String doiTuongKH = editInvoiceViewModel.doiTuongKH;
        String dinhMuc = editInvoiceViewModel.dinhMuc;

        build();
        tf_MaKH.setText(maKH);
        tf_TenKH.setText(tenKH);
        tf_NgayHD.setText(ngayHD);
        tf_SoLuong.setText(soLuong);
        tf_DonGia.setText(donGia);
        tf_QuocTich.setText(quocTich);
        cb_DoiTuongKH.setSelectedItem(doiTuongKH);
        tf_DinhMuc.setText(dinhMuc);
        mainShowEdit();
    }

    public void showMsgResult(EditInvoiceViewModel editInvoiceViewModel) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
        editInvoiceViewModel.msg,
        editInvoiceViewModel.status,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMsgError(EditInvoiceViewModel editInvoiceViewModel) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
        editInvoiceViewModel.msg,
        editInvoiceViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        EditInvoiceInputDTO editInvoiceInputDTO = new EditInvoiceInputDTO();

        if (cmd.equals("Find")) {
            editInvoiceInputDTO.setMaKH(tf_MaKH.getText());
            editInvoiceController.executeFind(editInvoiceInputDTO);
            this.setVisible(false);
        }

        if (cmd.equals("Update")) {
            editInvoiceInputDTO.setMaKH(tf_MaKH.getText());
            editInvoiceInputDTO.setTenKH(tf_TenKH.getText());
            editInvoiceInputDTO.setNgayHD(tf_NgayHD.getText());
            editInvoiceInputDTO.setSoLuong(tf_SoLuong.getText());
            editInvoiceInputDTO.setDonGia(tf_DonGia.getText());
            editInvoiceInputDTO.setQuocTich(tf_QuocTich.getText());
            editInvoiceInputDTO.setDoiTuongKH(cb_DoiTuongKH.getSelectedItem().toString());
            editInvoiceInputDTO.setDinhMuc(tf_DinhMuc.getText());
            editInvoiceController.execute(editInvoiceInputDTO);
            jFrameEdit.setVisible(false);
            jFrameEdit.dispose();
        }
    }
}
