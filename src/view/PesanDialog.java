/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author anandaanugrah
 */
public class PesanDialog {
    public int tampilkanPilihan(String pesan, String judul, Object[] pilihan) {
        return JOptionPane.showOptionDialog(
            null,
            pesan,
            judul,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            pilihan,
            pilihan[0]
        );
    }
    
    public void tampilkanPesan(String pesan, String judul, int tipe) {
        JOptionPane.showMessageDialog(null, pesan, judul, tipe);
    }
}