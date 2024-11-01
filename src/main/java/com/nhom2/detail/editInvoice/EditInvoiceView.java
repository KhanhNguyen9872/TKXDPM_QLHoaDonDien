package com.nhom2.detail.editInvoice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.*;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.*;

import com.nhom2.businessRules.editInvoice.EditInvoiceInputDTO;
import com.nhom2.businessRules.findInvoice.FindInvoiceInputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceInputDTO;
import com.nhom2.detail.findInvoice.FindInvoiceViewModel;

public class EditInvoiceView extends JFrame implements ActionListener {
    private List<FindInvoiceViewModel> findInvoiceViewModels;
    private FindInvoiceInputBoundary findInvoiceInputBoundary;
    private EditInvoiceController editInvoiceController;
    private JTextField tf_MaKH, tf_TenKH, tf_SoLuong, tf_DonGia, tf_QuocTich, tf_DinhMuc;
    private JLabel lb_MaKH, lb_TenKH, lb_NgayHD, lb_SoLuong, lb_DonGia, lb_QuocTich, lb_DoiTuongKH, lb_DinhMuc, lb_isKHNN;
    private JLabel lb_TenKHErr, lb_NgayHDErr, lb_SoLuongErr, lb_DonGiaErr, lb_QuocTichErr, lb_DoiTuongKHErr, lb_DinhMucErr;
    private JCheckBox jCb_isKHNN;
    private JLabel lb_MaKHErr;
    private JComboBox<String> cb_DoiTuongKH;
    private JButton editInvoiceBtn, findInvoiceBtn;
    private JXDatePicker dp_NgayHD;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public EditInvoiceView() {
        
    }

    public void mainShow() {
        buildFind();
        setTitle("Sửa hóa đơn tiền điện");
        setSize(600, 200);
        setResizable(false);
        setLayout(new GridLayout(4, 2));
        setVisible(true);
    }

    private void mainShowEdit() {
        setTitle("Sửa hóa đơn tiền điện");
        setSize(650, 450);
        setResizable(false);
        setLayout(new GridLayout(19, 2));
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

        // Add JLabels and JTextFields to the frame
        add(lb_MaKH); add(tf_MaKH);
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
        editInvoiceBtn = new JButton("Update");
        editInvoiceBtn.addActionListener(this);
        add(new JLabel());
        add(editInvoiceBtn);

        tf_QuocTich.setText("");
        tf_QuocTich.setEnabled(false);
        cb_DoiTuongKH.setEnabled(true);
        tf_DinhMuc.setEnabled(true);
    }

    private void buildFind() {
        getContentPane().removeAll();
        
        // Initialize JLabels as instance variables
        lb_MaKH = new JLabel("Mã khách hàng: ");
        lb_MaKHErr = new JLabel("");
        lb_MaKHErr.setForeground(Color.RED);

        // Initialize JTextFields as instance variables
        tf_MaKH = new JTextField();

        // Add JLabels and JTextFields to the frame
        add(lb_MaKH); add(tf_MaKH);
        add(new JLabel()); add(lb_MaKHErr);

        // Create and add submit button
        findInvoiceBtn = new JButton("Find");
        findInvoiceBtn.addActionListener(this);
        add(new JLabel()); // Empty cell in grid
        add(findInvoiceBtn);
    }

    public void setEditInvoiceController(EditInvoiceController editInvoiceController) {
        this.editInvoiceController = editInvoiceController;
    }

    public void setFindInvoice(FindInvoiceInputBoundary findInvoiceInputBoundary, List<FindInvoiceViewModel> findInvoiceViewModels) {
        this.findInvoiceInputBoundary = findInvoiceInputBoundary;
        this.findInvoiceViewModels = findInvoiceViewModels;
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
        String msg = editInvoiceViewModel.msg;

        if (editInvoiceViewModel.dinhMucErr) {
            tf_DinhMuc.requestFocusInWindow();
            lb_DinhMucErr.setText(msg);
        } else {
            lb_DinhMucErr.setText("");
        }

        if (editInvoiceViewModel.doiTuongKHErr) {
            cb_DoiTuongKH.requestFocusInWindow();
            lb_DoiTuongKHErr.setText(msg);
        } else {
            lb_DoiTuongKHErr.setText("");
        }

        if (editInvoiceViewModel.quocTichErr) {
            tf_QuocTich.requestFocusInWindow();
            lb_QuocTichErr.setText(msg);
        } else {
            lb_QuocTichErr.setText("");
        }

        if (editInvoiceViewModel.donGiaErr) {
            tf_DonGia.requestFocusInWindow();
            lb_DonGiaErr.setText(msg);
        } else {
            lb_DonGiaErr.setText("");
        }

        if (editInvoiceViewModel.soLuongErr) {
            tf_SoLuong.requestFocusInWindow();
            lb_SoLuongErr.setText(msg);
        } else {
            lb_SoLuongErr.setText("");
        }

        if (editInvoiceViewModel.ngayHDErr) {
            dp_NgayHD.requestFocusInWindow();
            lb_NgayHDErr.setText(msg);
        } else {
            lb_NgayHDErr.setText("");
        }

        if (editInvoiceViewModel.tenKHErr) {
            tf_TenKH.requestFocusInWindow();
            lb_TenKHErr.setText(msg);
        } else {
            lb_TenKHErr.setText("");
        }

        // Show alert dialog
        JOptionPane.showMessageDialog(null,
        msg,
        editInvoiceViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        
        if (cmd.equals(findInvoiceBtn.getActionCommand())) {
            FindInvoiceInputDTO findInvoiceInputDTO = new FindInvoiceInputDTO();
            findInvoiceInputDTO.setFindType("Mã KH");
            findInvoiceInputDTO.setMaKH(tf_MaKH.getText());
            
            findInvoiceInputBoundary.execute(findInvoiceInputDTO);
            
            EditInvoiceViewModel editInvoiceViewModel = new EditInvoiceViewModel();
            FindInvoiceViewModel findInvoiceViewModel = this.findInvoiceViewModels.get(0);
            String status = findInvoiceViewModel.status;
            
            if (status.equals("success")) {
                editInvoiceViewModel.maKH = findInvoiceViewModel.maKH;
                editInvoiceViewModel.tenKH = findInvoiceViewModel.tenKH;
                editInvoiceViewModel.ngayHD = findInvoiceViewModel.ngayHD;
                editInvoiceViewModel.soLuong = findInvoiceViewModel.soLuong;
                editInvoiceViewModel.donGia = findInvoiceViewModel.donGia;
                editInvoiceViewModel.quocTich = findInvoiceViewModel.quocTich;
                editInvoiceViewModel.doiTuongKH = findInvoiceViewModel.doiTuongKH;
                editInvoiceViewModel.dinhMuc = findInvoiceViewModel.dinhMuc;

                showInvoice(editInvoiceViewModel);
            }

            if (status.equals("error")) {
                editInvoiceViewModel.status = findInvoiceViewModel.status;
                editInvoiceViewModel.msg = findInvoiceViewModel.msg;
                editInvoiceViewModel.maKHErr = findInvoiceViewModel.inputFindErr;
                showMsgError(editInvoiceViewModel);
            }
            return;
        }

        if (cmd.equals(editInvoiceBtn.getActionCommand())) {
            EditInvoiceInputDTO editInvoiceInputDTO = new EditInvoiceInputDTO();

            editInvoiceInputDTO.setMaKH(tf_MaKH.getText());
            editInvoiceInputDTO.setTenKH(tf_TenKH.getText());
            editInvoiceInputDTO.setNgayHD(formatter.format(dp_NgayHD.getDate()));
            editInvoiceInputDTO.setSoLuong(tf_SoLuong.getText());
            editInvoiceInputDTO.setDonGia(tf_DonGia.getText());
            editInvoiceInputDTO.setLaNuocNgoai(jCb_isKHNN.isSelected());
            editInvoiceInputDTO.setQuocTich(tf_QuocTich.getText());
            editInvoiceInputDTO.setDoiTuongKH(cb_DoiTuongKH.getSelectedItem().toString());
            editInvoiceInputDTO.setDinhMuc(tf_DinhMuc.getText());
            editInvoiceController.execute(editInvoiceInputDTO);
            return;
        }
        
    }
}
