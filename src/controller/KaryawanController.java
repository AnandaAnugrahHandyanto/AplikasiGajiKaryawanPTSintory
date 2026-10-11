/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import javax.swing.JOptionPane;
import model.Enkripsi;
import model.Karyawan;
import view.FormLihatKaryawan;
import view.FormUtama;

/**
 *
 * @author anandaanugrah
 */
public class KaryawanController {
    private final Karyawan karyawan = new Karyawan();
    private FormLihatKaryawan formLihatKaryawan;
    private final Enkripsi enkripsi = new Enkripsi();
    
    public void simpan(javax.swing.JTextField ktpTextField,
                       javax.swing.JTextField namaTextField,
                       javax.swing.JComboBox ruangComboBox,
                       javax.swing.JPasswordField passwordField) {
        if (!ktpTextField.getText().equals("")) {
            karyawan.setKtp(ktpTextField.getText());
            karyawan.setNama(namaTextField.getText());
            karyawan.setRuang(Integer.parseInt(ruangComboBox.getSelectedItem().toString()));
            
            try {
                String hashedPassword = enkripsi.hashMD5(new String(passwordField.getPassword()));
                karyawan.setPassword(hashedPassword);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, 
                    "Gagal hash password: " + ex.getMessage(), 
                    "Kesalahan", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (karyawan.simpan()) {
                FormUtama.formKaryawan.setKtp("");
                FormUtama.formKaryawan.setNama("");
                FormUtama.formKaryawan.setRuang(1);
                FormUtama.formKaryawan.setPassword("");
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            } else {
                if (karyawan.getPesan().length() > 0) {
                    JOptionPane.showMessageDialog(null, 
                        karyawan.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                "KTP tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tampilkanFormLihatKaryawan() {
        formLihatKaryawan = new FormLihatKaryawan(null, true);
        if (karyawan.bacaData()) {
            formLihatKaryawan.tampilkanData(karyawan.getList());
            formLihatKaryawan.setVisible(true);
            
            if (!formLihatKaryawan.getKtpDipilih().equals("")) {
                if (karyawan.baca(formLihatKaryawan.getKtpDipilih())) {
                    FormUtama.formKaryawan.setKtp(karyawan.getKtp());
                    FormUtama.formKaryawan.setNama(karyawan.getNama());
                    FormUtama.formKaryawan.setRuang(karyawan.getRuang());
                    FormUtama.formKaryawan.setPassword(karyawan.getPassword());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                karyawan.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
}