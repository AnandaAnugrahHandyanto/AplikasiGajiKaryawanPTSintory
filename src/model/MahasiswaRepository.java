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
public class MahasiswaRepository {
    private static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    
    public static void tambah(Mahasiswa m) {
        daftarMahasiswa.add(m);
    }
    
    public static ArrayList<Mahasiswa> getAll() {
        return daftarMahasiswa;
    }
    
    public static Mahasiswa cariByNim(String nim) {
        for (Mahasiswa m : daftarMahasiswa) {
            if (m.getNim().equals(nim)) {
                return m;
            }
        }
        return null;
    }
    
    public static boolean hapus(String nim) {
        Mahasiswa m = cariByNim(nim);
        if (m != null) {
            daftarMahasiswa.remove(m);
            return true;
        }
        return false;
    }
    
    public static void clear() {
        daftarMahasiswa.clear();
    }
}