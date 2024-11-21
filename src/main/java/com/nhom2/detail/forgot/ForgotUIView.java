package com.nhom2.detail.forgot;

import java.awt.event.ActionListener;

import javax.swing.*;

import com.nhom2.businessRules.forgot.ForgotInputDTO;
import com.nhom2.businessRules.forgot.ForgotUIInputBoundary;
import com.nhom2.businessRules.forgot.ForgotUIInputDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotUIView extends JFrame implements ActionListener {
    private ForgotUIInputBoundary forgotUIInputBoundary;
    private JLabel lblUsername, lblUsernameErr, lblEmail, lblEmailErr;
    private JTextField txtUsername, txtEmail;
    private JButton btnForgotPassword;

    public ForgotUIView() {

    }

    public void mainShow() {
        getContentPane().removeAll();
        // Set up the form
        setTitle("Forgot Password Form");
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);
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
        add(lblUsernameErr, gbc); // Username error label

        gbc.gridx = 0; gbc.gridy = 2;
        add(lblEmail, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        add(txtEmail, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        add(lblEmailErr, gbc); // Email error label

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(btnForgotPassword, gbc);

        // Button action
        btnForgotPassword.addActionListener(this);

        // Make the frame visible
        setVisible(true);
    }

    


    public void setForgotUIInputBoundary(ForgotUIInputBoundary forgotUIInputBoundary) {
        this.forgotUIInputBoundary = forgotUIInputBoundary;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals(btnForgotPassword.getText())) {
            // Clear previous error messages
            lblUsernameErr.setText("");
            lblEmailErr.setText("");

            String username = txtUsername.getText().trim();
            String email = txtEmail.getText().trim();

            ForgotUIInputDTO forgotUIInputDTO = new ForgotUIInputDTO();
            forgotUIInputDTO.setChucNang("Quên mật khẩu");
            forgotUIInputDTO.setUsername(username);
            forgotUIInputDTO.setEmail(email);

            this.forgotUIInputBoundary.execute(forgotUIInputDTO);
        }
    }

    public void ForgotPasswordSuccessDialog(String msg, String newPassword) {
        JFrame jFrame = new JFrame();

        // Set up the frame
        jFrame.setTitle("Success");
        jFrame.setSize(300, 150);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new GridBagLayout());

        // Components
        JLabel lblMessage = new JLabel(msg);
        lblMessage.setFont(new Font("Arial", Font.BOLD, 14));
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblNewPassword = new JLabel("New Password:");
        JTextField txtNewPassword = new JTextField(newPassword);
        txtNewPassword.setEditable(false);

        // Layout manager
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        jFrame.add(lblMessage, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        jFrame.add(lblNewPassword, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        jFrame.add(txtNewPassword, gbc);

        // Make the frame visible
        jFrame.setVisible(true);
    }

	public void showMsgResult(ForgotViewModel forgotViewModel) {
		this.ForgotPasswordSuccessDialog(forgotViewModel.msg, forgotViewModel.newPassword);
        this.setVisible(false);
        this.wipeInput();
	}

    public void wipeInput() {
        txtUsername.setText("");
        txtEmail.setText("");
    }

    public void showMsgError(ForgotViewModel forgotViewModel) {
        String msg = forgotViewModel.msg;

        if (forgotViewModel.usernameErr) {
            txtUsername.requestFocusInWindow();
            lblUsernameErr.setText(msg);
        } else {
            lblUsernameErr.setText("");
        }

        if (forgotViewModel.emailErr) {
            txtEmail.requestFocusInWindow();
            lblEmailErr.setText(msg);
        } else {
            lblEmailErr.setText("");
        }

        // Show alert dialog
        JOptionPane.showMessageDialog(null,
                msg,
                forgotViewModel.status,
                JOptionPane.ERROR_MESSAGE);
    }
}   
