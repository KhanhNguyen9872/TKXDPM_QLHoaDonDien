package com.nhom2.detail.avgMoneyInvoiceNuocNgoai;

import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiOutputBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiOutputDTO;

public class AvgMoneyInvoiceNuocNgoaiPresenter implements AvgMoneyInvoiceNuocNgoaiOutputBoundary {
    private AvgMoneyInvoiceNuocNgoaiViewModel avgMoneyInvoiceNuocNgoaiViewModel;
    private AvgMoneyInvoiceNuocNgoaiView avgMoneyInvoiceNuocNgoaiView;

    public AvgMoneyInvoiceNuocNgoaiPresenter(AvgMoneyInvoiceNuocNgoaiView avgMoneyInvoiceNuocNgoaiView, AvgMoneyInvoiceNuocNgoaiViewModel avgMoneyInvoiceNuocNgoaiViewModel) {
        this.avgMoneyInvoiceNuocNgoaiView = avgMoneyInvoiceNuocNgoaiView;
        this.avgMoneyInvoiceNuocNgoaiViewModel = avgMoneyInvoiceNuocNgoaiViewModel;
    }

    @Override
    public void present(AvgMoneyInvoiceNuocNgoaiOutputDTO avgMoneyInvoiceNuocNgoaiOutputDTO) {
        this.avgMoneyInvoiceNuocNgoaiViewModel.status = avgMoneyInvoiceNuocNgoaiOutputDTO.getStatus();
        this.avgMoneyInvoiceNuocNgoaiViewModel.msg = "Tổng trung bình thành tiền (Nước ngoài): " + avgMoneyInvoiceNuocNgoaiOutputDTO.getTotal() + " VND";
        
        if (this.avgMoneyInvoiceNuocNgoaiView != null) {
            this.avgMoneyInvoiceNuocNgoaiView.showMsgResult(this.avgMoneyInvoiceNuocNgoaiViewModel);
        }
    }

    @Override
    public void exportError(AvgMoneyInvoiceNuocNgoaiOutputDTO responseError) {
        this.avgMoneyInvoiceNuocNgoaiViewModel.status = responseError.getStatus();
        this.avgMoneyInvoiceNuocNgoaiViewModel.msg = responseError.getMsg();
        
        if (this.avgMoneyInvoiceNuocNgoaiView != null) {
            this.avgMoneyInvoiceNuocNgoaiView.showMsgError(avgMoneyInvoiceNuocNgoaiViewModel);
        }
    }

}
