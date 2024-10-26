package com.nhom2.database.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;
import com.nhom2.businessRules.findInvoice.FindInvoiceDatabaseBoundary;

public class FindInvoiceDAOMySQL extends DAOMySQL implements FindInvoiceDatabaseBoundary {
    public FindInvoiceDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    private List<Invoice> findInvoice(String column, String value) {
        List<Invoice> listInvoices = null;
        connect();
        
        String sql = "SELECT * FROM invoice WHERE (" + column + " like ?);";
        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setString(1, "%" + value + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            listInvoices = new ArrayList<>();
            Invoice invoice;

            while(resultSet.next()) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        close();
        return listInvoices;
    }

    @Override
    public List<Invoice> findInvoiceTenKH(String tenKH) {
        return this.findInvoice("tenKH", tenKH);
    }

    @Override
    public List<Invoice> findInvoiceMaKH(String maKH) {
        return this.findInvoice("maKH", maKH);
    }

    @Override
    public List<Invoice> findInvoiceNgayHD(String ngayHD) {
        return this.findInvoice("ngayHD", ngayHD);
    }
}
