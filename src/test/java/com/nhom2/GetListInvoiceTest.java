package com.nhom2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nhom2.businessRules.getListInvoice.GetListInvoiceDatabaseBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceInputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceOutputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceUseCase;
import com.nhom2.database.mysql.GetListInvoiceDAOMySQL;
import com.nhom2.detail.getListInvoice.GetListInvoicePresenter;
import com.nhom2.detail.getListInvoice.GetListInvoiceViewModel;

public class GetListInvoiceTest extends Nhom2Test
{
    private List<GetListInvoiceViewModel> getListInvoiceViewModel;
    private GetListInvoiceInputBoundary getListInvoiceInputBoundary;

    private void prepareUseCase() throws Exception {
        this.getListInvoiceViewModel = new ArrayList<>();
        GetListInvoiceOutputBoundary getListInvoiceOutputBoundary = new GetListInvoicePresenter(null, getListInvoiceViewModel);
        GetListInvoiceDatabaseBoundary getListInvoiceDatabaseBoundary = new GetListInvoiceDAOMySQL(ipAddress, port, db, username, password);
        this.getListInvoiceInputBoundary = new GetListInvoiceUseCase(getListInvoiceOutputBoundary, getListInvoiceDatabaseBoundary);
    }

    // SUCCESS
    @Test
    public void getListInvoiceSuccess() throws Exception
    {
        prepareUseCase();
        getListInvoiceInputBoundary.execute();
        assertEquals(getListInvoiceViewModel.size(), 7);
    }
}
