/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplikasigajikaryawanptsintory;

import view.FormUtama;
/**
 *
 * @author anandaanugrah
 */
public class AplikasiGajiKaryawanPTSintory {
    public static final FormUtama formUtama = new FormUtama();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new view.FormLogin().setVisible(true);
        });
    }  
}
