package com.nhom2;

import com.nhom2.businessRules.addInvoice.AddInvoiceDatabaseBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceInputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceOutputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceUseCase;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceDatabaseBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUseCase;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceDatabaseBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceInputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceOutputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceUseCase;
import com.nhom2.database.mysql.AddInvoiceDAOMySQL;
import com.nhom2.database.mysql.DeleteInvoiceDAOMySQL;
import com.nhom2.database.mysql.GetListInvoiceDAOMySQL;
import com.nhom2.detail.MainGUI;
import com.nhom2.detail.addInvoice.AddInvoiceController;
import com.nhom2.detail.addInvoice.AddInvoicePresenter;
import com.nhom2.detail.addInvoice.AddInvoiceView;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceController;
import com.nhom2.detail.deleteInvoice.DeleteInvoicePresenter;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceView;
import com.nhom2.detail.getListInvoice.GetListInvoiceController;
import com.nhom2.detail.getListInvoice.GetListInvoicePresenter;
import com.nhom2.detail.getListInvoice.GetListInvoiceView;

public class QLHoaDonTienDienApp 
{
    public static void main( String[] args ) throws Exception
    {
        // config db
        String ipAddress = "127.0.0.1";
        int port = 3306;
        String db = "invoice";
        String username = "root";
        String password = "12345678";

        // add Invoice
        AddInvoiceView addInvoiceView = new AddInvoiceView();
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(addInvoiceView);
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL(ipAddress, port, db, username, password);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);
        AddInvoiceController addInvoiceController = new AddInvoiceController(addInvoiceInputBoundary);
        addInvoiceView.setAddInvoiceController(addInvoiceController);

        // delete Invoice
        DeleteInvoiceView deleteInvoiceView = new DeleteInvoiceView();
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(deleteInvoiceView);
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL(ipAddress, port, db, username, password);
        DeleteInvoiceInputBoundary deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);
        DeleteInvoiceController deleteInvoiceController = new DeleteInvoiceController(deleteInvoiceInputBoundary);
        deleteInvoiceView.setDeleteInvoiceController(deleteInvoiceController);

        // get list Invoice
        GetListInvoiceView getListInvoiceView = new GetListInvoiceView();
        GetListInvoiceOutputBoundary getListInvoiceOutputBoundary = new GetListInvoicePresenter(getListInvoiceView);
        GetListInvoiceDatabaseBoundary getListInvoiceDatabaseBoundary = new GetListInvoiceDAOMySQL(ipAddress, port, db, username, password);
        GetListInvoiceInputBoundary getListInvoiceInputBoundary = new GetListInvoiceUseCase(getListInvoiceOutputBoundary, getListInvoiceDatabaseBoundary);
        GetListInvoiceController getListInvoiceController = new GetListInvoiceController(getListInvoiceInputBoundary);
        getListInvoiceView.setGetListInvoiceController(getListInvoiceController);

        // MainGUI
        MainGUI mainGUI = new MainGUI();
        mainGUI.setAddInvoiceView(addInvoiceView);
        mainGUI.setDeleteInvoiceView(deleteInvoiceView);
        mainGUI.setGetListInvoiceView(getListInvoiceView);

        // setVisible(true)
        mainGUI.showGUI();
    }
}
