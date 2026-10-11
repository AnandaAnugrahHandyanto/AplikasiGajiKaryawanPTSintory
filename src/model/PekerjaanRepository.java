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
public class PekerjaanRepository {
    private static ArrayList<Pekerjaan> daftarPekerjaan = new ArrayList<>();
    
    public static void tambah(Pekerjaan pekerjaan) {
        daftarPekerjaan.add(pekerjaan);
    }
    
    public static ArrayList<Pekerjaan> getAll() {
        return daftarPekerjaan;
    }
    
    public static Pekerjaan cariByKode(String kode) {
        for (Pekerjaan p : daftarPekerjaan) {
            if (p.getKode().equals(kode)) {
                return p;
            }
        }
        return null;
    }
    
    public static boolean hapus(String kode) {
        Pekerjaan p = cariByKode(kode);
        if (p != null) {
            daftarPekerjaan.remove(p);
            return true;
        }
        return false;
    }
    
    public static void update(Pekerjaan pekerjaan) {
        Pekerjaan existing = cariByKode(pekerjaan.getKode());
        if (existing != null) {
            existing.setNama(pekerjaan.getNama());
            existing.setJumlahTugas(pekerjaan.getJumlahTugas());
        }
    }
}