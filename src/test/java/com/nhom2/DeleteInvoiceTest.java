package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.RequestData;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceDatabaseBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUseCase;
import com.nhom2.database.mysql.DeleteInvoiceDAOMySQL;
import com.nhom2.detail.deleteInvoice.ModelView;
import com.nhom2.detail.deleteInvoice.DeleteInvoicePresenter;

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
        ModelView modelView = new ModelView();
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL("127.0.0.1", 3306, "invoice", "root", "12345678");
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(modelView);
        DeleteInvoiceInputBoundary deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);

        deleteInvoiceInputBoundary.execute(getRequestData());
        
        assertEquals(modelView.getMsg(), "Đã xóa thành công!");
    }

    @Test
    public void deleteInvoiceError() throws Exception
    {
        ModelView modelView = new ModelView();
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL("127.0.0.1", 3306, "invoice", "root", "12345678");
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(modelView);
        DeleteInvoiceInputBoundary deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);

        RequestData requestData = getRequestData();

        requestData.setMaKH("ID01");
        deleteInvoiceInputBoundary.execute(requestData);
        assertEquals(modelView.getMsg(), "Dữ liệu không hợp lệ!");

        requestData.setMaKH("0");
        deleteInvoiceInputBoundary.execute(requestData);
        assertEquals(modelView.getMsg(), "Không tồn tại!");
    }
}
