/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anandaanugrah
 */
public class Mahasiswa {
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String jurusan;
    private int semester;
    private double biaya;
    private double nilaiKehadiran;
    private double nilaiTugas;
    private double nilaiUTS;
    private double nilaiUAS;
    private double nilaiPemrograman;
    private String grade;
    
    public Mahasiswa() {
    }
    
    public Mahasiswa(String nim, String nama, String jenisKelamin, 
                     String jurusan, int semester, double biaya,
                     double nilaiKehadiran, double nilaiTugas, 
                     double nilaiUTS, double nilaiUAS) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.jurusan = jurusan;
        this.semester = semester;
        this.biaya = biaya;
        this.nilaiKehadiran = nilaiKehadiran;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
        hitungNilaiAkhir();
    }
    
    public void hitungNilaiAkhir() {
        this.nilaiPemrograman = (0.1 * nilaiKehadiran) 
                              + (0.2 * nilaiTugas) 
                              + (0.3 * nilaiUTS) 
                              + (0.4 * nilaiUAS);
        this.grade = hitungGrade(nilaiPemrograman);
    }
    
    private String hitungGrade(double nilai) {
        if (nilai >= 85) return "A";
        else if (nilai >= 75) return "B";
        else if (nilai >= 65) return "C";
        else if (nilai >= 50) return "D";
        else return "E";
    }
    
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    
    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }
    
    public String getJurusan() { return jurusan; }
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }
    
    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }
    
    public double getBiaya() { return biaya; }
    public void setBiaya(double biaya) { this.biaya = biaya; }
    
    public double getNilaiKehadiran() { return nilaiKehadiran; }
    public void setNilaiKehadiran(double nilaiKehadiran) { this.nilaiKehadiran = nilaiKehadiran; }
    
    public double getNilaiTugas() { return nilaiTugas; }
    public void setNilaiTugas(double nilaiTugas) { this.nilaiTugas = nilaiTugas; }
    
    public double getNilaiUTS() { return nilaiUTS; }
    public void setNilaiUTS(double nilaiUTS) { this.nilaiUTS = nilaiUTS; }
    
    public double getNilaiUAS() { return nilaiUAS; }
    public void setNilaiUAS(double nilaiUAS) { this.nilaiUAS = nilaiUAS; }
    
    public double getNilaiPemrograman() { return nilaiPemrograman; }
    public String getGrade() { return grade; }
}