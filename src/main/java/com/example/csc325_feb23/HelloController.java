package com.example.csc325_feb23;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {

    @FXML private TableView<Information> tableView;
    @FXML private TableColumn<Information, String> firstNameColumn;
    @FXML private TableColumn<Information, String> lastNameColumn;
    @FXML private TableColumn<Information, String> emailColumn;
    @FXML private TableColumn<Information, String> departmentColumn;
    @FXML private TableColumn<Information, Integer> idColumn;
    @FXML private TableColumn<Information, String> majorColumn;

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    @FXML private TextField departmentField;
    @FXML private TextField majorField;
    @FXML private TextField imageURLField;

    @FXML private Button saveButton;

    private Image defaultProfileImage;

    @FXML
    public void initialize() {
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        saveButton.setVisible(false);

        defaultProfileImage = profileImageView.getImage();

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel == null) return;

            String url = newSel.getImageUrl();
            if (url == null || url.isBlank()) return;

            profileImageView.setImage(new Image(url, true));
        });

        tableView.getItems().addListener((javafx.collections.ListChangeListener<Information>) c -> {
        if (tableView.getItems().isEmpty()) {
            profileImageView.setImage(defaultProfileImage);
        }
        });
    }


    int i=1;
    @FXML
    private void handleAdd() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String department = departmentField.getText();
        String major = majorField.getText();
        String imageURL = imageURLField.getText();

        tableView.getItems().add(new Information(i, firstName, lastName, department, major, email, imageURL));
        i+=1;

        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        departmentField.clear();
        majorField.clear();
        imageURLField.clear();


    }

    @FXML
    private void handleClear() {
        tableView.getItems().clear();
        i=1;
    }

    @FXML
    private void handleDelete() {
        int lastIndex = tableView.getItems().size()-1;

        if (lastIndex >= 0) {
            tableView.getItems().remove(lastIndex);
            i-=1;
        }
    }

    @FXML
    private void handleEdit() {
        Information selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) return;

        firstNameField.setText(selected.getFirstName());
        lastNameField.setText(selected.getLastName());
        emailField.setText(selected.getEmail());
        departmentField.setText(selected.getDepartment());
        majorField.setText(selected.getMajor());
        imageURLField.setText(selected.getImageUrl());

        saveButton.setVisible(true);
    }

    @FXML
    private void handleSave() {
        Information selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        selected.setFirstName(firstNameField.getText());
        selected.setLastName(lastNameField.getText());
        selected.setEmail(emailField.getText());
        selected.setDepartment(departmentField.getText());
        selected.setMajor(majorField.getText());
        selected.setImageUrl(imageURLField.getText());

        tableView.refresh();

        saveButton.setVisible(false);

        firstNameField.clear();
        lastNameField.clear();
        majorField.clear();
        emailField.clear();
        departmentField.clear();

    }

    @FXML private ImageView profileImageView;

    @FXML
    private void handleRowSelection() {
        Information selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        Image image = new Image(selected.getImageUrl());
        profileImageView.setImage(image);
    }
}