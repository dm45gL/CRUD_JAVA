package com.example.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Fungsi untuk menambah user
    public static void addUser(User user) {
        String query = "INSERT INTO User (username, password, role, id_divisi) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setInt(4, user.getIdDivisi());
            stmt.executeUpdate();
            System.out.println("User berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fungsi untuk mengambil semua data user
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM User";
        try (Connection connection = DatabaseHelper.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int idUser = rs.getInt("id_user");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                int idDivisi = rs.getInt("id_divisi");
                users.add(new User(idUser, username, password, role, idDivisi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Fungsi untuk mengupdate data user
    public static void updateUser(User user) {
        String query = "UPDATE User SET username = ?, password = ?, role = ?, id_divisi = ? WHERE id_user = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setInt(4, user.getIdDivisi());
            stmt.setInt(5, user.getIdUser());
            stmt.executeUpdate();
            System.out.println("User berhasil diupdate.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fungsi untuk menghapus user
    public static void deleteUser(int idUser) {
        String query = "DELETE FROM User WHERE id_user = ?";
        try (Connection connection =DatabaseHelper.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idUser);
            stmt.executeUpdate();
            System.out.println("User berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
