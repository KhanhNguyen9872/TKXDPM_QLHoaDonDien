package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.editInvoice.EditInvoiceDatabaseBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceOutputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUseCase;
import com.nhom2.businessRules.editInvoice.RequestData;
import com.nhom2.database.mysql.EditInvoiceDAOMySQL;
import com.nhom2.detail.editInvoice.EditInvoiceController;
import com.nhom2.detail.editInvoice.EditInvoicePresenter;
import com.nhom2.detail.editInvoice.EditInvoiceView;

public class EditInvoiceTest 
{
    private final String ipAddress = "127.0.0.1";
    private final int port = 3306;
    private final String db = "invoice";
    private final String username = "root";
    private final String password = "12345678";

    private RequestData getRequestData() {
        RequestData requestData = new RequestData();

        
        
        return requestData;
    }

    @Test
    public void editInvoiceSuccess() throws Exception
    {
        EditInvoiceOutputBoundary editInvoiceOutputBoundary = new EditInvoicePresenter(null);
        EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary  = new EditInvoiceDAOMySQL(ipAddress, port, db, username, password);
        EditInvoiceInputBoundary editInvoiceInputBoundary = new EditInvoiceUseCase(editInvoiceOutputBoundary, editInvoiceDatabaseBoundary);
        EditInvoiceController editInvoiceController = new EditInvoiceController(editInvoiceInputBoundary);

        RequestData requestData = getRequestData();


        
        assertEquals(((EditInvoicePresenter)editInvoiceOutputBoundary).getEditInvoiceViewModel().msg, "");
    }

    @Test
    public void editInvoiceError() throws Exception
    {
        EditInvoiceOutputBoundary editInvoiceOutputBoundary = new EditInvoicePresenter(null);
        EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary  = new EditInvoiceDAOMySQL(ipAddress, port, db, username, password);
        EditInvoiceInputBoundary editInvoiceInputBoundary = new EditInvoiceUseCase(editInvoiceOutputBoundary, editInvoiceDatabaseBoundary);

        RequestData requestData = getRequestData();
        editInvoiceInputBoundary.execute(requestData);
        
        assertEquals(((EditInvoicePresenter)editInvoiceOutputBoundary).getEditInvoiceViewModel().msg, "");
    }
}
