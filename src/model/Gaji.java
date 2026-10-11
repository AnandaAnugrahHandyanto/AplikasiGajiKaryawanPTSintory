package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Gaji {
    private String ktp;
    private String pesan;
    private Object[][] listGaji;
    private final Koneksi koneksi = new Koneksi();
    
    public String getKtp() { return ktp; }
    public void setKtp(String ktp) { this.ktp = ktp; }
    
    public String getPesan() { return pesan; }
    public void setPesan(String pesan) { this.pesan = pesan; }
    
    public Object[][] getListGaji() { return listGaji; }
    public void setListGaji(Object[][] listGaji) { this.listGaji = listGaji; }
    
    public boolean simpan() {
        boolean adaKesalahan = false;
        Connection connection;
        
        if ((connection = koneksi.getConnection()) != null) {
            int jumlahSimpan = 0;
            String SQLStatement;
            PreparedStatement preparedStatement;
            
            try {
                SQLStatement = "DELETE FROM tbgaji WHERE ktp=?";
                preparedStatement = connection.prepareStatement(SQLStatement);
                preparedStatement.setString(1, ktp);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
            }
            
            for (Object[] recGaji : listGaji) {
                try {
                    SQLStatement = "INSERT INTO tbgaji(ktp, kodepekerjaan, gajibersih, gajikotor, tunjangan) VALUES (?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(SQLStatement);
                    preparedStatement.setString(1, ktp);
                    for (int i = 0; i < 4; i++) {
                        preparedStatement.setString(2 + i, recGaji[i].toString());
                    }
                    jumlahSimpan += preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                }
            }
            
            if (jumlahSimpan > 0) {
                adaKesalahan = false;
            } else {
                adaKesalahan = true;
                pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }
        
        return !adaKesalahan;
    }
    
        public boolean baca(String ktp) {
        boolean adaKesalahan = false;
        Connection connection;
        this.ktp = ktp;
        listGaji = null;

        if ((connection = koneksi.getConnection()) != null) {
            String SQLStatement;
            PreparedStatement preparedStatement;
            ResultSet rset;

            try {
                SQLStatement = "SELECT * FROM tbgaji WHERE ktp=?";
                preparedStatement = connection.prepareStatement(
                    SQLStatement,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
                );
                preparedStatement.setString(1, ktp);
                rset = preparedStatement.executeQuery();
                rset.next();
                rset.last();
                listGaji = new Object[rset.getRow()][4];

                rset.first();
                int i = 0;
                do {
                    if (!rset.getString("kodepekerjaan").equals("")) {
                        listGaji[i] = new Object[]{
                            rset.getString("kodepekerjaan"),
                            rset.getObject("gajibersih"),
                            rset.getObject("gajikotor"),
                            rset.getObject("tunjangan")
                        };
                    }
                    i++;
                } while (rset.next());

                if (listGaji.length > 0) {
                    adaKesalahan = false;
                }

                preparedStatement.close();
                rset.close();
                connection.close();
            } catch (SQLException ex) {
                adaKesalahan = true;
                pesan = "Tidak dapat membaca data gaji karyawan\n" + ex.getMessage();
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n" + koneksi.getPesanKesalahan();
        }

        return !adaKesalahan;
    }
}