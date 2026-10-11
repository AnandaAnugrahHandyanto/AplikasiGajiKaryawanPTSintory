/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author anandaanugrah
 */
public class KaryawanRepository {
    private static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
    
    public static void tambah(Karyawan karyawan) {
        daftarKaryawan.add(karyawan);
    }
    
    public static ArrayList<Karyawan> getAll() {
        return daftarKaryawan;
    }
    
    public static Karyawan cariByKtp(String ktp) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getKtp().equals(ktp)) {
                return k;
            }
        }
        return null;
    }
    
    public static boolean hapus(String ktp) {
        Karyawan k = cariByKtp(ktp);
        if (k != null) {
            daftarKaryawan.remove(k);
            return true;
        }
        return false;
    }
    
    public static void update(Karyawan karyawan) {
        Karyawan existing = cariByKtp(karyawan.getKtp());
        if (existing != null) {
            existing.setNama(karyawan.getNama());
            existing.setRuang(karyawan.getRuang());
            existing.setPassword(karyawan.getPassword());
        }
    }
}