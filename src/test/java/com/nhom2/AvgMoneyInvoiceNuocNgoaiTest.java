package com.nhom2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiDatabaseBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiInputBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiOutputBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiUseCase;
import com.nhom2.database.mysql.AvgMoneyInvoiceNuocNgoaiDAOMySQL;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiController;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiPresenter;
import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiViewModel;

public class AvgMoneyInvoiceNuocNgoaiTest extends Nhom2Test {
    @Test
    public void avgMoneyInvoiceNuocNgoaiSuccess() throws Exception
    {
        AvgMoneyInvoiceNuocNgoaiViewModel avgMoneyInvoiceNuocNgoaiViewModel = new AvgMoneyInvoiceNuocNgoaiViewModel();
        AvgMoneyInvoiceNuocNgoaiOutputBoundary avgMoneyInvoiceNuocNgoaiOutputBoundary = new AvgMoneyInvoiceNuocNgoaiPresenter(null, avgMoneyInvoiceNuocNgoaiViewModel);
        AvgMoneyInvoiceNuocNgoaiDatabaseBoundary avgMoneyInvoiceNuocNgoaiDatabaseBoundary = new AvgMoneyInvoiceNuocNgoaiDAOMySQL(ipAddress, port, db, username, password);
        AvgMoneyInvoiceNuocNgoaiInputBoundary avgMoneyInvoiceNuocNgoaiInputBoundary = new AvgMoneyInvoiceNuocNgoaiUseCase(avgMoneyInvoiceNuocNgoaiDatabaseBoundary, avgMoneyInvoiceNuocNgoaiOutputBoundary);
        AvgMoneyInvoiceNuocNgoaiController avgMoneyInvoiceNuocNgoaiController = new AvgMoneyInvoiceNuocNgoaiController(avgMoneyInvoiceNuocNgoaiInputBoundary);
                
        avgMoneyInvoiceNuocNgoaiController.execute();
        assertEquals(avgMoneyInvoiceNuocNgoaiViewModel.msg, "Tổng trung bình thành tiền (Nước ngoài): 625.0 VND");
    }

}
