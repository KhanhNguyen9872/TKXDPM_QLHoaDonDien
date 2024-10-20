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

        String sql = "INSERT INTO invoice (maKH, tenKH, ngayHD, soLuong, donGia, quocTich, doiTuongKH, dinhMuc) VALUES " +
            "(?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);

            preparedStatement.setInt(1, invoice.getMaKH());
            preparedStatement.setString(2, invoice.getTenKH());
            preparedStatement.setDate(3, new Date(invoice.getNgayHD().getTime()));
            preparedStatement.setInt(4, invoice.getSoLuong());
            preparedStatement.setInt(5, invoice.getDonGia());

            if (invoice.getClass().equals(InvoiceNuocNgoai.class)) {
                InvoiceNuocNgoai invoiceNuocNgoai = (InvoiceNuocNgoai)invoice;
                preparedStatement.setString(6, invoiceNuocNgoai.getQuocTich());
                preparedStatement.setString(7, "");
                preparedStatement.setString(8, "");

            } else if (invoice.getClass().equals(InvoiceVN.class)) {
                InvoiceVN invoiceVN = (InvoiceVN)invoice;
                preparedStatement.setString(6, "");
                preparedStatement.setString(7, invoiceVN.getDoiTuongKH());
                preparedStatement.setInt(8, invoiceVN.getDinhMuc());
            }

            preparedStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        close();
    }
}
