package com.nhom2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nhom2.businessRules.login.LoginInputBoundary;
import com.nhom2.businessRules.login.LoginInputDTO;
import com.nhom2.businessRules.login.LoginOutputBoundary;
import com.nhom2.businessRules.login.LoginUseCase;
import com.nhom2.database.mysql.LoginDAOMySQL;
import com.nhom2.detail.login.LoginPresenter;
import com.nhom2.detail.login.LoginViewModel;

public class LoginTest extends Nhom2Test {
    private LoginInputBoundary loginInputBoundary;
    private LoginViewModel loginViewModel;

    private void prepareUseCase() throws Exception {
        this.loginViewModel = new LoginViewModel();
        // AddInvoiceView addInvoiceView = new AddInvoiceView();
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(null, this.loginViewModel, null);
        LoginDAOMySQL loginDAOMySQL = new LoginDAOMySQL(ipAddress, port, db, username, password);
        this.loginInputBoundary = new LoginUseCase(loginDAOMySQL, loginOutputBoundary);
    }


    // Success
    @Test
    public void loginSuccess() throws Exception
    {
        prepareUseCase();

        LoginInputDTO loginInputDTO = new LoginInputDTO();

        loginInputDTO.setUsername("admin");
        loginInputDTO.setPassword("admin");

        this.loginInputBoundary.execute(loginInputDTO);
        assertEquals(this.loginViewModel.msg, "Đăng nhập thành công!");


    }

    
// Error
    @Test
    public void loginError() throws Exception
    {
        prepareUseCase();

        LoginInputDTO loginInputDTO = new LoginInputDTO();
        
        this.loginInputBoundary.execute(loginInputDTO);
        assertEquals(this.loginViewModel.msg, "Tên tài khoản không được để trống!");
        
        loginInputDTO.setUsername("test");

        this.loginInputBoundary.execute(loginInputDTO);
        assertEquals(this.loginViewModel.msg, "Mật khẩu không được để trống!");


        loginInputDTO.setPassword("test");

        this.loginInputBoundary.execute(loginInputDTO);
        assertEquals(this.loginViewModel.msg, "Tài khoản hoặc mật khẩu không chính xác!");


    }
    
}
