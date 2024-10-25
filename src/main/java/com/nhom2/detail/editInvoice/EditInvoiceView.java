package com.nhom2.detail.editInvoice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.*;

import com.nhom2.businessRules.editInvoice.EditInvoiceInputDTO;

public class EditInvoiceView extends JFrame implements ActionListener {
    private EditInvoiceController editInvoiceController;
    private JTextField tf_MaKH, tf_TenKH, tf_SoLuong, tf_DonGia, tf_QuocTich, tf_DinhMuc;
    private JLabel lb_MaKH, lb_TenKH, lb_NgayHD, lb_SoLuong, lb_DonGia, lb_QuocTich, lb_DoiTuongKH, lb_DinhMuc;
    private JComboBox<String> cb_DoiTuongKH;
    private JButton editInvoiceBtn, findInvoiceBtn;
    private JXDatePicker dp_NgayHD;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

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
        setTitle("Sửa hóa đơn tiền điện");
        setSize(400, 400);
        setResizable(false);
        setLayout(new GridLayout(9, 2));
        setVisible(true);
    }

    private void build() {
        getContentPane().removeAll();

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
        tf_MaKH.setEditable(false);
        tf_TenKH = new JTextField(10);
        tf_SoLuong = new JTextField(10);
        tf_DonGia = new JTextField(10);
        tf_QuocTich = new JTextField(10);
        tf_DinhMuc = new JTextField(10);

        // Initialize JComboBox as instance variables
        String[] options = {"", "Sinh hoạt", "Kinh doanh", "Sản xuất"};
        cb_DoiTuongKH = new JComboBox<>(options);

        // Initialize JXDatePicker
        dp_NgayHD = new JXDatePicker();
        dp_NgayHD.setDate(Calendar.getInstance().getTime());
        dp_NgayHD.setFormats(formatter);

        // Add JLabels and JTextFields to the frame
        add(lb_MaKH); add(tf_MaKH);
        add(lb_TenKH); add(tf_TenKH);
        add(lb_NgayHD); add(dp_NgayHD);
        add(lb_SoLuong); add(tf_SoLuong);
        add(lb_DonGia); add(tf_DonGia);
        add(lb_QuocTich); add(tf_QuocTich);
        add(lb_DoiTuongKH); add(cb_DoiTuongKH);
        add(lb_DinhMuc); add(tf_DinhMuc);

        // Create and add submit button
        editInvoiceBtn = new JButton("Update");
        editInvoiceBtn.addActionListener(this);
        add(new JLabel());
        add(editInvoiceBtn);
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
        findInvoiceBtn = new JButton("Find");
        findInvoiceBtn.addActionListener(this);
        add(new JLabel()); // Empty cell in grid
        add(findInvoiceBtn);
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

        try {
            dp_NgayHD.setDate(formatter.parse(ngayHD));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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

        setVisible(false);
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

        if (cmd.equals(findInvoiceBtn.getActionCommand())) {
            editInvoiceInputDTO.setMaKH(tf_MaKH.getText());
            editInvoiceController.executeFind(editInvoiceInputDTO);
        }

        if (cmd.equals(editInvoiceBtn.getActionCommand())) {
            editInvoiceInputDTO.setMaKH(tf_MaKH.getText());
            editInvoiceInputDTO.setTenKH(tf_TenKH.getText());
            editInvoiceInputDTO.setNgayHD(formatter.format(dp_NgayHD.getDate()));
            editInvoiceInputDTO.setSoLuong(tf_SoLuong.getText());
            editInvoiceInputDTO.setDonGia(tf_DonGia.getText());
            editInvoiceInputDTO.setQuocTich(tf_QuocTich.getText());
            editInvoiceInputDTO.setDoiTuongKH(cb_DoiTuongKH.getSelectedItem().toString());
            editInvoiceInputDTO.setDinhMuc(tf_DinhMuc.getText());
            editInvoiceController.execute(editInvoiceInputDTO);
        }
    }
}
