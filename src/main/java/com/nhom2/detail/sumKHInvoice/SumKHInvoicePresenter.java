package com.nhom2.detail.sumKHInvoice;

import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceOutputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceOutputDTO;

public class SumKHInvoicePresenter implements SumKHInvoiceOutputBoundary {
    private SumKHInvoiceView sumKHInvoiceView;
    private SumKHInvoiceViewModel sumKHInvoiceViewModel;

    public SumKHInvoicePresenter(SumKHInvoiceView sumKHInvoiceView, SumKHInvoiceViewModel sumKHInvoiceViewModel) {
        this.sumKHInvoiceView = sumKHInvoiceView;
        this.sumKHInvoiceViewModel = sumKHInvoiceViewModel;
    }

    @Override
    public void exportError(SumKHInvoiceOutputDTO responseError) {        
        sumKHInvoiceViewModel.status = responseError.getStatus();
        String inputNameError, msg;

        try {
            inputNameError = responseError.getMsg().split(",")[0];
            msg = responseError.getMsg().split(",")[1];

            if (inputNameError.equals("loaiKH")) {
                sumKHInvoiceViewModel.loaiKHErr = true;
            } else {
                sumKHInvoiceViewModel.loaiKHErr = false;
            }
        } catch (Exception e) {
            msg = responseError.getMsg();
        }

        sumKHInvoiceViewModel.msg = msg;

        if (this.sumKHInvoiceView != null) {
            this.sumKHInvoiceView.showMsgError(this.sumKHInvoiceViewModel);
        }
    }

    @Override
    public void present(SumKHInvoiceOutputDTO sumKHInvoiceOutputDTO) {
        String loaiKH = sumKHInvoiceOutputDTO.getLoaiKH();
        sumKHInvoiceViewModel.status = sumKHInvoiceOutputDTO.getStatus();

        sumKHInvoiceViewModel.msg = "Tổng KH";

        if (!loaiKH.equals("Tất cả")) {
            sumKHInvoiceViewModel.msg = sumKHInvoiceViewModel.msg + " của (" + loaiKH + ")";
        }

        sumKHInvoiceViewModel.msg = sumKHInvoiceViewModel.msg + ": " + sumKHInvoiceOutputDTO.getTotal() + " khách hàng";

        if (this.sumKHInvoiceView != null) {
            this.sumKHInvoiceView.showMsgResult(this.sumKHInvoiceViewModel);
        }
    }

}
