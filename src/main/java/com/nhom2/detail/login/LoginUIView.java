package com.nhom2.detail.login;

import javax.swing.*;

import com.nhom2.businessRules.login.LoginInputDTO;
import com.nhom2.detail.forgot.ForgotUIController;
import com.nhom2.detail.register.RegisterUIController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginUIView extends JFrame implements ActionListener {
    private LoginController loginController;
    private RegisterUIController registerUIController;
    private ForgotUIController forgotUIController;
    private JLabel lblUsername, lblPassword;
    private JLabel lblUsernameErr, lblPasswordErr;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnRegister, btnForgotPassword;

    public LoginUIView() {

    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public void mainShow() {
        getContentPane().removeAll();
        // Set the title of the form
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridBagLayout());

        // Create components
        lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(20);
        lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField(20);

        lblUsernameErr = new JLabel("");
        lblPasswordErr = new JLabel("");
        lblUsernameErr.setForeground(Color.RED);
        lblPasswordErr.setForeground(Color.RED);

        btnLogin = new JButton("Login");
        btnRegister = new JButton("Register");
        btnForgotPassword = new JButton("Forgot Password");

         // Layout manager
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.insets = new Insets(5, 10, 5, 10);
         gbc.fill = GridBagConstraints.HORIZONTAL;
 
         // Add components to the frame
         gbc.gridx = 0; gbc.gridy = 0;
         add(lblUsername, gbc);
 
         gbc.gridx = 1; gbc.gridy = 0;
         add(txtUsername, gbc);
 
         gbc.gridx = 1; gbc.gridy = 1;
         add(lblUsernameErr, gbc); // Add username error label
 
         gbc.gridx = 0; gbc.gridy = 2;
         add(lblPassword, gbc);
 
         gbc.gridx = 1; gbc.gridy = 2;
         add(txtPassword, gbc);
 
         gbc.gridx = 1; gbc.gridy = 3;
         add(lblPasswordErr, gbc); // Add password error label
 
         gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
         add(btnLogin, gbc);
 
         gbc.gridy = 5;
         add(btnRegister, gbc);
 
         gbc.gridy = 6;
         add(btnForgotPassword, gbc);

        // Button actions
        btnLogin.addActionListener(this);
        btnRegister.addActionListener(this);
        btnForgotPassword.addActionListener(this);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals(btnLogin.getText())) {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            LoginInputDTO loginInputDTO = new LoginInputDTO();
            loginInputDTO.setUsername(username);
            loginInputDTO.setPassword(password);
            
            this.loginController.execute(loginInputDTO);
        } else if (cmd.equals(btnRegister.getText())) {
            this.registerUIController.execute();

        } else if (cmd.equals(btnForgotPassword.getText())) {
            this.forgotUIController.execute();
        }
    }

    public void showMsgError(LoginViewModel loginViewModel) {
        String msg = loginViewModel.msg;

        if (loginViewModel.usernameErr) {
            txtUsername.requestFocusInWindow();
            lblUsernameErr.setText(msg);
        } else {
            lblUsernameErr.setText("");
        }

        if (loginViewModel.passwordErr) {
            txtPassword.requestFocusInWindow();
            lblPasswordErr.setText(msg);
        } else {
            lblPasswordErr.setText("");
        }

        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                msg,
                loginViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }

    public void showMsgResult(LoginViewModel loginViewModel) {
        // Show alert dialog
        JOptionPane.showMessageDialog(null,
            loginViewModel.msg,
                loginViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }

    public void setRegisterUIController(RegisterUIController registerUIController) {
        this.registerUIController = registerUIController;
    }

    public void setForgotUIController(ForgotUIController forgotUIController) {
        this.forgotUIController = forgotUIController;
    }

    private void wipeInput() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public void hideGUI() {
        this.wipeInput();
        this.setVisible(false);
    }

    
}
