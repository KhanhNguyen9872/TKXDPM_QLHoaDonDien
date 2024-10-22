package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.deleteInvoice.RequestData;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceDatabaseBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUseCase;
import com.nhom2.database.mysql.DeleteInvoiceDAOMySQL;
import com.nhom2.detail.deleteInvoice.DeleteInvoicePresenter;

public class DeleteInvoiceTest 
{
    private final String ipAddress = "127.0.0.1";
    private final int port = 3306;
    private final String db = "invoice";
    private final String username = "root";
    private final String password = "12345678";

    private RequestData getRequestData() {
        RequestData requestData = new RequestData();

        requestData.setMaKH("1");
        
        return requestData;
    }

    @Test
    public void deleteInvoiceSuccess() throws Exception
    {
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(null);
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL(ipAddress, port, db, username, password);
        DeleteInvoiceInputBoundary deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);

        RequestData requestData = getRequestData();
        deleteInvoiceInputBoundary.execute(requestData);
        
        assertEquals(((DeleteInvoicePresenter)deleteInvoiceOutputBoundary).getDeleteInvoiceViewModel().msg, "Đã xóa thành công! (KH: " + requestData.getMaKH() + ")");
    }

    @Test
    public void deleteInvoiceError() throws Exception
    {
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(null);
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL(ipAddress, port, db, username, password);
        DeleteInvoiceInputBoundary deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);

        RequestData requestData = getRequestData();

        requestData.setMaKH("ID01");
        deleteInvoiceInputBoundary.execute(requestData);
        assertEquals(((DeleteInvoicePresenter)deleteInvoiceOutputBoundary).getDeleteInvoiceViewModel().msg, "Dữ liệu không hợp lệ!");

        requestData.setMaKH("0");
        deleteInvoiceInputBoundary.execute(requestData);
        assertEquals(((DeleteInvoicePresenter)deleteInvoiceOutputBoundary).getDeleteInvoiceViewModel().msg, "Không tồn tại! (KH: " + requestData.getMaKH() + ")");
    }
}
