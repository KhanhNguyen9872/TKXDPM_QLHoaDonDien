package com.nhom2;

import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.addInvoice.AddInvoiceDatabaseBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceInputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceOutputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceUIDatabaseBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceUseCase;
import com.nhom2.businessRules.addInvoice.AddInvoiceUIInputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceUIUseCase;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiDatabaseBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiInputBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiOutputBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiUIInputBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiUIUseCase;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiUseCase;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceDatabaseBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUIInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUIUseCase;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUseCase;
import com.nhom2.businessRules.editInvoice.EditInvoiceDatabaseBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceOutputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUIDatabaseBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUIInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUIUseCase;
import com.nhom2.businessRules.editInvoice.EditInvoiceUseCase;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthDatabaseBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthInputBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthOutputBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthUIInputBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthUIUseCase;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthUseCase;
import com.nhom2.businessRules.findInvoice.FindInvoiceDatabaseBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceInputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceOutputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceUIInputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceUIUseCase;
import com.nhom2.businessRules.findInvoice.FindInvoiceUseCase;
import com.nhom2.businessRules.forgot.ForgotDatabaseBoundary;
import com.nhom2.businessRules.forgot.ForgotInputBoundary;
import com.nhom2.businessRules.forgot.ForgotOutputBoundary;
import com.nhom2.businessRules.forgot.ForgotUIInputBoundary;
import com.nhom2.businessRules.forgot.ForgotUIOutputBoundary;
import com.nhom2.businessRules.forgot.ForgotUIUseCase;
import com.nhom2.businessRules.forgot.ForgotUseCase;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceDatabaseBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceInputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceOutputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceUIInputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceUIUseCase;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceUseCase;
import com.nhom2.businessRules.login.LoginDatabaseBoundary;
import com.nhom2.businessRules.login.LoginInputBoundary;
import com.nhom2.businessRules.login.LoginOutputBoundary;
import com.nhom2.businessRules.login.LoginUIInputBoundary;
import com.nhom2.businessRules.login.LoginUIOutputBoundary;
import com.nhom2.businessRules.login.LoginUIUseCase;
import com.nhom2.businessRules.login.LoginUseCase;
import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienInputBoundary;
import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienOutputBoundary;
import com.nhom2.businessRules.quanLyHDTienDien.QuanLyHDTienDienUseCase;
import com.nhom2.businessRules.register.RegisterDatabaseBoundary;
import com.nhom2.businessRules.register.RegisterInputBoundary;
import com.nhom2.businessRules.register.RegisterOutputBoundary;
import com.nhom2.businessRules.register.RegisterUIInputBoundary;
import com.nhom2.businessRules.register.RegisterUIOutputBoundary;
import com.nhom2.businessRules.register.RegisterUIUseCase;
import com.nhom2.businessRules.register.RegisterUseCase;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceDatabaseBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceInputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceOutputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceUIInputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceUIUseCase;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceUseCase;
import com.nhom2.database.mysql.AddInvoiceDAOMySQL;
import com.nhom2.database.mysql.AddInvoiceUIDAOMySQL;
import com.nhom2.database.mysql.AvgMoneyInvoiceNuocNgoaiDAOMySQL;
import com.nhom2.database.mysql.DeleteInvoiceDAOMySQL;
import com.nhom2.database.mysql.EditInvoiceDAOMySQL;
import com.nhom2.database.mysql.EditInvoiceUIDAOMySQL;
import com.nhom2.database.mysql.ExportInvoiceByMonthDAOMySQL;
import com.nhom2.database.mysql.FindInvoiceDAOMySQL;
import com.nhom2.database.mysql.ForgotDAOMySQL;
import com.nhom2.database.mysql.GetListInvoiceDAOMySQL;
import com.nhom2.database.mysql.LoginDAOMySQL;
import com.nhom2.database.mysql.RegisterDAOMySQL;
import com.nhom2.database.mysql.SumKHInvoiceDAOMySQL;
import com.nhom2.detail.addInvoice.AddInvoiceController;
import com.nhom2.detail.addInvoice.AddInvoicePresenter;
import com.nhom2.detail.addInvoice.AddInvoiceUIPresenter;
import com.nhom2.detail.addInvoice.AddInvoiceUIViewModel;
import com.nhom2.detail.addInvoice.AddInvoiceView;
import com.nhom2.detail.addInvoice.AddInvoiceViewModel;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiController;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiPresenter;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiUIPresenter;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiView;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiViewModel;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceController;
import com.nhom2.detail.deleteInvoice.DeleteInvoicePresenter;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceUIPresenter;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceUIView;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceUIViewModel;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceView;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceViewModel;
import com.nhom2.detail.editInvoice.EditInvoiceController;
import com.nhom2.detail.editInvoice.EditInvoicePresenter;
import com.nhom2.detail.editInvoice.EditInvoiceUIPresenter;
import com.nhom2.detail.editInvoice.EditInvoiceUIViewModel;
import com.nhom2.detail.editInvoice.EditInvoiceView;
import com.nhom2.detail.editInvoice.EditInvoiceViewModel;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthController;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthPresenter;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthUIPresenter;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthView;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthViewModel;
import com.nhom2.detail.findInvoice.FindInvoiceController;
import com.nhom2.detail.findInvoice.FindInvoicePresenter;
import com.nhom2.detail.findInvoice.FindInvoiceView;
import com.nhom2.detail.findInvoice.FindInvoiceViewModel;
import com.nhom2.detail.forgot.ForgotController;
import com.nhom2.detail.forgot.ForgotPresenter;
import com.nhom2.detail.forgot.ForgotUIController;
import com.nhom2.detail.forgot.ForgotUIPresenter;
import com.nhom2.detail.forgot.ForgotUIView;
import com.nhom2.detail.forgot.ForgotUIViewModel;
import com.nhom2.detail.forgot.ForgotViewModel;
import com.nhom2.detail.getListInvoice.GetListInvoiceController;
import com.nhom2.detail.getListInvoice.GetListInvoicePresenter;
import com.nhom2.detail.getListInvoice.GetListInvoiceView;
import com.nhom2.detail.getListInvoice.GetListInvoiceViewModel;
import com.nhom2.detail.login.LoginController;
import com.nhom2.detail.login.LoginPresenter;
import com.nhom2.detail.login.LoginUIController;
import com.nhom2.detail.login.LoginUIPresenter;
import com.nhom2.detail.login.LoginUIView;
import com.nhom2.detail.login.LoginUIViewModel;
import com.nhom2.detail.login.LoginViewModel;
import com.nhom2.detail.quanLyHDTienDien.QuanLyHDTienDienController;
import com.nhom2.detail.quanLyHDTienDien.QuanLyHDTienDienPresenter;
import com.nhom2.detail.quanLyHDTienDien.QuanLyHDTienDienView;
import com.nhom2.detail.quanLyHDTienDien.QuanLyHDTienDienViewModel;
import com.nhom2.detail.register.RegisterController;
import com.nhom2.detail.register.RegisterPresenter;
import com.nhom2.detail.register.RegisterUIController;
import com.nhom2.detail.register.RegisterUIPresenter;
import com.nhom2.detail.register.RegisterUIView;
import com.nhom2.detail.register.RegisterUIViewModel;
import com.nhom2.detail.register.RegisterViewModel;
import com.nhom2.detail.sumKHInvoice.SumKHInvoiceController;
import com.nhom2.detail.sumKHInvoice.SumKHInvoicePresenter;
import com.nhom2.detail.sumKHInvoice.SumKHInvoiceUIPresenter;
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
        final String password = "khanhnguyen";

        // add Invoice
        AddInvoiceViewModel addInvoiceViewModel = new AddInvoiceViewModel();
        AddInvoiceView addInvoiceView = new AddInvoiceView();
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(addInvoiceView, addInvoiceViewModel);
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL(ipAddress, port, db, username, password);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);
        AddInvoiceController addInvoiceController = new AddInvoiceController(addInvoiceInputBoundary);
        addInvoiceView.setAddInvoiceController(addInvoiceController);

        // UC show Add Invoice UI
        AddInvoiceUIViewModel addInvoiceUIViewModel = new AddInvoiceUIViewModel();
        AddInvoiceUIPresenter addInvoiceUIPresenter = new AddInvoiceUIPresenter(addInvoiceView, addInvoiceUIViewModel);
        AddInvoiceUIDatabaseBoundary addInvoiceUIDatabaseBoundary = new AddInvoiceUIDAOMySQL(ipAddress, port, db, username, password);
        AddInvoiceUIInputBoundary addInvoiceUIInputBoundary = new AddInvoiceUIUseCase(addInvoiceUIPresenter, addInvoiceUIDatabaseBoundary);

        // delete Invoice
        DeleteInvoiceViewModel DeleteInvoiceViewModel = new DeleteInvoiceViewModel();
        DeleteInvoiceView deleteInvoiceView = new DeleteInvoiceView();
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(deleteInvoiceView, DeleteInvoiceViewModel);
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL(ipAddress, port, db, username, password);
        DeleteInvoiceInputBoundary deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);
        DeleteInvoiceController deleteInvoiceController = new DeleteInvoiceController(deleteInvoiceInputBoundary);

        // UC show Delete Invoice UI
        DeleteInvoiceUIView deleteInvoiceUIView = new DeleteInvoiceUIView();
        DeleteInvoiceUIViewModel deleteInvoiceUIViewModel = new DeleteInvoiceUIViewModel();
        deleteInvoiceUIView.setDeleteInvoiceController(deleteInvoiceController);
        DeleteInvoiceUIPresenter deleteInvoiceUIPresenter = new DeleteInvoiceUIPresenter(deleteInvoiceUIView, deleteInvoiceUIViewModel);
        DeleteInvoiceUIInputBoundary deleteInvoiceUIInputBoundary = new DeleteInvoiceUIUseCase(deleteInvoiceUIPresenter);

        // find Invoice
        List<FindInvoiceViewModel> listFindInvoiceViewModel = new ArrayList<>();
        FindInvoiceView findInvoiceView = new FindInvoiceView();
        FindInvoiceOutputBoundary findInvoiceOutputBoundary = new FindInvoicePresenter(findInvoiceView, listFindInvoiceViewModel);
        FindInvoiceDatabaseBoundary findInvoiceDatabaseBoundary = new FindInvoiceDAOMySQL(ipAddress, port, db, username, password);
        FindInvoiceInputBoundary findInvoiceInputBoundary = new FindInvoiceUseCase(findInvoiceOutputBoundary, findInvoiceDatabaseBoundary);
        FindInvoiceController findInvoiceController = new FindInvoiceController(findInvoiceInputBoundary);
        findInvoiceView.setFindInvoiceController(findInvoiceController);

        // UC show Find Invoice UI
        FindInvoiceUIInputBoundary findInvoiceUIInputBoundary = new FindInvoiceUIUseCase(findInvoiceView);

        // edit Invoice
        EditInvoiceViewModel editInvoiceViewModel = new EditInvoiceViewModel();
        EditInvoiceView editInvoiceView = new EditInvoiceView();
        EditInvoiceOutputBoundary editInvoiceOutputBoundary = new EditInvoicePresenter(editInvoiceView, editInvoiceViewModel);
        EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary  = new EditInvoiceDAOMySQL(ipAddress, port, db, username, password);
        EditInvoiceInputBoundary editInvoiceInputBoundary = new EditInvoiceUseCase(editInvoiceOutputBoundary, editInvoiceDatabaseBoundary);
        EditInvoiceController editInvoiceController = new EditInvoiceController(editInvoiceInputBoundary);
        editInvoiceView.setEditInvoiceController(editInvoiceController);

        // UC show Edit Invoice UI
        EditInvoiceUIViewModel editInvoiceUIViewModel = new EditInvoiceUIViewModel();
        EditInvoiceUIDatabaseBoundary editInvoiceUIDatabaseBoundary = new EditInvoiceUIDAOMySQL(ipAddress, port, db, username, password);
        EditInvoiceUIPresenter editInvoiceUIPresenter = new EditInvoiceUIPresenter(editInvoiceView, editInvoiceViewModel, editInvoiceUIViewModel);
        EditInvoiceUIInputBoundary editInvoiceUIInputBoundary = new EditInvoiceUIUseCase(editInvoiceUIPresenter, editInvoiceUIDatabaseBoundary);

        // get list Invoice
        List<GetListInvoiceViewModel> listGetListInvoiceViewModel = new ArrayList<>();
        GetListInvoiceView getListInvoiceView = new GetListInvoiceView();
        GetListInvoiceOutputBoundary getListInvoiceOutputBoundary = new GetListInvoicePresenter(getListInvoiceView, listGetListInvoiceViewModel);
        GetListInvoiceDatabaseBoundary getListInvoiceDatabaseBoundary = new GetListInvoiceDAOMySQL(ipAddress, port, db, username, password);
        GetListInvoiceInputBoundary getListInvoiceInputBoundary = new GetListInvoiceUseCase(getListInvoiceOutputBoundary, getListInvoiceDatabaseBoundary);
        GetListInvoiceController getListInvoiceController = new GetListInvoiceController(getListInvoiceInputBoundary);
        getListInvoiceView.setGetListInvoiceController(getListInvoiceController);

        // UC show GetList Invoice UI
        GetListInvoiceUIInputBoundary getListInvoiceUIInputBoundary = new GetListInvoiceUIUseCase(getListInvoiceView);

        // sum KH Invoice 
        SumKHInvoiceViewModel sumKHInvoiceViewModel = new SumKHInvoiceViewModel();
        SumKHInvoiceView sumKHInvoiceView = new SumKHInvoiceView();
        SumKHInvoiceOutputBoundary sumKHInvoiceOutputBoundary = new SumKHInvoicePresenter(sumKHInvoiceView, sumKHInvoiceViewModel);
        SumKHInvoiceDatabaseBoundary sumKHInvoiceDatabaseBoundary = new SumKHInvoiceDAOMySQL(ipAddress, port, db, username, password);
        SumKHInvoiceInputBoundary sumKHInvoiceInputBoundary = new SumKHInvoiceUseCase(sumKHInvoiceOutputBoundary, sumKHInvoiceDatabaseBoundary);
        SumKHInvoiceController sumKHInvoiceController = new SumKHInvoiceController(sumKHInvoiceInputBoundary);
        sumKHInvoiceView.setSumKHInvoiceController(sumKHInvoiceController);

        // UC show SumKHH Invoice UI
        SumKHInvoiceUIPresenter sumKHInvoiceUIPresenter = new SumKHInvoiceUIPresenter(sumKHInvoiceView);
        SumKHInvoiceUIInputBoundary sumKHInvoiceUIInputBoundary = new SumKHInvoiceUIUseCase(sumKHInvoiceUIPresenter);

        // avg Money Invoice Nuoc Ngoai
        AvgMoneyInvoiceNuocNgoaiViewModel avgMoneyInvoiceNuocNgoaiViewModel = new AvgMoneyInvoiceNuocNgoaiViewModel();
        AvgMoneyInvoiceNuocNgoaiView avgMoneyInvoiceNuocNgoaiView = new AvgMoneyInvoiceNuocNgoaiView();
        AvgMoneyInvoiceNuocNgoaiOutputBoundary avgMoneyInvoiceNuocNgoaiOutputBoundary = new AvgMoneyInvoiceNuocNgoaiPresenter(avgMoneyInvoiceNuocNgoaiView, avgMoneyInvoiceNuocNgoaiViewModel);
        AvgMoneyInvoiceNuocNgoaiDatabaseBoundary avgMoneyInvoiceNuocNgoaiDatabaseBoundary = new AvgMoneyInvoiceNuocNgoaiDAOMySQL(ipAddress, port, db, username, password);
        AvgMoneyInvoiceNuocNgoaiInputBoundary avgMoneyInvoiceNuocNgoaiInputBoundary = new AvgMoneyInvoiceNuocNgoaiUseCase(avgMoneyInvoiceNuocNgoaiDatabaseBoundary, avgMoneyInvoiceNuocNgoaiOutputBoundary);
        AvgMoneyInvoiceNuocNgoaiController avgMoneyInvoiceNuocNgoaiController = new AvgMoneyInvoiceNuocNgoaiController(avgMoneyInvoiceNuocNgoaiInputBoundary);
        avgMoneyInvoiceNuocNgoaiView.setAvgMoneyInvoiceNuocNgoaiController(avgMoneyInvoiceNuocNgoaiController);
        
        // UC show AvgMoney Invoice UI
        AvgMoneyInvoiceNuocNgoaiUIPresenter avgMoneyInvoiceNuocNgoaiUIPresenter = new AvgMoneyInvoiceNuocNgoaiUIPresenter(avgMoneyInvoiceNuocNgoaiView);
        AvgMoneyInvoiceNuocNgoaiUIInputBoundary avgMoneyInvoiceNuocNgoaiUIInputBoundary = new AvgMoneyInvoiceNuocNgoaiUIUseCase(avgMoneyInvoiceNuocNgoaiUIPresenter);

        // export Invoice by Month
        List<ExportInvoiceByMonthViewModel> exportInvoiceByMonthViewModel = new ArrayList<>();
        ExportInvoiceByMonthView exportInvoiceByMonthView = new ExportInvoiceByMonthView();
        ExportInvoiceByMonthOutputBoundary exportInvoiceByMonthOutputBoundary = new ExportInvoiceByMonthPresenter(exportInvoiceByMonthView, exportInvoiceByMonthViewModel);
        ExportInvoiceByMonthDatabaseBoundary exportInvoiceByMonthDatabaseBoundary = new ExportInvoiceByMonthDAOMySQL(ipAddress, port, db, username, password);
        ExportInvoiceByMonthInputBoundary exportInvoiceByMonthInputBoundary = new ExportInvoiceByMonthUseCase(exportInvoiceByMonthDatabaseBoundary, exportInvoiceByMonthOutputBoundary);
        ExportInvoiceByMonthController exportInvoiceByMonthController = new ExportInvoiceByMonthController(exportInvoiceByMonthInputBoundary);
        exportInvoiceByMonthView.setExportInvoiceByMonthController(exportInvoiceByMonthController);

        // UC show AvgMoney Invoice UI
        ExportInvoiceByMonthUIPresenter exportInvoiceByMonthUIPresenter = new ExportInvoiceByMonthUIPresenter(exportInvoiceByMonthView);
        ExportInvoiceByMonthUIInputBoundary exportInvoiceByMonthUIInputBoundary = new ExportInvoiceByMonthUIUseCase(exportInvoiceByMonthUIPresenter);

        // MainGUI
        QuanLyHDTienDienViewModel quanLyHDTienDienViewModel = new QuanLyHDTienDienViewModel();
        QuanLyHDTienDienView quanLyHDTienDienView = QuanLyHDTienDienView.getQuanLyHDTienDienView();
        quanLyHDTienDienView.setListInvoice(listGetListInvoiceViewModel);
        quanLyHDTienDienView.setGetListInvoiceInputBoundary(getListInvoiceInputBoundary);
        QuanLyHDTienDienOutputBoundary quanLyHDTienDienOutputBoundary = new QuanLyHDTienDienPresenter(quanLyHDTienDienView, quanLyHDTienDienViewModel);
        QuanLyHDTienDienInputBoundary quanLyHDTienDienInputBoundary = new QuanLyHDTienDienUseCase(quanLyHDTienDienOutputBoundary);
        QuanLyHDTienDienController quanLyHDTienDienController = new QuanLyHDTienDienController(quanLyHDTienDienInputBoundary);

        quanLyHDTienDienView.setQuanLyHDTienDienController(quanLyHDTienDienController);
        quanLyHDTienDienInputBoundary.setAddInvoiceUIInputBoundary(addInvoiceUIInputBoundary);
        quanLyHDTienDienInputBoundary.setDeleteInvoiceUIInputBoundary(deleteInvoiceUIInputBoundary);
        quanLyHDTienDienInputBoundary.setEditInvoiceUIInputBoundary(editInvoiceUIInputBoundary);
        quanLyHDTienDienInputBoundary.setFindInvoiceUIInputBoundary(findInvoiceUIInputBoundary);
        quanLyHDTienDienInputBoundary.setAvgMoneyInvoiceNuocNgoaiUIInputBoundary(avgMoneyInvoiceNuocNgoaiUIInputBoundary);
        quanLyHDTienDienInputBoundary.setSumKHInvoiceUIInputBoundary(sumKHInvoiceUIInputBoundary);
        quanLyHDTienDienInputBoundary.setExportInvoiceByMonthUIInputBoundary(exportInvoiceByMonthUIInputBoundary);

        ((AddInvoiceUseCase)addInvoiceInputBoundary).subscriber(quanLyHDTienDienView);
        ((DeleteInvoiceUseCase)deleteInvoiceInputBoundary).subscriber(quanLyHDTienDienView);
        ((EditInvoiceUseCase)editInvoiceInputBoundary).subscriber(quanLyHDTienDienView);
        ((FindInvoiceUseCase)findInvoiceInputBoundary).subscriber(quanLyHDTienDienView);
        ((AvgMoneyInvoiceNuocNgoaiUseCase)avgMoneyInvoiceNuocNgoaiInputBoundary).subscriber(quanLyHDTienDienView);
        ((SumKHInvoiceUseCase)sumKHInvoiceInputBoundary).subscriber(quanLyHDTienDienView);
        ((ExportInvoiceByMonthUseCase)exportInvoiceByMonthInputBoundary).subscriber(quanLyHDTienDienView);

        // forgot form
        ForgotUIViewModel forgotUIViewModel = new ForgotUIViewModel();
        ForgotUIView forgotUIView = new ForgotUIView();
        ForgotUIOutputBoundary forgotUIOutputBoundary = new ForgotUIPresenter(forgotUIView, forgotUIViewModel);
        ForgotUIInputBoundary forgotUIInputBoundary = new ForgotUIUseCase(forgotUIOutputBoundary);
        ForgotUIController forgotUIController = new ForgotUIController(forgotUIInputBoundary);

        // forgot
        ForgotViewModel forgotViewModel = new ForgotViewModel();
        ForgotDatabaseBoundary forgotDatabaseBoundary = new ForgotDAOMySQL(ipAddress, port, db, username, password);
        ForgotOutputBoundary forgotOutputBoundary = new ForgotPresenter(forgotUIView, forgotViewModel);
        ForgotInputBoundary forgotInputBoundary = new ForgotUseCase(forgotDatabaseBoundary, forgotOutputBoundary);
        ForgotController forgotController = new ForgotController(forgotInputBoundary);

        // register form
        RegisterUIViewModel registerUIViewModel = new RegisterUIViewModel();
        RegisterUIView registerUIView = new RegisterUIView();
        RegisterUIOutputBoundary registerUIOutputBoundary = new RegisterUIPresenter(registerUIView, registerUIViewModel);
        RegisterUIInputBoundary registerUIInputBoundary = new RegisterUIUseCase(registerUIOutputBoundary);
        RegisterUIController registerUIController = new RegisterUIController(registerUIInputBoundary);


        // register
        RegisterViewModel registerViewModel = new RegisterViewModel();
        RegisterDatabaseBoundary registerDatabaseBoundary = new RegisterDAOMySQL(ipAddress, port, db, username, password);
        RegisterOutputBoundary registerOutputBoundary = new RegisterPresenter(registerUIView, registerViewModel);
        RegisterInputBoundary registerInputBoundary = new RegisterUseCase(registerDatabaseBoundary, registerOutputBoundary);
        RegisterController registerController = new RegisterController(registerInputBoundary);

        // login form
        LoginUIViewModel loginUIViewModel = new LoginUIViewModel();
        LoginUIView loginUIView = new LoginUIView();
        LoginUIOutputBoundary loginUIOutputBoundary = new LoginUIPresenter(loginUIView, loginUIViewModel);
        LoginUIInputBoundary loginUIInputBoundary = new LoginUIUseCase(loginUIOutputBoundary);
        LoginUIController loginUIController = new LoginUIController(loginUIInputBoundary);
        quanLyHDTienDienInputBoundary.setLoginUIInputBoundary(loginUIInputBoundary);

        // login
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginDatabaseBoundary loginDatabaseBoundary = new LoginDAOMySQL(ipAddress, port, db, username, password);
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(loginUIView, loginViewModel, quanLyHDTienDienView);
        LoginInputBoundary loginInputBoundary = new LoginUseCase(loginDatabaseBoundary, loginOutputBoundary);
        LoginController loginController = new LoginController(loginInputBoundary);


        registerUIInputBoundary.setRegisterInputBoundary(registerInputBoundary);
        forgotUIInputBoundary.setForgotInputBoundary(forgotInputBoundary);

        loginUIInputBoundary.setLoginInputBoundary(loginInputBoundary);
        loginUIInputBoundary.setRegisterUIInputBoundary(registerUIInputBoundary);
        loginUIInputBoundary.setForgotUIInputBoundary(forgotUIInputBoundary);

        loginUIView.setLoginUIController(loginUIController);
        registerUIView.setRegisterUIController(registerUIController);
        forgotUIView.setForgotUIInputBoundary(forgotUIInputBoundary);

        // run Login form
        loginUIController.execute();
    }
}
