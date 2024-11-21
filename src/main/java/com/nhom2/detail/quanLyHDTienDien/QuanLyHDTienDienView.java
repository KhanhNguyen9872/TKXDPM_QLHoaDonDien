package com.nhom2.detail.quanLyHDTienDien;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.nhom2.businessRules.getListInvoice.GetListInvoiceInputBoundary;
import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienInputDTO;
import com.nhom2.detail.getListInvoice.GetListInvoiceViewModel;

import java.awt.event.*;
import java.awt.*;
import java.util.List;
import com.nhom2.detail.observer.Subscriber;

public class QuanLyHDTienDienView extends JFrame implements ListSelectionListener, ActionListener, Subscriber {
    private static QuanLyHDTienDienView quanLyHDTienDienView;
    private JLabel labelUsername;
    private JButton addInvoiceBtn, deleteInvoiceBtn, editInvoiceBtn, exportInvoiceByMonthBtn, findInvoiceBtn, avgMoneyInvoiceBtn, sumKHInvoiceBtn, signOutBtn;
    private JTable table;
    private DefaultTableModel tableModel;
    private int selectedRow = -1;
    private QuanLyHDTienDienController quanLyHDTienDienController;
    private List<GetListInvoiceViewModel> listInvoice;
    private GetListInvoiceInputBoundary getListInvoiceInputBoundary;

    private QuanLyHDTienDienView() {
        setTitle("Quản lý hóa đơn tiền điện");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1200, 500);
    
        // Create title label
        JLabel titleLabel = new JLabel("QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Padding around the title
    
        // Column headers for the JTable
        String[] columns = {
            "Mã KH", "Tên KH", "Ngày HD", "Số lượng", "Đơn giá", "Quốc tịch", "Đối tượng KH", "Định mức", "Thành tiền"
        };
    
        // Create table model
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(this);
    
        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
    
        // Set up layout for the frame
        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH); // Add title label at the top
        this.add(scrollPane, BorderLayout.CENTER); // Add the table in the center
    
        // Create button panel for the buttons at the bottom
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 18, 18));
        
        addInvoiceBtn = new JButton("Thêm");
        deleteInvoiceBtn = new JButton("Xóa");
        editInvoiceBtn = new JButton("Sửa");
        exportInvoiceByMonthBtn = new JButton("Xuất theo tháng");
        findInvoiceBtn = new JButton("Tìm kiếm");
        avgMoneyInvoiceBtn = new JButton("Tính TB thành tiền nước ngoài");
        sumKHInvoiceBtn = new JButton("Tổng khách hàng");
        signOutBtn = new JButton("Đăng xuất");

        labelUsername = new JLabel("User: ");
    
        // Add ActionListener
        addInvoiceBtn.addActionListener(this);
        deleteInvoiceBtn.addActionListener(this);
        editInvoiceBtn.addActionListener(this);
        exportInvoiceByMonthBtn.addActionListener(this);
        findInvoiceBtn.addActionListener(this);
        avgMoneyInvoiceBtn.addActionListener(this);
        sumKHInvoiceBtn.addActionListener(this);
        signOutBtn.addActionListener(this);
    
        // Add buttons to the panel
        buttonPanel.add(addInvoiceBtn);
        buttonPanel.add(deleteInvoiceBtn);
        buttonPanel.add(editInvoiceBtn);
        buttonPanel.add(exportInvoiceByMonthBtn);
        buttonPanel.add(findInvoiceBtn);
        buttonPanel.add(avgMoneyInvoiceBtn);
        buttonPanel.add(sumKHInvoiceBtn);
        buttonPanel.add(labelUsername);
        buttonPanel.add(signOutBtn);
    
        // Add the button panel to the bottom
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setLocationRelativeTo(null);
    }

    public void setListInvoice(List<GetListInvoiceViewModel> listInvoice) {
        this.listInvoice = listInvoice;
    }

    public void setGetListInvoiceInputBoundary(GetListInvoiceInputBoundary getListInvoiceInputBoundary) {
        this.getListInvoiceInputBoundary = getListInvoiceInputBoundary;
    }

    public static QuanLyHDTienDienView getQuanLyHDTienDienView() {

        if (quanLyHDTienDienView == null) {
            quanLyHDTienDienView = new QuanLyHDTienDienView();
        }

        return quanLyHDTienDienView;
    }
    
    public void setResultListInvoice(List<GetListInvoiceViewModel> listInvoice_) {
        tableModel.setRowCount(0);
        // Add data to the table
        for (GetListInvoiceViewModel invoice : listInvoice_) {
            Object[] row = {
                invoice.maKH,
                invoice.tenKH,
                invoice.ngayHD,
                invoice.soLuong,
                invoice.donGia,
                invoice.quocTich,
                invoice.doiTuongKH,
                invoice.dinhMuc,
                invoice.thanhTien
            };
            tableModel.addRow(row);
        }
    }

    private void getList() {
        this.getListInvoiceInputBoundary.execute();

        tableModel.setRowCount(0);
        // Add data to the table
        for (GetListInvoiceViewModel invoice : listInvoice) {
            Object[] row = {
                invoice.maKH,
                invoice.tenKH,
                invoice.ngayHD,
                invoice.soLuong,
                invoice.donGia,
                invoice.quocTich,
                invoice.doiTuongKH,
                invoice.dinhMuc,
                invoice.thanhTien
            };
            tableModel.addRow(row);
        }
    }

    public void showGUI() {
        this.getList();
        setVisible(true);
    }
    
    public void setQuanLyHDTienDienController(QuanLyHDTienDienController quanLyHDTienDienController) {
        this.quanLyHDTienDienController = quanLyHDTienDienController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals(signOutBtn.getText())) {
            this.setVisible(false);
        }

        QuanLyHDTienDienInputDTO quanLyHDTienDienInputDTO = new QuanLyHDTienDienInputDTO();

        if (selectedRow != -1) {
            String maKH = table.getValueAt(selectedRow, 0).toString();
            String tenKH = table.getValueAt(selectedRow, 1).toString();
            String ngayHD = table.getValueAt(selectedRow, 2).toString();
            String soLuong = table.getValueAt(selectedRow, 3).toString();
            String donGia = table.getValueAt(selectedRow, 4).toString();
            String quocTich = table.getValueAt(selectedRow, 5).toString();
            String doiTuongKH = table.getValueAt(selectedRow, 6).toString();
            String dinhMuc = table.getValueAt(selectedRow, 7).toString();
            String thanhTien = table.getValueAt(selectedRow, 8).toString();

            quanLyHDTienDienInputDTO.setMaKH(maKH);
            quanLyHDTienDienInputDTO.setTenKH(tenKH);
            quanLyHDTienDienInputDTO.setNgayHD(ngayHD);
            quanLyHDTienDienInputDTO.setSoLuong(soLuong);
            quanLyHDTienDienInputDTO.setDonGia(donGia);
            quanLyHDTienDienInputDTO.setQuocTich(quocTich);
            quanLyHDTienDienInputDTO.setDoiTuongKH(doiTuongKH);
            quanLyHDTienDienInputDTO.setDinhMuc(dinhMuc);
            quanLyHDTienDienInputDTO.setThanhTien(thanhTien);
        }
        
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

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.selectedRow = table.getSelectedRow(); // Get the index of the selected row
    }

    public void setUser(String username, boolean isAdmin) {
        this.labelUsername.setText("User: " + username);
        if (isAdmin) {
            addInvoiceBtn.setVisible(true);
            deleteInvoiceBtn.setVisible(true);
            editInvoiceBtn.setVisible(true);
        } else {
            addInvoiceBtn.setVisible(false);
            deleteInvoiceBtn.setVisible(false);
            editInvoiceBtn.setVisible(false);
        }
    }

    @Override
    public void update() {
        this.getList();
    }
}
