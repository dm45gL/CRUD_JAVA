package com.example.crud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AnggotaDAO {

    private ObservableList<Anggota> anggotaList;

    public AnggotaDAO() {
        anggotaList = FXCollections.observableArrayList();
    }

    public ObservableList<Anggota> getAllAnggota() {
        return anggotaList;
    }

    public void addAnggota(Anggota anggota) {
        anggotaList.add(anggota);
    }

    public void removeAnggota(Anggota anggota) {
        anggotaList.remove(anggota);
    }

    public void updateAnggota(Anggota oldAnggota, Anggota newAnggota) {
        int index = anggotaList.indexOf(oldAnggota);
        if (index != -1) {
            anggotaList.set(index, newAnggota);
        }
    }

    public Anggota findAnggotaById(String id) {
        for (Anggota anggota : anggotaList) {
            if (anggota.getId().equals(id)) {
                return anggota;
            }
        }
        return null;
    }

    public boolean exists(String id) {
        return findAnggotaById(id) != null;
    }
}
