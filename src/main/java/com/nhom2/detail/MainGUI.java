package com.nhom2.detail;

import java.awt.Font;

import javax.swing.*;

import com.nhom2.detail.addInvoice.AddInvoiceView;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiView;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceView;
import com.nhom2.detail.editInvoice.EditInvoiceView;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthView;
import com.nhom2.detail.findInvoice.FindInvoiceView;
import com.nhom2.detail.getListInvoice.GetListInvoiceView;
import com.nhom2.detail.sumKHInvoice.SumKHInvoiceView;

import java.awt.event.*;
import java.awt.*;

public class MainGUI extends JFrame implements ActionListener {
    private JButton addInvoiceBtn, deleteInvoiceBtn, editInvoiceBtn, exportAllInvoiceBtn, exportInvoiceByMonthBtn, findInvoiceBtn, avgMoneyInvoiceBtn, sumKHInvoiceBtn;
    private AddInvoiceView addInvoiceView;
    private DeleteInvoiceView deleteInvoiceView;
    private EditInvoiceView editInvoiceView;
    private GetListInvoiceView getListInvoiceView;
    private FindInvoiceView findInvoiceView;
    private AvgMoneyInvoiceNuocNgoaiView avgMoneyInvoiceNuocNgoaiView;
    private SumKHInvoiceView sumKHInvoiceView;
    private ExportInvoiceByMonthView exportInvoiceByMonthView;

    public MainGUI() {
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

    public void setAddInvoiceView(AddInvoiceView addInvoiceView) {
        this.addInvoiceView = addInvoiceView;
    }

    public void setDeleteInvoiceView(DeleteInvoiceView deleteInvoiceView) {
        this.deleteInvoiceView = deleteInvoiceView;
    }

    public void setEditInvoiceView(EditInvoiceView editInvoiceView) {
        this.editInvoiceView = editInvoiceView;
    }

    public void setGetListInvoiceView(GetListInvoiceView getListInvoiceView) {
        this.getListInvoiceView = getListInvoiceView;
    }

    public void setExportInvoiceByMonthView(ExportInvoiceByMonthView exportInvoiceByMonthView) {
        this.exportInvoiceByMonthView = exportInvoiceByMonthView;
    }

    public void setFindInvoiceView(FindInvoiceView findInvoiceView) {
        this.findInvoiceView = findInvoiceView;
    }

    public void setAvgMoneyInvoiceNuocNgoaiView(AvgMoneyInvoiceNuocNgoaiView avgMoneyInvoiceNuocNgoaiView) {
        this.avgMoneyInvoiceNuocNgoaiView = avgMoneyInvoiceNuocNgoaiView;
    }

    public void setSumKHInvoiceView(SumKHInvoiceView sumKHInvoiceView) {
        this.sumKHInvoiceView = sumKHInvoiceView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        
        if (cmd.equals(addInvoiceBtn.getActionCommand())) {
            if (addInvoiceView != null) {
                addInvoiceView.mainShow();
            }
        }

        if (cmd.equals(deleteInvoiceBtn.getActionCommand())) {
            if (deleteInvoiceView != null) {
                deleteInvoiceView.mainShow();
            }
        }

        if (cmd.equals(editInvoiceBtn.getActionCommand())) {
            if (editInvoiceView != null) {
                editInvoiceView.mainShow();
            }
        }

        if (cmd.equals(exportAllInvoiceBtn.getActionCommand())) {
            if (getListInvoiceView != null) {
                getListInvoiceView.mainShow();
            }
        }

        if (cmd.equals(exportInvoiceByMonthBtn.getActionCommand())) {
            if (exportInvoiceByMonthView != null) {
                exportInvoiceByMonthView.mainShow();
            }
        }

        if (cmd.equals(findInvoiceBtn.getActionCommand())) {
            if (findInvoiceView != null) {
                findInvoiceView.mainShow();
            }
        }

        if (cmd.equals(avgMoneyInvoiceBtn.getActionCommand())) {
            if (avgMoneyInvoiceNuocNgoaiView != null) {
                avgMoneyInvoiceNuocNgoaiView.mainShow();
            }
        }

        if (cmd.equals(sumKHInvoiceBtn.getActionCommand())) {
            if (sumKHInvoiceView != null) {
                sumKHInvoiceView.mainShow();
            }
        }
    }
}
