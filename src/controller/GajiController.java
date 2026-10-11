/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.Karyawan;
import model.Pekerjaan;
import model.Gaji;
import view.FormLihatKaryawan;
import view.FormLihatPekerjaan;
import view.FormUtama;

/**
 *
 * @author anandaanugrah
 */
public class GajiController {
    private final Karyawan karyawan = new Karyawan();
    private final Pekerjaan pekerjaan = new Pekerjaan();
    private final Gaji gaji = new Gaji();
    private FormLihatKaryawan formLihatKaryawan;
    private FormLihatPekerjaan formLihatPekerjaan;
    
    public void cariKaryawan(javax.swing.JTextField ktp) {
        if (!ktp.getText().equals("")) {
            if (karyawan.baca(ktp.getText())) {
                FormUtama.formGaji.setNama(karyawan.getNama());
                FormUtama.formGaji.setRuang(Integer.toString(karyawan.getRuang()));
                FormUtama.formGaji.clearGajiTable();
                
                if (gaji.baca(ktp.getText())) {
                    Object[][] listGaji = gaji.getListGaji();
                    FormUtama.formGaji.clearGajiTable();
                    if (listGaji.length > 0) {
                        for (int i = 0; i < listGaji.length; i++) {
                            if (!((String) listGaji[i][0]).equals("")) {
                                String namaPekerjaan = "";
                                if (pekerjaan.baca((String) listGaji[i][0])) {
                                    namaPekerjaan = pekerjaan.getNamaPekerjaan();
                                }
                                FormUtama.formGaji.setTambahGaji(new Object[]{
                                    listGaji[i][0], namaPekerjaan,
                                    listGaji[i][1], listGaji[i][2], listGaji[i][3]
                                });
                            }
                        }
                    } else {
                        FormUtama.formGaji.setTambahGaji(new Object[]{});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, karyawan.getPesan(), 
                    "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "KTP tidak boleh kosong", 
                "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tampilkanFormLihatKaryawan() {
formLihatKaryawan = new FormLihatKaryawan(null, true);
    if (karyawan.bacaData()) {
        formLihatKaryawan.tampilkanData(karyawan.getList());
        formLihatKaryawan.setVisible(true);
        
        if (!formLihatKaryawan.getKtpDipilih().equals("")) {
            if (karyawan.baca(formLihatKaryawan.getKtpDipilih())) {
                FormUtama.formGaji.setKtp(karyawan.getKtp());
                FormUtama.formGaji.setNama(karyawan.getNama());
                FormUtama.formGaji.setRuang(Integer.toString(karyawan.getRuang()));
                FormUtama.formGaji.clearGajiTable();
                
                if (gaji.baca(formLihatKaryawan.getKtpDipilih())) {
                    Object[][] listGaji = gaji.getListGaji();
                    FormUtama.formGaji.clearGajiTable();
                    if (listGaji != null && listGaji.length > 0) {
                        for (int i = 0; i < listGaji.length; i++) {
                            if (listGaji[i][0] != null && !listGaji[i][0].toString().equals("")) {
                                String namaPekerjaan = "";
                                if (pekerjaan.baca(listGaji[i][0].toString())) {
                                    namaPekerjaan = pekerjaan.getNamaPekerjaan();
                                }
                                FormUtama.formGaji.setTambahGaji(new Object[]{
                                    listGaji[i][0], namaPekerjaan,
                                    listGaji[i][1], listGaji[i][2], listGaji[i][3]
                                });
                            }
                        }
                    }
                }
            }
        }
    } else {
        javax.swing.JOptionPane.showMessageDialog(null, 
            karyawan.getPesan(), "Kesalahan", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    }
    
    public void tampilkanFormLihatPekerjaan() {
        formLihatPekerjaan = new FormLihatPekerjaan(null, true);
        if (pekerjaan.bacaData()) {
            formLihatPekerjaan.tampilkanData(pekerjaan.getList());
            formLihatPekerjaan.setVisible(true);
            
            if (!formLihatPekerjaan.getKodePekerjaanDipilih().equals("")) {
                if (pekerjaan.baca(formLihatPekerjaan.getKodePekerjaanDipilih())) {
                    FormUtama.formGaji.setTambahGaji(new Object[]{
                        pekerjaan.getKodePekerjaan(),
                        pekerjaan.getNamaPekerjaan(), "", "", ""
                    });
                }
            }
        }
    }
    
    public void cariPekerjaan(String kodePekerjaan) {
        if (pekerjaan.baca(kodePekerjaan)) {
            FormUtama.formGaji.setNamaPekerjaan(pekerjaan.getNamaPekerjaan());
        } else {
            FormUtama.formGaji.setNamaPekerjaan("");
            FormUtama.formGaji.hapusGaji();
        }
    }
}