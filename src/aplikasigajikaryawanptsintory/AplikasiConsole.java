/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasigajikaryawanptsintory;

import java.util.Scanner;
/**
 *
 * @author anandaanugrah
 */
public class AplikasiConsole {
    
    static Scanner input = new Scanner(System.in);
    static String[] nim = new String[100];
    static String[] nama = new String[100];
    static double[] uts = new double[100];
    static double[] uas = new double[100];
    static double[] nilaiAkhir = new double[100];
    static String[] grade = new String[100];
    static int jumlahData = 0;
    
    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Input Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();
            
            switch (pilihan) {
                case 1: inputData(); break;
                case 2: tampilData(); break;
                case 3: System.out.println("Keluar..."); break;
                default: System.out.println("Pilihan salah!");
            }
        } while (pilihan != 3);
    }
    
    static void inputData() {
        System.out.print("Berapa data yang ingin diinput? ");
        int n = input.nextInt();
        input.nextLine();
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Data ke-" + (jumlahData + 1) + " ---");
            System.out.print("NIM       : ");
            nim[jumlahData] = input.nextLine();
            System.out.print("Nama      : ");
            nama[jumlahData] = input.nextLine();
            System.out.print("Nilai UTS : ");
            uts[jumlahData] = input.nextDouble();
            System.out.print("Nilai UAS : ");
            uas[jumlahData] = input.nextDouble();
            input.nextLine();
            
            nilaiAkhir[jumlahData] = (0.4 * uts[jumlahData]) + (0.6 * uas[jumlahData]);
            grade[jumlahData] = hitungGrade(nilaiAkhir[jumlahData]);
            
            jumlahData++;
        }
        System.out.println("Data berhasil disimpan!");
    }
    
    static String hitungGrade(double nilai) {
        if (nilai >= 85) return "A";
        else if (nilai >= 75) return "B";
        else if (nilai >= 65) return "C";
        else if (nilai >= 50) return "D";
        else return "E";
    }
    
    static void tampilData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data!");
            return;
        }
        
        System.out.println("\n=====================================================================");
        System.out.printf("%-4s %-12s %-15s %-8s %-8s %-8s %-6s%n",
                "No", "NIM", "Nama", "UTS", "UAS", "Akhir", "Grade");
        System.out.println("=====================================================================");
        
        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%-4d %-12s %-15s %-8.1f %-8.1f %-8.2f %-6s%n",
                    (i + 1), nim[i], nama[i], uts[i], uas[i], nilaiAkhir[i], grade[i]);
        }
        System.out.println("=====================================================================");
    }
}