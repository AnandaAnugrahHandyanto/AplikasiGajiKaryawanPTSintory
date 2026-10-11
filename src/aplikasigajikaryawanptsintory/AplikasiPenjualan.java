/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasigajikaryawanptsintory;

import model.Barang;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author anandaanugrah
 */
public class AplikasiPenjualan {
    
    static ArrayList<Barang> daftarBarang = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== APLIKASI PENJUALAN ===");
            System.out.println("1. Input Barang");
            System.out.println("2. Tampil Data Penjualan");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();
            
            switch (pilihan) {
                case 1: inputBarang(); break;
                case 2: tampilData(); break;
                case 3: System.out.println("Terima kasih!"); break;
                default: System.out.println("Pilihan salah!");
            }
        } while (pilihan != 3);
    }
    
    static void inputBarang() {
        System.out.print("Kode Barang   : ");
        String kode = input.nextLine();
        System.out.print("Nama Barang   : ");
        String nama = input.nextLine();
        System.out.print("Harga         : ");
        double harga = input.nextDouble();
        System.out.print("Jumlah        : ");
        int jumlah = input.nextInt();
        input.nextLine();
        
        Barang barang = new Barang(kode, nama, harga, jumlah);
        daftarBarang.add(barang);
        System.out.println("Data berhasil disimpan!");
    }
    
    static void tampilData() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data!");
            return;
        }
        
        System.out.println("\n=================================================================");
        System.out.printf("%-4s %-10s %-15s %-10s %-8s %-12s%n",
                "No", "Kode", "Nama", "Harga", "Jumlah", "Total");
        System.out.println("=================================================================");
        
        double grandTotal = 0;
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang b = daftarBarang.get(i);
            System.out.printf("%-4d %-10s %-15s %-10.0f %-8d %-12.0f%n",
                    (i + 1), b.getKodeBarang(), b.getNamaBarang(),
                    b.getHarga(), b.getJumlah(), b.getTotal());
            grandTotal += b.getTotal();
        }
        System.out.println("=================================================================");
        System.out.printf("Grand Total: %.0f%n", grandTotal);
    }
}