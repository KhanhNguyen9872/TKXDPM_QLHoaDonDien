package com.nhom2.database.mysql;

import java.sql.Date;
import java.sql.PreparedStatement;

import com.nhom2.businessRules.addInvoice.AddInvoiceDatabaseBoundary;
import com.nhom2.businessRules.entity.*;

public class AddInvoiceDAOMySQL extends DAOMySQL implements AddInvoiceDatabaseBoundary {
    
    public AddInvoiceDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    @Override
    public void addInvoice(Invoice invoice) {
        connect();

        String sql = "INSERT INTO invoice (tenKH, ngayHD, soLuong, donGia, quocTich, doiTuongKH, dinhMuc) VALUES " +
            "(?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);

            preparedStatement.setString(1, invoice.getTenKH());
            preparedStatement.setDate(2, new Date(invoice.getNgayHD().getTime()));
            preparedStatement.setInt(3, invoice.getSoLuong());
            preparedStatement.setInt(4, invoice.getDonGia());

            if (invoice.getClass().equals(InvoiceNuocNgoai.class)) {
                InvoiceNuocNgoai invoiceNuocNgoai = (InvoiceNuocNgoai)invoice;
                preparedStatement.setString(5, invoiceNuocNgoai.getQuocTich());
                preparedStatement.setString(6, "");
                preparedStatement.setString(7, "");

            } else if (invoice.getClass().equals(InvoiceVN.class)) {
                InvoiceVN invoiceVN = (InvoiceVN)invoice;
                preparedStatement.setString(5, "");
                preparedStatement.setString(6, invoiceVN.getDoiTuongKH());
                preparedStatement.setInt(7, invoiceVN.getDinhMuc());
            }

            preparedStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        close();
    }
}
