package com.nhom2.database.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthDatabaseBoundary;

public class ExportInvoiceByMonthDAOMySQL extends DAOMySQL implements ExportInvoiceByMonthDatabaseBoundary {
    public ExportInvoiceByMonthDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    @Override
    public List<Invoice> getInvoiceByMonth(int month) {
        List<Invoice> listInvoices = null;
        connect();

        String sql = "SELECT * FROM invoice WHERE (MONTH(ngayHD) = ?);";
        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setInt(1, month);
            ResultSet resultSet = preparedStatement.executeQuery();
            Invoice invoice = null;
            listInvoices = new ArrayList<>();

            while (resultSet.next()) {
                if (resultSet.getString("quocTich").isEmpty()) {
                    invoice = new InvoiceVN(
                        resultSet.getInt("maKH"),
                        resultSet.getString("tenKH"),
                        resultSet.getDate("ngayHD"),
                        resultSet.getInt("soLuong"), 
                        resultSet.getInt("donGia"),
                        resultSet.getString("doiTuongKH"),
                        resultSet.getInt("dinhMuc")
                    );

                } else {
                    invoice = new InvoiceNuocNgoai(
                        resultSet.getInt("maKH"),
                        resultSet.getString("tenKH"),
                        resultSet.getDate("ngayHD"),
                        resultSet.getInt("soLuong"), 
                        resultSet.getInt("donGia"),
                        resultSet.getString("quocTich")
                    );

                }

                listInvoices.add(invoice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        close();    
        return listInvoices;
    }

}
