package com.example.crud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseHelper {

    // Fungsi untuk mendapatkan koneksi ke database
    public static Connection getConnection() throws SQLException {
        try {
            // Gantilah dengan kredensial database Anda
            String url = "jdbc:mysql://localhost:3306/ulum"; // URL database
            String user = "root"; // Nama pengguna database
            String password = ""; // Kata sandi pengguna database
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            throw e;
        }
    }

    // Fungsi untuk mendapatkan semua anggota dari database
    public static ObservableList<Anggota> getAllAnggota() {
        ObservableList<Anggota> anggotaList = FXCollections.observableArrayList();

        // Ambil data dari database
        String query = "SELECT * FROM anggota";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String id = "A" + rs.getInt("id");  // ID yang diawali dengan 'A'
                String nama = rs.getString("nama");
                String divisi = rs.getString("divisi");
                String email = rs.getString("email");
                String noTelepon = rs.getString("noTelepon");

                // Tambahkan anggota ke dalam ObservableList
                Anggota anggota = new Anggota(id, nama, divisi, email, noTelepon);
                anggotaList.add(anggota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return anggotaList;
    }

    // Fungsi untuk menambahkan anggota baru ke database
    public static void addAnggota(Anggota anggota) {
        String query = "INSERT INTO anggota (nama, divisi, email, noTelepon) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, anggota.getNama());
            stmt.setString(2, anggota.getDivisi());
            stmt.setString(3, anggota.getEmail());
            stmt.setString(4, anggota.getNoTelepon());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
