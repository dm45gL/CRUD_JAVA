package com.example.crud;

public class Anggota {
    private String id;
    private String nama;
    private String divisi;
    private String email;
    private String noTelepon;

    public Anggota(String id, String nama, String divisi, String email, String noTelepon) {
        this.id = id;
        this.nama = nama;
        this.divisi = divisi;
        this.email = email;
        this.noTelepon = noTelepon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    @Override
    public String toString() {
        return "Anggota{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", divisi='" + divisi + '\'' +
                ", email='" + email + '\'' +
                ", noTelepon='" + noTelepon + '\'' +
                '}';
    }
}
