/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Karyawan;
import model.KaryawanRepository;
import model.Pekerjaan;
import model.PekerjaanRepository;
import view.FormLihatPekerjaan;

/**
 *
 * @author anandaanugrah
 */
public class GajiController {
    
    private static ArrayList<Object[]> dataGaji = new ArrayList<>();
    
    public void tampilkanFormLihatPekerjaan() {
        FormLihatPekerjaan formLihat = new FormLihatPekerjaan(null, true);
        
        ArrayList<Pekerjaan> list = PekerjaanRepository.getAll();
        Object[][] data = new Object[list.size()][2];
        
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getKode();
            data[i][1] = list.get(i).getNama();
        }
        
        formLihat.tampilkanData(data);
        formLihat.setVisible(true);
    }
    
    public Pekerjaan cariPekerjaan(String kode) {
        return PekerjaanRepository.cariByKode(kode);
    }

    public void simpan(JTextField ktpTextField, JTable gajiTable) {
        String ktp = ktpTextField.getText().trim();
        
        if (ktp.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, 
                "KTP harus diisi!");
            return;
        }
        
        Karyawan karyawan = KaryawanRepository.cariByKtp(ktp);
        if (karyawan == null) {
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Karyawan dengan KTP " + ktp + " tidak ditemukan!");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) gajiTable.getModel();
        int rowCount = model.getRowCount();
        
        if (rowCount == 0) {
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Belum ada data gaji di tabel!");
            return;
        }
        
        dataGaji.clear();
        for (int i = 0; i < rowCount; i++) {
            Object kode = model.getValueAt(i, 0);
            Object nama = model.getValueAt(i, 1);
            Object gajiBersih = model.getValueAt(i, 2);
            Object gajiKotor = model.getValueAt(i, 3);
            Object tunjangan = model.getValueAt(i, 4);
            
            if (kode == null || kode.toString().isEmpty()) continue;
            
            dataGaji.add(new Object[]{
                ktp, kode, nama, gajiBersih, gajiKotor, tunjangan
            });
        }
        
        javax.swing.JOptionPane.showMessageDialog(null, 
            "Data gaji berhasil disimpan!\nTotal: " + dataGaji.size() + " baris");
    }
    
    public static ArrayList<Object[]> getDataGaji() {
        return dataGaji;
    }
}
