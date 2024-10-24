package com.nhom2.database.mysql;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiDatabaseBoundary;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;

public class AvgMoneyInvoiceNuocNgoaiDAOMySQL extends DAOMySQL implements AvgMoneyInvoiceNuocNgoaiDatabaseBoundary {
    public AvgMoneyInvoiceNuocNgoaiDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    @Override
    public List<InvoiceNuocNgoai> getNuocNgoaiInvoices() {
        List<InvoiceNuocNgoai> listInvoice = null;

        connect();

        String sql = "SELECT * FROM invoice WHERE (quocTich != '' AND quocTich IS NOT NULL);";
        try {
            Statement statement = createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            InvoiceNuocNgoai invoice = null;
            listInvoice = new ArrayList<>();
            
            while(resultSet.next()) {
                invoice = new InvoiceNuocNgoai(
                    resultSet.getInt("maKH"),
                    resultSet.getString("tenKH"),
                    resultSet.getDate("ngayHD"),
                    resultSet.getInt("soLuong"), 
                    resultSet.getInt("donGia"),
                    resultSet.getString("quocTich")
                );
                listInvoice.add(invoice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        close();

        return listInvoice;
    }
}
