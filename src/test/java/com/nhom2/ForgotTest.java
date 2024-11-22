package com.nhom2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nhom2.businessRules.forgot.ForgotInputBoundary;
import com.nhom2.businessRules.forgot.ForgotInputDTO;
import com.nhom2.businessRules.forgot.ForgotOutputBoundary;
import com.nhom2.businessRules.forgot.ForgotUseCase;
import com.nhom2.database.mysql.ForgotDAOMySQL;
import com.nhom2.detail.forgot.ForgotPresenter;
import com.nhom2.detail.forgot.ForgotViewModel;

public class ForgotTest extends Nhom2Test {
    private ForgotInputBoundary forgotInputBoundary;
    private ForgotViewModel forgotViewModel;

    private void prepareUseCase() throws Exception {
        this.forgotViewModel = new ForgotViewModel();
        // AddInvoiceView addInvoiceView = new AddInvoiceView();
        ForgotOutputBoundary forgotOutputBoundary = new ForgotPresenter(null, this.forgotViewModel);
        ForgotDAOMySQL forgotDAOMySQL = new ForgotDAOMySQL(ipAddress, port, db, username, password);
        this.forgotInputBoundary = new ForgotUseCase(forgotDAOMySQL, forgotOutputBoundary);
    }


    // Success
    @Test
    public void forgotSuccess() throws Exception
    {
        prepareUseCase();

        ForgotInputDTO forgotInputDTO = new ForgotInputDTO();

        forgotInputDTO.setUsername("user");
        forgotInputDTO.setEmail("user@localhost.com");

        this.forgotInputBoundary.execute(forgotInputDTO);
        assertEquals(this.forgotViewModel.msg, "Đã đặt lại mật khẩu thành công!");

    }

    // Error
    @Test
    public void forgotError() throws Exception
    {
        prepareUseCase();

        ForgotInputDTO forgotInputDTO = new ForgotInputDTO();

        this.forgotInputBoundary.execute(forgotInputDTO);
        assertEquals(this.forgotViewModel.msg, "Tên tài khoản không được để trống!");

        forgotInputDTO.setUsername("user");

        this.forgotInputBoundary.execute(forgotInputDTO);
        assertEquals(this.forgotViewModel.msg, "Email không được để trống!");

        forgotInputDTO.setEmail("user");

        this.forgotInputBoundary.execute(forgotInputDTO);
        assertEquals(this.forgotViewModel.msg, "Email không đúng định dạng!");

        forgotInputDTO.setEmail("user1@localhost.com");

        this.forgotInputBoundary.execute(forgotInputDTO);
        assertEquals(this.forgotViewModel.msg, "Thông tin tài khoản không chính xác!");

    }

}
