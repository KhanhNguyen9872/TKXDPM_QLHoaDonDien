package com.nhom2;

import com.nhom2.businessRules.RequestData;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceDatabaseBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceInputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceOutputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceUseCase;
import com.nhom2.database.mysql.GetListInvoiceDAOMySQL;
import com.nhom2.detail.getListInvoice.GetListInvoicePresenter;
import com.nhom2.detail.getListInvoice.GetListInvoiceView;

public class QLHoaDonTienDienApp 
{
    public static void main( String[] args ) throws Exception
    {
        GetListInvoiceView getListInvoiceView = new GetListInvoiceView();
        GetListInvoiceOutputBoundary getListInvoiceOutputBoundary = new GetListInvoicePresenter(getListInvoiceView);
        GetListInvoiceDatabaseBoundary getListInvoiceDatabaseBoundary = new GetListInvoiceDAOMySQL("127.0.0.1", 3306, "invoice", "root", "12345678");
        GetListInvoiceInputBoundary getListInvoiceInputBoundary = new GetListInvoiceUseCase(getListInvoiceOutputBoundary, getListInvoiceDatabaseBoundary);
        
        getListInvoiceInputBoundary.execute(new RequestData());
    }
}
