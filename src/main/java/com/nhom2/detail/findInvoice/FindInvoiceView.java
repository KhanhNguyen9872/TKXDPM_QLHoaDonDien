package com.nhom2.detail.findInvoice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.nhom2.businessRules.findInvoice.FindInvoiceInputDTO;

public class FindInvoiceView extends JFrame implements ActionListener {
    private FindInvoiceController findInvoiceController;
    private JLabel loaiTimKiem, lb_loaiTimKiemErr, lb_NhapErr;
    private JComboBox<String> cb_loaiTimKiem;
    private JTextField tf_Nhap;
    private JButton findInvoiceBtn;
    private List<FindInvoiceViewModel> listViewModel;
    
    public FindInvoiceView() {

    }
    
    public void mainShow() {
        buildFind();
        setTitle("Tìm kiếm hóa đơn tiền điện");
        setSize(600, 200);
        setResizable(false);
        setLayout(new GridLayout(6, 2));
        setVisible(true);
    }

    private void buildFind() {
        getContentPane().removeAll();
        
        // Initialize JLabels as instance variables
        loaiTimKiem = new JLabel("Loại tìm kiếm: ");
        lb_loaiTimKiemErr = new JLabel("");
        lb_loaiTimKiemErr.setForeground(Color.RED);

        lb_NhapErr = new JLabel("");
        lb_NhapErr.setForeground(Color.RED);

        // Initialize JComboBox as instance variables
        String[] options = {"", "Mã KH", "Tên KH", "Ngày HD"};
        cb_loaiTimKiem = new JComboBox<>(options);

        cb_loaiTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lb_NhapErr.setText("");
            }
        });

        // Initialize JTextFields as instance variables
        tf_Nhap = new JTextField();

        // Add JLabels and JTextFields to the frame
        add(loaiTimKiem); add(cb_loaiTimKiem);
        add(new JLabel()); add(lb_loaiTimKiemErr);
        add(new JLabel("Nhập:")); add(tf_Nhap);
        add(new JLabel()); add(lb_NhapErr);

        // Create and add submit button
        findInvoiceBtn = new JButton("Find");
        findInvoiceBtn.addActionListener(this);
        add(new JLabel()); // Empty cell in grid
        add(findInvoiceBtn);
    }

    public void showMsgError(FindInvoiceViewModel findInvoiceViewModel) {

        String msg = findInvoiceViewModel.msg;

        if (findInvoiceViewModel.typeFindErr) {
            cb_loaiTimKiem.requestFocusInWindow();
            lb_loaiTimKiemErr.setText(msg);
        } else {
            lb_loaiTimKiemErr.setText("");
        }

        if (findInvoiceViewModel.inputFindErr) {
            tf_Nhap.requestFocusInWindow();
            lb_NhapErr.setText(msg);
        } else {
            lb_NhapErr.setText("");
        }

        JOptionPane.showMessageDialog(null,
            msg,
            findInvoiceViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }


    public void setFindInvoiceController(FindInvoiceController findInvoiceController) {
        this.findInvoiceController = findInvoiceController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals(findInvoiceBtn.getActionCommand())) {
            FindInvoiceInputDTO findInvoiceInputDTO = new FindInvoiceInputDTO();
            String loai = cb_loaiTimKiem.getSelectedItem().toString();

            if (loai.equals("Mã KH")) {
                findInvoiceInputDTO.setMaKH(tf_Nhap.getText());
            } else if (loai.equals("Tên KH")) {
                findInvoiceInputDTO.setTenKH(tf_Nhap.getText());
            } else if (loai.equals("Ngày HD")) {
                findInvoiceInputDTO.setNgayHD(tf_Nhap.getText());
            }

            findInvoiceInputDTO.setFindType(loai);
            
            findInvoiceController.execute(findInvoiceInputDTO);
        }
    }

    public void showResult(List<FindInvoiceViewModel> listViewModel) {
        this.listViewModel = listViewModel;
        getContentPane().removeAll();
        setTitle("Tìm kiếm hóa đơn tiền điện");
        setResizable(false);
        setSize(900, 500);

        // Create title label
        JLabel titleLabel = new JLabel("DANH SÁCH HÓA ĐƠN TIỀN ĐIỆN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Padding around the title

        // Column headers for the JTable
        String[] columns = {
            "Mã KH", "Tên KH", "Ngày HD", "Số lượng", "Đơn giá", "Quốc tịch", "Đối tượng KH", "Định mức", "Thành tiền"
        };

        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        //custom
        table.setDefaultRenderer(Object.class, new InvoiceCellRenderer());

        // Add student data to the table
        for (FindInvoiceViewModel viewModel: listViewModel) {
            Object[] row = {
                viewModel.maKH,
                viewModel.tenKH,
                viewModel.ngayHD,
                viewModel.soLuong,
                viewModel.donGia,
                viewModel.quocTich,
                viewModel.doiTuongKH,
                viewModel.dinhMuc,
                viewModel.thanhTien
            };
            tableModel.addRow(row);
        }

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Set up layout for the frame
        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH); // Add title label at the top
        this.add(scrollPane, BorderLayout.CENTER); // Add the table in the center

        // Make the frame visible
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    class InvoiceCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            FindInvoiceViewModel vm = listViewModel.get(row);

            // if(column == 5){
            //     c.setForeground(vm.textColor);
            //         if(vm.bold){
            //             c.setFont(c.getFont().deriveFont(Font.BOLD));
            //         }

            //         if (vm.bold && vm.italic) {
            //             c.setFont(c.getFont().deriveFont(Font.BOLD | Font.ITALIC));
            //         }
                
            // } else {
            //     c.setForeground(Color.BLACK);
            // }
            
            return c;
        }
    }

}
