package com.nhom2.database.mysql;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceDatabaseBoundary;

public class GetListInvoiceDAOMySQL extends DAOMySQL implements GetListInvoiceDatabaseBoundary {

    public GetListInvoiceDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = null;

        connect();
        
        String sql = "select * from invoice;";
        try {
            Statement statement = createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            invoices = new ArrayList<>();
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
                
                invoices.add(invoice);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        close();
        return invoices;
    }
}
