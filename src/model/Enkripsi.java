/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.MessageDigest;

/**
 *
 * @author anandaanugrah
 */
public class Enkripsi {
    
    /**
     * Method untuk hash password dengan MD5
     * @param input String yang akan di-hash
     * @return String hash MD5 (32 karakter hex)
     * @throws Exception kalau algoritma tidak tersedia
     */
    public String hashMD5(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md.digest(input.getBytes("UTF-8"));
        
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        
        return hexString.toString();
    }
}
