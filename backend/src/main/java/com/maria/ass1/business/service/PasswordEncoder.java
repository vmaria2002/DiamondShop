package com.maria.ass1.business.service;
import java.security.MessageDigest;
public class PasswordEncoder {
    private String password;

    public PasswordEncoder(String password) {

        this.password = password;
    }

    public String getEncodedPassword() {

        try{
            if(null == password){

                throw new NullPasswordException("Password is NULL!");
            }
        }
        catch (NullPasswordException ex){

            return null;
        }

        return encodePassword(password);
    }

    private String encodePassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
