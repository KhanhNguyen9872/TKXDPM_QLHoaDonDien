package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.RequestData;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceDatabaseBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUseCase;
import com.nhom2.database.mysql.DeleteInvoiceDAOMySQL;
import com.nhom2.detail.deleteInvoice.DeleteInvoicePresenter;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceView;

public class DeleteInvoiceTest 
{
    private RequestData getRequestData() {
        RequestData requestData = new RequestData();

        requestData.setMaKH("1");
        
        return requestData;
    }

    @Test
    public void deleteInvoiceSuccess() throws Exception
    {
        DeleteInvoiceView deleteInvoiceView = new DeleteInvoiceView();
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(deleteInvoiceView);
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL("127.0.0.1", 3306, "invoice", "root", "12345678");
        DeleteInvoiceInputBoundary deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);

        RequestData requestData = getRequestData();
        deleteInvoiceInputBoundary.execute(requestData);
        
        assertEquals(((DeleteInvoicePresenter)deleteInvoiceOutputBoundary).getDeleteInvoiceViewModel().msg, "Đã xóa thành công! (KH: " + requestData.getMaKH() + ")");
    }

    @Test
    public void deleteInvoiceError() throws Exception
    {
        DeleteInvoiceView deleteInvoiceView = new DeleteInvoiceView();
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(deleteInvoiceView);
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL("127.0.0.1", 3306, "invoice", "root", "12345678");
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
