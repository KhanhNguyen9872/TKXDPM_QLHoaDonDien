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

        int yyyy = 0;
        int MM = 0;
        int dd = 0;
        String sql;

        if (column.equals("ngayHD")) {
            sql = "SELECT * FROM invoice WHERE (";
            
            try {
                yyyy = Integer.parseInt(value.split("-")[0]);
            } catch (Exception e) {
                // TODO: handle exception
            }

            try {
                MM = Integer.parseInt(value.split("-")[1]);
            } catch (Exception e) {
                // TODO: handle exception
            }

            try {
                dd = Integer.parseInt(value.split("-")[2]);
            } catch (Exception e) {
                // TODO: handle exception
            }

            if (yyyy != 0) {
                sql = sql + "(YEAR(ngayHD) = ?) AND";
            }

            if (MM != 0) {
                sql = sql + "(MONTH(ngayHD) = ?) AND";
            }

            if (dd != 0) {
                sql = sql + "(DAY(ngayHD) = ?) AND";
            }

            if (sql.substring(sql.length() - 3, sql.length()).equals("AND")) {
                sql = sql.substring(0, sql.length() - 3);
            }

            sql = sql + ");";

            System.out.println(sql);
        } else { 
            sql = "SELECT * FROM invoice WHERE (" + column + " like ?);";
        }
        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);

            if (column.equals("ngayHD")) {
                int count = 1;
                if (sql.contains("YEAR(ngayHD)")) {
                    preparedStatement.setInt(count, yyyy);
                    count = count + 1;
                }
                
                if (sql.contains("MONTH(ngayHD)")) {
                    preparedStatement.setInt(count, MM);
                    count = count + 1;
                }
                
                if (sql.contains("DAY(ngayHD)")) {
                    preparedStatement.setInt(count, dd);
                    count = count + 1;
                }
                
            } else {
                preparedStatement.setString(1, "%" + value + "%");
            }

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
