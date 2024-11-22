package com.nhom2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nhom2.businessRules.login.LoginInputBoundary;
import com.nhom2.businessRules.login.LoginInputDTO;
import com.nhom2.businessRules.login.LoginOutputBoundary;
import com.nhom2.businessRules.login.LoginUseCase;
import com.nhom2.businessRules.register.RegisterInputBoundary;
import com.nhom2.businessRules.register.RegisterInputDTO;
import com.nhom2.businessRules.register.RegisterOutputBoundary;
import com.nhom2.businessRules.register.RegisterUseCase;
import com.nhom2.database.mysql.LoginDAOMySQL;
import com.nhom2.database.mysql.RegisterDAOMySQL;
import com.nhom2.detail.login.LoginPresenter;
import com.nhom2.detail.login.LoginViewModel;
import com.nhom2.detail.register.RegisterPresenter;
import com.nhom2.detail.register.RegisterViewModel;

public class RegisterTest extends Nhom2Test {
    private RegisterInputBoundary registerInputBoundary;
    private RegisterViewModel registerViewModel;

    private void prepareUseCase() throws Exception {
        this.registerViewModel = new RegisterViewModel();
        // AddInvoiceView addInvoiceView = new AddInvoiceView();
        RegisterOutputBoundary registerOutputBoundary = new RegisterPresenter(null, this.registerViewModel);
        RegisterDAOMySQL registerDAOMySQL = new RegisterDAOMySQL(ipAddress, port, db, username, password);
        this.registerInputBoundary = new RegisterUseCase(registerDAOMySQL, registerOutputBoundary);
    }


    // Success
    @Test
    public void loginSuccess() throws Exception
    {
        prepareUseCase();

        RegisterInputDTO registerInputDTO = new RegisterInputDTO();

        registerInputDTO.setUsername("tester");
        registerInputDTO.setEmail("tester@localhost.com");
        registerInputDTO.setPassword("tester123456");
        registerInputDTO.setRepassword("tester123456");

        this.registerInputBoundary.execute(registerInputDTO);
        assertEquals(this.registerViewModel.msg, "Đăng ký thành công!");
    }

    
    // Success
    @Test
    public void loginError() throws Exception
    {
        prepareUseCase();

        RegisterInputDTO registerInputDTO = new RegisterInputDTO();

        this.registerInputBoundary.execute(registerInputDTO);
        assertEquals(this.registerViewModel.msg, "Tên tài khoản không được để trống!");

        registerInputDTO.setUsername("admin");

        this.registerInputBoundary.execute(registerInputDTO);
        assertEquals(this.registerViewModel.msg, "Email không được để trống!");

        registerInputDTO.setEmail("tester@localhost.com");

        this.registerInputBoundary.execute(registerInputDTO);
        assertEquals(this.registerViewModel.msg, "Mật khẩu không được để trống!");

        registerInputDTO.setPassword("tester");

        this.registerInputBoundary.execute(registerInputDTO);
        assertEquals(this.registerViewModel.msg, "Nhập lại mật khẩu không được để trống!");

        registerInputDTO.setRepassword("tester1");

        this.registerInputBoundary.execute(registerInputDTO);
        assertEquals(this.registerViewModel.msg, "Nhập lại mật khẩu không trùng khớp!");

        registerInputDTO.setPassword("tester");
        registerInputDTO.setRepassword("tester");

        this.registerInputBoundary.execute(registerInputDTO);
        assertEquals(this.registerViewModel.msg, "Mật khẩu không được nhỏ hơn 8 ký tự!");


        registerInputDTO.setPassword("tester123456");
        registerInputDTO.setRepassword("tester123456");

        this.registerInputBoundary.execute(registerInputDTO);
        assertEquals(this.registerViewModel.msg, "Tên tài khoản này đã tồn tại!");
    }

}
