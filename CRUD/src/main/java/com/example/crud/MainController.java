package com.example.crud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    private Label current_form;

    @FXML
    private Label greet_name;

    @FXML
    private Label user_id;

    @FXML
    private TextField namaField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField noTeleponField;

    @FXML
    private ComboBox<String> divisiComboBox;

    @FXML
    private Button addAnggota_addbtn;

    @FXML
    private Button addAnggota_clearbtn;

    @FXML
    private Button addAnggota_removebtn;

    @FXML
    private TableView<Anggota> addAnggota_tableview;

    @FXML
    private TableColumn<Anggota, String> idAnggotaProperty;

    @FXML
    private TableColumn<Anggota, String> addAnggota_col_nama;

    @FXML
    private TableColumn<Anggota, String> addAnggota_col_divisi;

    @FXML
    private TableColumn<Anggota, String> addAnggota_col_email;

    @FXML
    private TableColumn<Anggota, String> addAnggota_col_telepon;

    private ObservableList<Anggota> anggotaList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize combo box options
        divisiComboBox.setItems(FXCollections.observableArrayList("Informatika", "Sistem Informasi", "PGSD", "PAI"));

        // Setup table columns
        idAnggotaProperty.setCellValueFactory(new PropertyValueFactory<>("id"));
        addAnggota_col_nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        addAnggota_col_divisi.setCellValueFactory(new PropertyValueFactory<>("divisi"));
        addAnggota_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        addAnggota_col_telepon.setCellValueFactory(new PropertyValueFactory<>("noTelepon"));

        // Bind table to data list
        addAnggota_tableview.setItems(anggotaList);

        // Setup selection listener for table
        addAnggota_tableview.setOnMouseClicked(this::handleRowSelection);
    }

    @FXML
    private void handleAddAnggota(ActionEvent event) {
        String nama = namaField.getText();
        String email = emailField.getText();
        String noTelepon = noTeleponField.getText();
        String divisi = divisiComboBox.getValue();

        if (nama.isEmpty() || email.isEmpty() || noTelepon.isEmpty() || divisi == null) {
            showAlert("Input Tidak Lengkap", "Semua field harus diisi", Alert.AlertType.WARNING);
            return;
        }

        Anggota anggota = new Anggota(generateId(), nama, divisi, email, noTelepon);
        anggotaList.add(anggota);
        clearForm();
        showAlert("Berhasil", "Anggota berhasil ditambahkan", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void handleClear(ActionEvent event) {
        clearForm();
    }

    @FXML
    private void handleRemove(ActionEvent event) {
        Anggota selectedAnggota = addAnggota_tableview.getSelectionModel().getSelectedItem();
        if (selectedAnggota != null) {
            anggotaList.remove(selectedAnggota);
            clearForm();
            showAlert("Berhasil", "Anggota berhasil dihapus", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Tidak Ada Pilihan", "Pilih anggota yang ingin dihapus", Alert.AlertType.WARNING);
        }
    }

    private void handleRowSelection(MouseEvent event) {
        Anggota selectedAnggota = addAnggota_tableview.getSelectionModel().getSelectedItem();
        if (selectedAnggota != null) {
            namaField.setText(selectedAnggota.getNama());
            emailField.setText(selectedAnggota.getEmail());
            noTeleponField.setText(selectedAnggota.getNoTelepon());
            divisiComboBox.setValue(selectedAnggota.getDivisi());
        }
    }

    private void clearForm() {
        namaField.clear();
        emailField.clear();
        noTeleponField.clear();
        divisiComboBox.getSelectionModel().clearSelection();
        addAnggota_tableview.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private String generateId() {
        return "A" + (anggotaList.size() + 1);
    }
}
