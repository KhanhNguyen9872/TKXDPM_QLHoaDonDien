package com.nhom2.database.mysql;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.editInvoice.EditInvoiceUIDatabaseBoundary;
import com.nhom2.businessRules.entity.Invoice;

public class EditInvoiceUIDAOMySQL extends DAOMySQL implements EditInvoiceUIDatabaseBoundary {
    public EditInvoiceUIDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    @Override
    public List<String> getAllTypes() {
        List<String> list = null;

        connect();
        
        String sql = "select * from doiTuongKH;";
        try {
            Statement statement = createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            list = new ArrayList<>();
            Invoice invoice;

            while(resultSet.next()) {
                list.add(resultSet.getString("doiTuong"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        close();
        return list;
    }
}