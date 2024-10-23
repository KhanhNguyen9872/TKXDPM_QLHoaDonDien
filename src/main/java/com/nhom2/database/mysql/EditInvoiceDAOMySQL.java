package com.nhom2.database.mysql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.nhom2.businessRules.editInvoice.EditInvoiceDatabaseBoundary;
import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;

public class EditInvoiceDAOMySQL extends DAOMySQL implements EditInvoiceDatabaseBoundary {

    public EditInvoiceDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    @Override
    public Invoice getInvoice(int maKH) {
        connect();
        Invoice invoice = null;
        String sql = "SELECT * FROM invoice WHERE (maKH = ?);";

        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setInt(1, maKH);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String tenKH = resultSet.getString("tenKH");
                Date ngayHD = resultSet.getDate("ngayHD");
                int soLuong = resultSet.getInt("soLuong");
                int donGia = resultSet.getInt("donGia");
                String doiTuongKH = resultSet.getString("doiTuongKH");
                int dinhMuc = resultSet.getInt("dinhMuc");
                String quocTich = resultSet.getString("quocTich");
                

                if (quocTich == null || quocTich.isEmpty()) {
                    invoice = new InvoiceVN(maKH, tenKH, ngayHD, soLuong, donGia, doiTuongKH, dinhMuc);
                } else {
                    invoice = new InvoiceNuocNgoai(maKH, tenKH, ngayHD, soLuong, donGia, quocTich);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return invoice;
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        connect();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "UPDATE invoice SET tenKH = ?, ngayHD = ?, soLuong = ?, donGia = ?, doiTuongKH = ?, dinhMuc = ?, quocTich = ?  WHERE (maKH = ?);";
        
        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setString(1, invoice.getTenKH());
            
            preparedStatement.setString(2, dateFormat.format(invoice.getNgayHD()));
            preparedStatement.setInt(3, invoice.getSoLuong());
            preparedStatement.setInt(4, invoice.getDonGia());
            if (invoice.getClass().equals(InvoiceNuocNgoai.class)) {
                InvoiceNuocNgoai invoiceNuocNgoai = (InvoiceNuocNgoai)invoice;

                preparedStatement.setString(5, "");
                preparedStatement.setInt(6, 0);
                preparedStatement.setString(7, invoiceNuocNgoai.getQuocTich());
            } else {
                InvoiceVN invoiceVN = (InvoiceVN)invoice;

                preparedStatement.setString(5, invoiceVN.getDoiTuongKH());
                preparedStatement.setInt(6, invoiceVN.getDinhMuc());
                preparedStatement.setString(7, "");
            }

            preparedStatement.setInt(8, invoice.getMaKH());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
    }
}
