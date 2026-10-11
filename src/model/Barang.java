/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anandaanugrah
 */
public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private double harga;
    private int jumlah;
    
    public Barang(String kodeBarang, String namaBarang, double harga, int jumlah) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.jumlah = jumlah;
    }
    
    public String getKodeBarang() { return kodeBarang; }
    public String getNamaBarang() { return namaBarang; }
    public double getHarga() { return harga; }
    public int getJumlah() { return jumlah; }
    
    public double getTotal() {
        return harga * jumlah;
    }
}