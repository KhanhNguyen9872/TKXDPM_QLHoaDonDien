package com.nhom2.detail.addInvoice;

import javax.swing.*;

import org.jdesktop.swingx.JXDatePicker;

import com.nhom2.businessRules.addInvoice.AddInvoiceInputDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddInvoiceView extends JFrame implements ActionListener {
    private AddInvoiceController addInvoiceController;
    private JTextField tf_TenKH, tf_SoLuong, tf_DonGia, tf_QuocTich, tf_DinhMuc;
    private JLabel lb_TenKH, lb_NgayHD, lb_SoLuong, lb_DonGia, lb_QuocTich, lb_DoiTuongKH, lb_DinhMuc, lb_isKHNN;
    private JLabel lb_TenKHErr, lb_NgayHDErr, lb_SoLuongErr, lb_DonGiaErr, lb_QuocTichErr, lb_DoiTuongKHErr, lb_DinhMucErr;
    private JCheckBox jCb_isKHNN;
    private JComboBox<String> cb_DoiTuongKH;
    private JButton addInvoiceBtn;
    private JXDatePicker dp_NgayHD;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public AddInvoiceView() {
        
    }

    public void setAddInvoiceController(AddInvoiceController addInvoiceController) {
        this.addInvoiceController = addInvoiceController;
    }

    public void mainShow() {
        build();
        setTitle("Add Invoice Form");
        setSize(600, 400);
        setResizable(false);
        setLayout(new GridLayout(17, 2));
        setVisible(true);
    }

    private void build() {
        getContentPane().removeAll();

        // Initialize JLabels as instance variables
        lb_TenKH = new JLabel("Tên khách hàng:");
        lb_NgayHD = new JLabel("Ngày hóa đơn:");
        lb_SoLuong = new JLabel("Số lượng:");
        lb_DonGia = new JLabel("Đơn giá:");
        lb_isKHNN = new JLabel("Là khách hàng nước ngoài: ");
        lb_QuocTich = new JLabel("Quốc tịch:");
        lb_DoiTuongKH = new JLabel("Đối tượng KH:");
        lb_DinhMuc = new JLabel("Định mức:");

        lb_TenKHErr = new JLabel("");
        lb_NgayHDErr = new JLabel("");
        lb_SoLuongErr = new JLabel("");
        lb_DonGiaErr = new JLabel("");
        lb_QuocTichErr = new JLabel("");
        lb_DoiTuongKHErr = new JLabel("");
        lb_DinhMucErr = new JLabel("");

        lb_TenKHErr.setForeground(Color.RED);
        lb_NgayHDErr.setForeground(Color.RED);
        lb_SoLuongErr.setForeground(Color.RED);
        lb_DonGiaErr.setForeground(Color.RED);
        lb_QuocTichErr.setForeground(Color.RED);
        lb_DoiTuongKHErr.setForeground(Color.RED);
        lb_DinhMucErr.setForeground(Color.RED);

        // Initialize JTextFields as instance variables
        tf_TenKH = new JTextField();
        tf_SoLuong = new JTextField("0");
        tf_DonGia = new JTextField("0");
        tf_QuocTich = new JTextField();
        tf_DinhMuc = new JTextField("0");

        // Initialize JCheckBox as instance variables
        jCb_isKHNN = new JCheckBox();
        jCb_isKHNN.addItemListener(v -> {
            
            if (!jCb_isKHNN.isSelected()) {
                tf_QuocTich.setText("");
                tf_QuocTich.setEnabled(false);

                cb_DoiTuongKH.setEnabled(true);

                tf_DinhMuc.setEnabled(true);
            } else {
                tf_QuocTich.setEnabled(true);

                cb_DoiTuongKH.setSelectedIndex(0);
                cb_DoiTuongKH.setEnabled(false);

                tf_DinhMuc.setText("0");
                tf_DinhMuc.setEnabled(false);
            }
        });

        // Initialize JComboBox as instance variables
        String[] options = {"", "Sinh hoạt", "Kinh doanh", "Sản xuất"};
        cb_DoiTuongKH = new JComboBox<>(options);
        cb_DoiTuongKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lb_DoiTuongKHErr.setText("");
            }
        });

        // Initialize JXDatePicker
        dp_NgayHD = new JXDatePicker();
        dp_NgayHD.setDate(Calendar.getInstance().getTime());
        dp_NgayHD.setFormats(formatter);

        // Add JLabels and JTextFields to the frame
        add(lb_TenKH); add(tf_TenKH);
        add(new Label()); add(lb_TenKHErr);
        add(lb_NgayHD); add(dp_NgayHD);
        add(new Label()); add(lb_NgayHDErr);
        add(lb_SoLuong); add(tf_SoLuong);
        add(new Label()); add(lb_SoLuongErr);
        add(lb_DonGia); add(tf_DonGia);
        add(new Label()); add(lb_DonGiaErr);
        add(lb_isKHNN); add(jCb_isKHNN);
        add(lb_QuocTich); add(tf_QuocTich);
        add(new Label()); add(lb_QuocTichErr);
        add(lb_DoiTuongKH); add(cb_DoiTuongKH);
        add(new Label()); add(lb_DoiTuongKHErr);
        add(lb_DinhMuc); add(tf_DinhMuc);
        add(new Label()); add(lb_DinhMucErr);

        // Create and add submit button
        addInvoiceBtn = new JButton("Add");
        addInvoiceBtn.addActionListener(this);
        add(new JLabel()); // Empty cell in grid
        add(addInvoiceBtn);

        tf_QuocTich.setText("");
        tf_QuocTich.setEnabled(false);
        cb_DoiTuongKH.setEnabled(true);
        tf_DinhMuc.setEnabled(true);
    }

    public void showMsgResult(AddInvoiceViewModel addInvoiceViewModel) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                addInvoiceViewModel.msg,
                addInvoiceViewModel.status,
                JOptionPane.INFORMATION_MESSAGE);
        wipeInput();
    }

    private void wipeInput() {
        tf_TenKH.setText("");
        tf_SoLuong.setText("0");
        tf_DonGia.setText("0");
        tf_QuocTich.setText("");
        tf_DinhMuc.setText("0");
        cb_DoiTuongKH.setSelectedIndex(0);
        dp_NgayHD.setDate(Calendar.getInstance().getTime());

        lb_TenKHErr.setText("");
        lb_NgayHDErr.setText("");
        lb_SoLuongErr.setText("");
        lb_DonGiaErr.setText("");
        lb_QuocTichErr.setText("");
        lb_DoiTuongKHErr.setText("");
        lb_DinhMucErr.setText("");
    }

    public void showMsgError(AddInvoiceViewModel addInvoiceViewModel) {
        String msg = addInvoiceViewModel.msg;

        if (addInvoiceViewModel.dinhMucErr) {
            tf_DinhMuc.requestFocusInWindow();
            lb_DinhMucErr.setText(msg);
        } else {
            lb_DinhMucErr.setText("");
        }

        if (addInvoiceViewModel.doiTuongKHErr) {
            cb_DoiTuongKH.requestFocusInWindow();
            lb_DoiTuongKHErr.setText(msg);
        } else {
            lb_DoiTuongKHErr.setText("");
        }

        if (addInvoiceViewModel.quocTichErr) {
            tf_QuocTich.requestFocusInWindow();
            lb_QuocTichErr.setText(msg);
        } else {
            lb_QuocTichErr.setText("");
        }

        if (addInvoiceViewModel.donGiaErr) {
            tf_DonGia.requestFocusInWindow();
            lb_DonGiaErr.setText(msg);
        } else {
            lb_DonGiaErr.setText("");
        }

        if (addInvoiceViewModel.soLuongErr) {
            tf_SoLuong.requestFocusInWindow();
            lb_SoLuongErr.setText(msg);
        } else {
            lb_SoLuongErr.setText("");
        }

        if (addInvoiceViewModel.ngayHDErr) {
            dp_NgayHD.requestFocusInWindow();
            lb_NgayHDErr.setText(msg);
        } else {
            lb_NgayHDErr.setText("");
        }

        if (addInvoiceViewModel.tenKHErr) {
            tf_TenKH.requestFocusInWindow();
            lb_TenKHErr.setText(msg);
        } else {
            lb_TenKHErr.setText("");
        }

        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                msg,
                addInvoiceViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Add")) {
            AddInvoiceInputDTO addInvoiceInputDTO = new AddInvoiceInputDTO();

            addInvoiceInputDTO.setTenKH(tf_TenKH.getText());
            addInvoiceInputDTO.setNgayHD(formatter.format(dp_NgayHD.getDate()));
            addInvoiceInputDTO.setSoLuong(tf_SoLuong.getText());
            addInvoiceInputDTO.setDonGia(tf_DonGia.getText());
            addInvoiceInputDTO.setLaNuocNgoai(jCb_isKHNN.isSelected());
            addInvoiceInputDTO.setQuocTich(tf_QuocTich.getText());
            addInvoiceInputDTO.setDoiTuongKH(cb_DoiTuongKH.getSelectedItem().toString());
            addInvoiceInputDTO.setDinhMuc(tf_DinhMuc.getText());

            addInvoiceController.execute(addInvoiceInputDTO);
        }
    }
}
