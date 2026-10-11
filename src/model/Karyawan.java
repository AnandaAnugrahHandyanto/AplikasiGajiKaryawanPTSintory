/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anandaanugrah
 */
public class Karyawan {
    private String ktp;
    private String nama;
    private int ruang;
    private String password;
    
    public Karyawan(String ktp, String nama, int ruang, String password) {
        this.ktp = ktp;
        this.nama = nama;
        this.ruang = ruang;
        this.password = password;
    }
    
    public String getKtp() { return ktp; }
    public String getNama() { return nama; }
    public int getRuang() { return ruang; }
    public String getPassword() { return password; }
    
    public void setKtp(String ktp) { this.ktp = ktp; }
    public void setNama(String nama) { this.nama = nama; }
    public void setRuang(int ruang) { this.ruang = ruang; }
    public void setPassword(String password) { this.password = password; }
}