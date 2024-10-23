package com.nhom2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.nhom2.businessRules.getListInvoice.GetListInvoiceDatabaseBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceInputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceOutputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceUseCase;
import com.nhom2.database.mysql.GetListInvoiceDAOMySQL;
import com.nhom2.detail.getListInvoice.GetListInvoicePresenter;
import com.nhom2.detail.getListInvoice.GetListInvoiceViewModel;

public class GetListInvoiceTest 
{
    private final String ipAddress = "127.0.0.1";
    private final int port = 3306;
    private final String db = "invoice";
    private final String username = "root";
    private final String password = "12345678";


    @Test
    public void getListInvoiceSuccess() throws Exception
    {
        GetListInvoiceOutputBoundary getListInvoiceOutputBoundary = new GetListInvoicePresenter(null);
        GetListInvoiceDatabaseBoundary getListInvoiceDatabaseBoundary = new GetListInvoiceDAOMySQL(ipAddress, port, db, username, password);
        GetListInvoiceInputBoundary getListInvoiceInputBoundary = new GetListInvoiceUseCase(getListInvoiceOutputBoundary, getListInvoiceDatabaseBoundary);
        
        getListInvoiceInputBoundary.execute();

        List<GetListInvoiceViewModel> getListInvoiceViewModel = ((GetListInvoicePresenter)getListInvoiceOutputBoundary).getGetListInvoiceViewModel();
        assertEquals(getListInvoiceViewModel.size(), 1);
    }
}
