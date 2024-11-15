package com.nhom2.businessRules.forgot;

import java.security.SecureRandom;

public class ForgotUseCase implements ForgotInputBoundary {
    private ForgotDatabaseBoundary forgotDatabaseBoundary;
    private ForgotOutputBoundary forgotOutputBoundary;

    public ForgotUseCase(ForgotDatabaseBoundary forgotDatabaseBoundary, ForgotOutputBoundary forgotOutputBoundary) {
        this.forgotDatabaseBoundary = forgotDatabaseBoundary;
        this.forgotOutputBoundary = forgotOutputBoundary;
    }

    @Override
    public void execute(ForgotInputDTO forgotInputDTO) {
        ForgotOutputDTO forgotOutputDTO = new ForgotOutputDTO();
        if (!verify(forgotInputDTO, forgotOutputDTO)) {
            this.forgotOutputBoundary.exportError(forgotOutputDTO);
            return;
        }

        String username = forgotInputDTO.getUsername();
        String email = forgotInputDTO.getEmail();


        if (!this.forgotDatabaseBoundary.checkAccount(username, email)) {
            forgotOutputDTO.setStatus("error");
            forgotOutputDTO.setMsg("Thông tin tài khoản không chính xác!");
            this.forgotOutputBoundary.exportError(forgotOutputDTO);
            return;
        }

        String newPassword = this.generateRandomPassword(8);

        this.forgotDatabaseBoundary.updatePassword(username, email, newPassword);
        forgotOutputDTO.setStatus("success");
        forgotOutputDTO.setMsg("Đã đặt lại mật khẩu thành công!");
        forgotOutputDTO.setNewPassword(newPassword);
        this.forgotOutputBoundary.exportResult(forgotOutputDTO);
    }
    
    private boolean verify(ForgotInputDTO forgotInputDTO, ForgotOutputDTO forgotOutputDTO) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        String username = forgotInputDTO.getUsername();
        String email = forgotInputDTO.getEmail();

        try {
            if (username == null || username.isEmpty()) {
                throw new Exception("username,Tên tài khoản không được để trống!");
            }
            if (email == null || email.isEmpty()) {
                throw new Exception("email,Email không được để trống!");
            }
            if (!email.matches(emailRegex)) {
                throw new Exception("email,Email không đúng định dạng!");
            }
        } catch (Exception e) {
            forgotOutputDTO.setStatus("error");
            forgotOutputDTO.setMsg(e.getMessage());
            return false;
        }

        return true;
    }

    public String generateRandomPassword(int length) {
        // Characters allowed in the password
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";
        String allChars = upperCase + lowerCase + digits + specialChars;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each category
        password.append(upperCase.charAt(random.nextInt(upperCase.length())));
        password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Fill the rest of the password length with random characters
        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the password to randomize character positions
        return shuffleString(password.toString());
    }

    private String shuffleString(String input) {
        SecureRandom random = new SecureRandom();
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Swap characters
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
