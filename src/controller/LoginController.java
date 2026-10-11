/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import javax.swing.JOptionPane;
import model.Enkripsi;
import model.Karyawan;
import view.FormLogin;
/**
 *
 * @author anandaanugrah
 */
public class LoginController {
    private final Karyawan karyawan = new Karyawan();
    private final Enkripsi enkripsi = new Enkripsi();
    
    public boolean validasi(javax.swing.JTextField userIdTextField, 
                            javax.swing.JPasswordField passwordField) {
        boolean valid = false, userIdSalah = false;
        String hashedInputPassword = "";
        
        if (!userIdTextField.getText().equals("")) {
            if (karyawan.baca(userIdTextField.getText())) {
                try {
                    hashedInputPassword = enkripsi.hashMD5(new String(passwordField.getPassword()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, 
                        "Gagal hash password: " + ex.getMessage(), 
                        "Kesalahan", 
                        JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                
                if (karyawan.getPassword().equalsIgnoreCase(hashedInputPassword)) {
                    valid = true;
                    FormLogin.tipe = "Karyawan";
                } else {
                    userIdSalah = true;
                }
            } else {
                userIdSalah = true;
            }
        } else {
            userIdSalah = true;
        }
        
        if (!valid) {
            if (userIdSalah) {
                JOptionPane.showMessageDialog(null, 
                    "User Id atau password salah", 
                    "Kesalahan", 
                    JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                    karyawan.getPesan(), 
                    "Kesalahan", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return valid;
    }
}