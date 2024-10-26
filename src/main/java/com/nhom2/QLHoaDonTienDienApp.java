package com.nhom2;

import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.addInvoice.AddInvoiceDatabaseBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceInputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceOutputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceUseCase;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiDatabaseBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiInputBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiOutputBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiUseCase;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceDatabaseBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUseCase;
import com.nhom2.businessRules.editInvoice.EditInvoiceDatabaseBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceOutputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUseCase;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthDatabaseBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthInputBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthOutputBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthUseCase;
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
import com.nhom2.database.mysql.AvgMoneyInvoiceNuocNgoaiDAOMySQL;
import com.nhom2.database.mysql.DeleteInvoiceDAOMySQL;
import com.nhom2.database.mysql.EditInvoiceDAOMySQL;
import com.nhom2.database.mysql.ExportInvoiceByMonthDAOMySQL;
import com.nhom2.database.mysql.FindInvoiceDAOMySQL;
import com.nhom2.database.mysql.GetListInvoiceDAOMySQL;
import com.nhom2.database.mysql.SumKHInvoiceDAOMySQL;
import com.nhom2.detail.MainGUI;
import com.nhom2.detail.addInvoice.AddInvoiceController;
import com.nhom2.detail.addInvoice.AddInvoicePresenter;
import com.nhom2.detail.addInvoice.AddInvoiceView;
import com.nhom2.detail.addInvoice.AddInvoiceViewModel;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiController;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiPresenter;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiView;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiViewModel;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceController;
import com.nhom2.detail.deleteInvoice.DeleteInvoicePresenter;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceView;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceViewModel;
import com.nhom2.detail.editInvoice.EditInvoiceController;
import com.nhom2.detail.editInvoice.EditInvoicePresenter;
import com.nhom2.detail.editInvoice.EditInvoiceView;
import com.nhom2.detail.editInvoice.EditInvoiceViewModel;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthController;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthPresenter;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthView;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthViewModel;
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
        final String ipAddress = "127.0.0.1";
        final int port = 3306;
        final String db = "invoice";
        final String username = "root";
        final String password = "12345678";

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

        // find Invoice
        List<FindInvoiceViewModel> listFindInvoiceViewModel = new ArrayList<>();
        FindInvoiceView findInvoiceView = new FindInvoiceView();
        FindInvoiceOutputBoundary findInvoiceOutputBoundary = new FindInvoicePresenter(findInvoiceView, listFindInvoiceViewModel);
        FindInvoiceDatabaseBoundary findInvoiceDatabaseBoundary = new FindInvoiceDAOMySQL(ipAddress, port, db, username, password);
        FindInvoiceInputBoundary findInvoiceInputBoundary = new FindInvoiceUseCase(findInvoiceOutputBoundary, findInvoiceDatabaseBoundary);
        FindInvoiceController findInvoiceController = new FindInvoiceController(findInvoiceInputBoundary);
        findInvoiceView.setFindInvoiceController(findInvoiceController);

        // edit Invoice
        EditInvoiceViewModel editInvoiceViewModel = new EditInvoiceViewModel();
        EditInvoiceView editInvoiceView = new EditInvoiceView();
        EditInvoiceOutputBoundary editInvoiceOutputBoundary = new EditInvoicePresenter(editInvoiceView, editInvoiceViewModel);
        EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary  = new EditInvoiceDAOMySQL(ipAddress, port, db, username, password);
        EditInvoiceInputBoundary editInvoiceInputBoundary = new EditInvoiceUseCase(editInvoiceOutputBoundary, editInvoiceDatabaseBoundary);
        EditInvoiceController editInvoiceController = new EditInvoiceController(editInvoiceInputBoundary);
        editInvoiceView.setEditInvoiceController(editInvoiceController);

        // tận dụng lại findInvoice
        List<FindInvoiceViewModel> listFindInvoiceViewModel2 = new ArrayList<>();
        FindInvoiceOutputBoundary findInvoiceOutputBoundary2 = new FindInvoicePresenter(null, listFindInvoiceViewModel2);
        FindInvoiceDatabaseBoundary findInvoiceDatabaseBoundary2 = new FindInvoiceDAOMySQL(ipAddress, port, db, username, password);
        FindInvoiceInputBoundary findInvoiceInputBoundary2 = new FindInvoiceUseCase(findInvoiceOutputBoundary2, findInvoiceDatabaseBoundary2);

        editInvoiceView.setFindInvoice(findInvoiceInputBoundary2, listFindInvoiceViewModel2);

        // get list Invoice
        List<GetListInvoiceViewModel> listGetListInvoiceViewModel = new ArrayList<>();
        GetListInvoiceView getListInvoiceView = new GetListInvoiceView();
        GetListInvoiceOutputBoundary getListInvoiceOutputBoundary = new GetListInvoicePresenter(getListInvoiceView, listGetListInvoiceViewModel);
        GetListInvoiceDatabaseBoundary getListInvoiceDatabaseBoundary = new GetListInvoiceDAOMySQL(ipAddress, port, db, username, password);
        GetListInvoiceInputBoundary getListInvoiceInputBoundary = new GetListInvoiceUseCase(getListInvoiceOutputBoundary, getListInvoiceDatabaseBoundary);
        GetListInvoiceController getListInvoiceController = new GetListInvoiceController(getListInvoiceInputBoundary);
        getListInvoiceView.setGetListInvoiceController(getListInvoiceController);

        // sum KH Invoice 
        SumKHInvoiceViewModel sumKHInvoiceViewModel = new SumKHInvoiceViewModel();
        SumKHInvoiceView sumKHInvoiceView = new SumKHInvoiceView();
        SumKHInvoiceOutputBoundary sumKHInvoiceOutputBoundary = new SumKHInvoicePresenter(sumKHInvoiceView, sumKHInvoiceViewModel);
        SumKHInvoiceDatabaseBoundary sumKHInvoiceDatabaseBoundary = new SumKHInvoiceDAOMySQL(ipAddress, port, db, username, password);
        SumKHInvoiceInputBoundary sumKHInvoiceInputBoundary = new SumKHInvoiceUseCase(sumKHInvoiceOutputBoundary, sumKHInvoiceDatabaseBoundary);
        SumKHInvoiceController sumKHInvoiceController = new SumKHInvoiceController(sumKHInvoiceInputBoundary);
        sumKHInvoiceView.setSumKHInvoiceController(sumKHInvoiceController);

        // avg Money Invoice Nuoc Ngoai
        AvgMoneyInvoiceNuocNgoaiViewModel avgMoneyInvoiceNuocNgoaiViewModel = new AvgMoneyInvoiceNuocNgoaiViewModel();
        AvgMoneyInvoiceNuocNgoaiView avgMoneyInvoiceNuocNgoaiView = new AvgMoneyInvoiceNuocNgoaiView();
        AvgMoneyInvoiceNuocNgoaiOutputBoundary avgMoneyInvoiceNuocNgoaiOutputBoundary = new AvgMoneyInvoiceNuocNgoaiPresenter(avgMoneyInvoiceNuocNgoaiView, avgMoneyInvoiceNuocNgoaiViewModel);
        AvgMoneyInvoiceNuocNgoaiDatabaseBoundary avgMoneyInvoiceNuocNgoaiDatabaseBoundary = new AvgMoneyInvoiceNuocNgoaiDAOMySQL(ipAddress, port, db, username, password);
        AvgMoneyInvoiceNuocNgoaiInputBoundary avgMoneyInvoiceNuocNgoaiInputBoundary = new AvgMoneyInvoiceNuocNgoaiUseCase(avgMoneyInvoiceNuocNgoaiDatabaseBoundary, avgMoneyInvoiceNuocNgoaiOutputBoundary);
        AvgMoneyInvoiceNuocNgoaiController avgMoneyInvoiceNuocNgoaiController = new AvgMoneyInvoiceNuocNgoaiController(avgMoneyInvoiceNuocNgoaiInputBoundary);
        avgMoneyInvoiceNuocNgoaiView.setAvgMoneyInvoiceNuocNgoaiController(avgMoneyInvoiceNuocNgoaiController);

        // export Invoice by Month
        List<ExportInvoiceByMonthViewModel> exportInvoiceByMonthViewModel = new ArrayList<>();
        ExportInvoiceByMonthView exportInvoiceByMonthView = new ExportInvoiceByMonthView();
        ExportInvoiceByMonthOutputBoundary exportInvoiceByMonthOutputBoundary = new ExportInvoiceByMonthPresenter(exportInvoiceByMonthView, exportInvoiceByMonthViewModel);
        ExportInvoiceByMonthDatabaseBoundary exportInvoiceByMonthDatabaseBoundary = new ExportInvoiceByMonthDAOMySQL(ipAddress, port, db, username, password);
        ExportInvoiceByMonthInputBoundary exportInvoiceByMonthInputBoundary = new ExportInvoiceByMonthUseCase(exportInvoiceByMonthDatabaseBoundary, exportInvoiceByMonthOutputBoundary);
        ExportInvoiceByMonthController exportInvoiceByMonthController = new ExportInvoiceByMonthController(exportInvoiceByMonthInputBoundary);
        exportInvoiceByMonthView.setExportInvoiceByMonthController(exportInvoiceByMonthController);

        // MainGUI
        MainGUI mainGUI = new MainGUI();
        mainGUI.setAddInvoiceView(addInvoiceView);
        mainGUI.setDeleteInvoiceView(deleteInvoiceView);
        mainGUI.setEditInvoiceView(editInvoiceView);
        mainGUI.setGetListInvoiceView(getListInvoiceView);
        mainGUI.setExportInvoiceByMonthView(exportInvoiceByMonthView);
        mainGUI.setFindInvoiceView(findInvoiceView);
        mainGUI.setSumKHInvoiceView(sumKHInvoiceView);
        mainGUI.setAvgMoneyInvoiceNuocNgoaiView(avgMoneyInvoiceNuocNgoaiView);

        // setVisible(true)
        mainGUI.showGUI();
    }
}
