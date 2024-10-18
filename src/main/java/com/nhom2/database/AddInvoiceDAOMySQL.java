package com.nhom2.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.addInvoice.AddInvoiceDatabaseBoundary;
import com.nhom2.businessRules.model.*;

public class AddInvoiceDAOMySQL implements AddInvoiceDatabaseBoundary {
    private Connection connection = null;
    private String ipAddress;
    private int port;
    private String database;
    private String username;
    private String password;

    public AddInvoiceDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.ipAddress = ipAddress;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    @Override
    public void addInvoice(Invoice invoice) {
        connect();

        String sql = "INSERT INTO invoice (maKH, tenKH, ngayHD, soLuong, donGia, quocTich, doiTuongKH, dinhMuc) VALUES " +
            "(?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

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

    @Override
    public boolean isExist(int maKH) {
        boolean result = false;

        connect();

        String sql = "select maKH from invoice where (maKH = ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, maKH);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        close();

        return result;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();

        connect();
        
        String sql = "select * from invoice;";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Invoice invoice;

            while(resultSet.next()) {
                if (!resultSet.getString("quocTich").isEmpty()) {
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

    private void connect() {
        if (this.connection == null) {
            try {
                this.connection = DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" + port + "/" + database + "?useSSL=false", username, password);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };
    }
    
    private void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            this.connection = null;
        }
    }
}
