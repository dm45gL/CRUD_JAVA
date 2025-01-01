package com.example.crud;

public class User {
    private int idUser;
    private String username;
    private String password;
    private String role;
    private int idDivisi;

    // Constructor
    public User(int idUser, String username, String password, String role, int idDivisi) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = role;
        this.idDivisi = idDivisi;
    }

    // Getters and Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdDivisi() {
        return idDivisi;
    }

    public void setIdDivisi(int idDivisi) {
        this.idDivisi = idDivisi;
    }
}
