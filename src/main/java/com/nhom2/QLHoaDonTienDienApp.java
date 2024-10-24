package com.nhom2;

import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.addInvoice.AddInvoiceDatabaseBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceInputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceOutputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceUseCase;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceDatabaseBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUseCase;
import com.nhom2.businessRules.editInvoice.EditInvoiceDatabaseBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceOutputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUseCase;
import com.nhom2.businessRules.findInvoice.FindInvoiceDatabaseBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceInputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceOutputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceUseCase;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceDatabaseBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceInputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceOutputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceUseCase;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceDatabaseBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceInputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceOutputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceUseCase;
import com.nhom2.database.mysql.AddInvoiceDAOMySQL;
import com.nhom2.database.mysql.DeleteInvoiceDAOMySQL;
import com.nhom2.database.mysql.EditInvoiceDAOMySQL;
import com.nhom2.database.mysql.FindInvoiceDAOMySQL;
import com.nhom2.database.mysql.GetListInvoiceDAOMySQL;
import com.nhom2.database.mysql.SumKHInvoiceDAOMySQL;
import com.nhom2.detail.MainGUI;
import com.nhom2.detail.addInvoice.AddInvoiceController;
import com.nhom2.detail.addInvoice.AddInvoicePresenter;
import com.nhom2.detail.addInvoice.AddInvoiceView;
import com.nhom2.detail.addInvoice.AddInvoiceViewModel;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceController;
import com.nhom2.detail.deleteInvoice.DeleteInvoicePresenter;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceView;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceViewModel;
import com.nhom2.detail.editInvoice.EditInvoiceController;
import com.nhom2.detail.editInvoice.EditInvoicePresenter;
import com.nhom2.detail.editInvoice.EditInvoiceView;
import com.nhom2.detail.editInvoice.EditInvoiceViewModel;
import com.nhom2.detail.findInvoice.FindInvoiceController;
import com.nhom2.detail.findInvoice.FindInvoicePresenter;
import com.nhom2.detail.findInvoice.FindInvoiceView;
import com.nhom2.detail.findInvoice.FindInvoiceViewModel;
import com.nhom2.detail.getListInvoice.GetListInvoiceController;
import com.nhom2.detail.getListInvoice.GetListInvoicePresenter;
import com.nhom2.detail.getListInvoice.GetListInvoiceView;
import com.nhom2.detail.getListInvoice.GetListInvoiceViewModel;
import com.nhom2.detail.sumKHInvoice.SumKHInvoiceController;
import com.nhom2.detail.sumKHInvoice.SumKHInvoicePresenter;
import com.nhom2.detail.sumKHInvoice.SumKHInvoiceView;
import com.nhom2.detail.sumKHInvoice.SumKHInvoiceViewModel;

public class QLHoaDonTienDienApp 
{
    public static void main( String[] args ) throws Exception
    {
        Class.forName("org.jdesktop.swingx.JXDatePicker");

        // config db
        String ipAddress = "127.0.0.1";
        int port = 3306;
        String db = "invoice";
        String username = "root";
        String password = "12345678";

        // add Invoice
        AddInvoiceViewModel addInvoiceViewModel = new AddInvoiceViewModel();
        AddInvoiceView addInvoiceView = new AddInvoiceView();
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(addInvoiceView, addInvoiceViewModel);
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL(ipAddress, port, db, username, password);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);
        AddInvoiceController addInvoiceController = new AddInvoiceController(addInvoiceInputBoundary);
        addInvoiceView.setAddInvoiceController(addInvoiceController);

        // delete Invoice
        DeleteInvoiceViewModel DeleteInvoiceViewModel = new DeleteInvoiceViewModel();
        DeleteInvoiceView deleteInvoiceView = new DeleteInvoiceView();
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(deleteInvoiceView, DeleteInvoiceViewModel);
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL(ipAddress, port, db, username, password);
        DeleteInvoiceInputBoundary deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);
        DeleteInvoiceController deleteInvoiceController = new DeleteInvoiceController(deleteInvoiceInputBoundary);
        deleteInvoiceView.setDeleteInvoiceController(deleteInvoiceController);

        // edit Invoice
        EditInvoiceViewModel editInvoiceViewModel = new EditInvoiceViewModel();
        EditInvoiceView editInvoiceView = new EditInvoiceView();
        EditInvoiceOutputBoundary editInvoiceOutputBoundary = new EditInvoicePresenter(editInvoiceView, editInvoiceViewModel);
        EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary  = new EditInvoiceDAOMySQL(ipAddress, port, db, username, password);
        EditInvoiceInputBoundary editInvoiceInputBoundary = new EditInvoiceUseCase(editInvoiceOutputBoundary, editInvoiceDatabaseBoundary);
        EditInvoiceController editInvoiceController = new EditInvoiceController(editInvoiceInputBoundary);
        editInvoiceView.setEditInvoiceController(editInvoiceController);

        // get list Invoice
        List<GetListInvoiceViewModel> listGetListInvoiceViewModel = new ArrayList<>();
        GetListInvoiceView getListInvoiceView = new GetListInvoiceView();
        GetListInvoiceOutputBoundary getListInvoiceOutputBoundary = new GetListInvoicePresenter(getListInvoiceView, listGetListInvoiceViewModel);
        GetListInvoiceDatabaseBoundary getListInvoiceDatabaseBoundary = new GetListInvoiceDAOMySQL(ipAddress, port, db, username, password);
        GetListInvoiceInputBoundary getListInvoiceInputBoundary = new GetListInvoiceUseCase(getListInvoiceOutputBoundary, getListInvoiceDatabaseBoundary);
        GetListInvoiceController getListInvoiceController = new GetListInvoiceController(getListInvoiceInputBoundary);
        getListInvoiceView.setGetListInvoiceController(getListInvoiceController);

        // find Invoice
        List<FindInvoiceViewModel> listFindInvoiceViewModel = new ArrayList<>();
        FindInvoiceView findInvoiceView = new FindInvoiceView();
        FindInvoiceOutputBoundary findInvoiceOutputBoundary = new FindInvoicePresenter(findInvoiceView, listFindInvoiceViewModel);
        FindInvoiceDatabaseBoundary findInvoiceDatabaseBoundary = new FindInvoiceDAOMySQL(ipAddress, port, db, username, password);
        FindInvoiceInputBoundary findInvoiceInputBoundary = new FindInvoiceUseCase(findInvoiceOutputBoundary, findInvoiceDatabaseBoundary);
        FindInvoiceController findInvoiceController = new FindInvoiceController(findInvoiceInputBoundary);
        findInvoiceView.setFindInvoiceController(findInvoiceController);

        // sum KH Invoice 
        SumKHInvoiceViewModel sumKHInvoiceViewModel = new SumKHInvoiceViewModel();
        SumKHInvoiceView sumKHInvoiceView = new SumKHInvoiceView();
        SumKHInvoiceOutputBoundary sumKHInvoiceOutputBoundary = new SumKHInvoicePresenter(sumKHInvoiceView, sumKHInvoiceViewModel);
        SumKHInvoiceDatabaseBoundary sumKHInvoiceDatabaseBoundary = new SumKHInvoiceDAOMySQL(ipAddress, port, db, username, password);
        SumKHInvoiceInputBoundary sumKHInvoiceInputBoundary = new SumKHInvoiceUseCase(sumKHInvoiceOutputBoundary, sumKHInvoiceDatabaseBoundary);
        SumKHInvoiceController sumKHInvoiceController = new SumKHInvoiceController(sumKHInvoiceInputBoundary);
        sumKHInvoiceView.setSumKHInvoiceController(sumKHInvoiceController);

        // MainGUI
        MainGUI mainGUI = new MainGUI();
        mainGUI.setAddInvoiceView(addInvoiceView);
        mainGUI.setDeleteInvoiceView(deleteInvoiceView);
        mainGUI.setEditInvoiceView(editInvoiceView);
        mainGUI.setGetListInvoiceView(getListInvoiceView);
        mainGUI.setFindInvoiceView(findInvoiceView);
        mainGUI.setSumKHInvoiceView(sumKHInvoiceView);

        // setVisible(true)
        mainGUI.showGUI();
    }
}
