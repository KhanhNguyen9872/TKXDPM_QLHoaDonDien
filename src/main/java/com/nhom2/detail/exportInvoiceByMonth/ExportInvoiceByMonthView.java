package com.nhom2.detail.exportInvoiceByMonth;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthInputDTO;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;

public class ExportInvoiceByMonthView extends JFrame implements ActionListener {
    private ExportInvoiceByMonthController exportInvoiceByMonthController;
    private JLabel lb_Month;
    private JComboBox<String> cb_Month;
    private JButton exportInvoiceBtn;
    private List<ExportInvoiceByMonthViewModel> listViewModel;

    public ExportInvoiceByMonthView() {
        
    }

    public void mainShow() {
        build();
        setTitle("Xuất hóa đơn tiền điện theo tháng");
        setSize(400, 400);
        setResizable(false);
        setLayout(new GridLayout(6, 2));
        setVisible(true);
    }

    private void build() {
        getContentPane().removeAll();

        // Initialize JLabels as instance variables
        lb_Month = new JLabel("Tháng: ");

        // Initialize JComboBox as instance variables
        String[] options = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        cb_Month = new JComboBox<>(options);

        // Add JLabels and JTextFields to the frame
        add(lb_Month); add(cb_Month);

        // Create and add submit button
        exportInvoiceBtn = new JButton("Find");
        exportInvoiceBtn.addActionListener(this);
        add(new JLabel()); // Empty cell in grid
        add(exportInvoiceBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals(exportInvoiceBtn.getActionCommand())) {
            ExportInvoiceByMonthInputDTO exportInvoiceByMonthInputDTO = new ExportInvoiceByMonthInputDTO();
            exportInvoiceByMonthInputDTO.setMonth(cb_Month.getSelectedItem().toString());;
            exportInvoiceByMonthController.execute(exportInvoiceByMonthInputDTO);
        }
    }

    public void setExportInvoiceByMonthController(ExportInvoiceByMonthController exportInvoiceByMonthController) {
        this.exportInvoiceByMonthController = exportInvoiceByMonthController;
    }

    public void showResult(List<ExportInvoiceByMonthViewModel> listViewModel) {
        this.listViewModel = listViewModel;
        getContentPane().removeAll();
        setTitle("Xuất hóa đơn tiền điện theo tháng");
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
        for (ExportInvoiceByMonthViewModel viewModel: listViewModel) {
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

            ExportInvoiceByMonthViewModel vm = listViewModel.get(row);

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

    public void showMsgError(ExportInvoiceByMonthViewModel responseError) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                responseError.msg,
                responseError.status,
                JOptionPane.ERROR_MESSAGE);
    }

    public void showMsgResult(ExportInvoiceByMonthViewModel responseData) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                responseData.msg,
                responseData.status,
                JOptionPane.INFORMATION_MESSAGE);
    }

}
