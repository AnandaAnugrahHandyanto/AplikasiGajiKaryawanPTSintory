/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.Pekerjaan;
import view.FormLihatPekerjaan;
import view.FormUtama;

/**
 *
 * @author anandaanugrah
 */
public class PekerjaanController {
    private final Pekerjaan pekerjaan = new Pekerjaan();
    private FormLihatPekerjaan formLihatPekerjaan;
    
    public void simpan(javax.swing.JTextField kodePekerjaanTextField,
                       javax.swing.JTextField namaPekerjaanTextField,
                       javax.swing.JComboBox jumlahTugasComboBox) {
        if (!kodePekerjaanTextField.getText().equals("")) {
            pekerjaan.setKodePekerjaan(kodePekerjaanTextField.getText());
            pekerjaan.setNamaPekerjaan(namaPekerjaanTextField.getText());
            pekerjaan.setJumlahTugas(Integer.parseInt(
                jumlahTugasComboBox.getSelectedItem().toString()));
            
            if (pekerjaan.simpan()) {
                FormUtama.formPekerjaan.setKodePekerjaan("");
                FormUtama.formPekerjaan.setNamaPekerjaan("");
                FormUtama.formPekerjaan.setJumlahTugas(1);
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            } else {
                if (pekerjaan.getPesan().length() > 0) {
                    JOptionPane.showMessageDialog(null, 
                        pekerjaan.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                "Kode pekerjaan tidak boleh kosong", "Kesalahan", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public void cari(javax.swing.JTextField kodePekerjaanTextField) {
        if (!kodePekerjaanTextField.getText().equals("")) {
            if (pekerjaan.baca(kodePekerjaanTextField.getText())) {
                FormUtama.formPekerjaan.setNamaPekerjaan(pekerjaan.getNamaPekerjaan());
                FormUtama.formPekerjaan.setJumlahTugas(pekerjaan.getJumlahTugas());
            } else {
                FormUtama.formPekerjaan.setNamaPekerjaan("");
                FormUtama.formPekerjaan.setJumlahTugas(1);
                javax.swing.JOptionPane.showMessageDialog(null, 
                    pekerjaan.getPesan(), "Kesalahan", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Kode pekerjaan tidak boleh kosong", "Kesalahan", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public void hapus(javax.swing.JTextField kodePekerjaanTextField) {
        String kode = kodePekerjaanTextField.getText().trim();
        if (kode.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Masukkan Kode Pekerjaan!");
            return;
        }

        int konfirmasi = javax.swing.JOptionPane.showConfirmDialog(null, 
            "Yakin hapus Kode " + kode + "?", "Konfirmasi", 
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (konfirmasi == javax.swing.JOptionPane.YES_OPTION) {
            if (pekerjaan.hapus(kode)) {
                javax.swing.JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                FormUtama.formPekerjaan.setKodePekerjaan("");
                FormUtama.formPekerjaan.setNamaPekerjaan("");
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, pekerjaan.getPesan());
            }
        }
    }
    public void tampilkanDaftar() {
        formLihatPekerjaan = new FormLihatPekerjaan(null, true);
        if (pekerjaan.bacaData()) {
            formLihatPekerjaan.tampilkanData(pekerjaan.getList());
            formLihatPekerjaan.setVisible(true);
            
            if (!formLihatPekerjaan.getKodePekerjaanDipilih().equals("")) {
                if (pekerjaan.baca(formLihatPekerjaan.getKodePekerjaanDipilih())) {
                    FormUtama.formPekerjaan.setKodePekerjaan(pekerjaan.getKodePekerjaan());
                    FormUtama.formPekerjaan.setNamaPekerjaan(pekerjaan.getNamaPekerjaan());
                    FormUtama.formPekerjaan.setJumlahTugas(pekerjaan.getJumlahTugas());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                pekerjaan.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
}