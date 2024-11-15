package com.nhom2.detail.register;

import javax.swing.*;

import com.nhom2.businessRules.register.RegisterInputDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUIView extends JFrame implements ActionListener {
    private RegisterController registerController;
    private JLabel lblUsername, lblEmail, lblPassword, lblRePassword;
    private JLabel lblUsernameErr, lblEmailErr, lblPasswordErr, lblRePasswordErr;
    private JTextField txtUsername, txtEmail;
    private JPasswordField txtPassword, txtRePassword;
    private JButton btnRegister;

    public RegisterUIView() {

    }

    

    public void setRegisterController(RegisterController registerController) {
        this.registerController = registerController;
    }



    public void mainShow() {
        getContentPane().removeAll();
        // Set up the form
        setTitle("Register Form");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridBagLayout());

        // Create components
        lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(20);
        lblUsernameErr = new JLabel("");
        lblUsernameErr.setForeground(Color.RED);

        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(20);
        lblEmailErr = new JLabel("");
        lblEmailErr.setForeground(Color.RED);

        lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField(20);
        lblPasswordErr = new JLabel("");
        lblPasswordErr.setForeground(Color.RED);

        lblRePassword = new JLabel("Re-enter Password:");
        txtRePassword = new JPasswordField(20);
        lblRePasswordErr = new JLabel("");
        lblRePasswordErr.setForeground(Color.RED);

        btnRegister = new JButton("Register");

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
        add(lblEmail, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        add(txtEmail, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        add(lblEmailErr, gbc); // Add email error label

        gbc.gridx = 0; gbc.gridy = 4;
        add(lblPassword, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        add(txtPassword, gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        add(lblPasswordErr, gbc); // Add password error label

        gbc.gridx = 0; gbc.gridy = 6;
        add(lblRePassword, gbc);

        gbc.gridx = 1; gbc.gridy = 6;
        add(txtRePassword, gbc);

        gbc.gridx = 1; gbc.gridy = 7;
        add(lblRePasswordErr, gbc); // Add re-password error label

        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        add(btnRegister, gbc);

        // Button action
        btnRegister.addActionListener(this);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals(btnRegister.getText())) {
            lblUsernameErr.setText("");
            lblEmailErr.setText("");
            lblPasswordErr.setText("");
            lblRePasswordErr.setText("");

            String username = txtUsername.getText().trim();
            String email = txtEmail.getText().trim();
            String password = new String(txtPassword.getPassword());
            String rePassword = new String(txtRePassword.getPassword());

            RegisterInputDTO registerInputDTO = new RegisterInputDTO();
            registerInputDTO.setUsername(username);
            registerInputDTO.setEmail(email);
            registerInputDTO.setPassword(password);
            registerInputDTO.setRepassword(rePassword);

            this.registerController.execute(registerInputDTO);
        }
    }



    public void showMsgError(RegisterViewModel registerViewModel) {
        String msg = registerViewModel.msg;

        if (registerViewModel.usernameErr) {
            txtUsername.requestFocusInWindow();
            lblUsernameErr.setText(msg);
        } else {
            lblUsernameErr.setText("");
        }

        if (registerViewModel.emailErr) {
            txtEmail.requestFocusInWindow();
            lblEmailErr.setText(msg);
        } else {
            lblEmailErr.setText("");
        }

        if (registerViewModel.passwordErr) {
            txtPassword.requestFocusInWindow();
            lblPasswordErr.setText(msg);
        } else {
            lblPasswordErr.setText("");
        }

        if (registerViewModel.repasswordErr) {
            txtRePassword.requestFocusInWindow();
            lblRePasswordErr.setText(msg);
        } else {
            lblRePasswordErr.setText("");
        }

        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                msg,
                registerViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }

    private void wipeInput() {
        txtUsername.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtRePassword.setText("");
    }

    public void showMsgResult(RegisterViewModel registerViewModel) {
        JOptionPane.showMessageDialog(null,
        registerViewModel.msg,
                registerViewModel.status,
                JOptionPane.INFORMATION_MESSAGE);
        
        this.setVisible(false);
        this.wipeInput();
    }
}
