/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anandaanugrah
 */
public class Pekerjaan {
    private String kode;
    private String nama;
    private int jumlahTugas;
    
    public Pekerjaan(String kode, String nama, int jumlahTugas) {
        this.kode = kode;
        this.nama = nama;
        this.jumlahTugas = jumlahTugas;
    }
    
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getJumlahTugas() { return jumlahTugas; }
    
    public void setKode(String kode) { this.kode = kode; }
    public void setNama(String nama) { this.nama = nama; }
    public void setJumlahTugas(int jumlahTugas) { this.jumlahTugas = jumlahTugas; }
}