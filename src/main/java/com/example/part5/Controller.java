package com.example.part5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class Controller {
    @FXML
    private TextField clientNameField;

    @FXML
    private ListView<Client> clientListView;

    @FXML
    private TextField exerciseNameField;
    @FXML
    private TextField setsField;
    @FXML
    private TextField repsField;
    @FXML
    private TextField weightField;
    @FXML
    private DatePicker dateField;
    @FXML
    private ListView<WorkoutLog> workoutListView;

    private ObservableList<Client> clients;

    public void initialize() {
        clients = FXCollections.observableArrayList();
        clientListView.setItems(clients);
    }

    @FXML
    private void addClient() {
        String name = clientNameField.getText();
        if (!name.isEmpty()) {
            clients.add(new Client(name));
            clientNameField.clear();
        }
    }

    @FXML
    private void addWorkoutLog() {
        Client selectedClient = clientListView.getSelectionModel().getSelectedItem();
        if (selectedClient != null) {
            try {
                String exerciseName = exerciseNameField.getText();
                int sets = Integer.parseInt(setsField.getText());
                int reps = Integer.parseInt(repsField.getText());
                double weight = Double.parseDouble(weightField.getText());
                LocalDate date = dateField.getValue();

                WorkoutLog log = new WorkoutLog(exerciseName, sets, reps, weight, date);
                selectedClient.addWorkoutLog(log);
                workoutListView.setItems(FXCollections.observableArrayList(selectedClient.getWorkoutLogs()));

                exerciseNameField.clear();
                setsField.clear();
                repsField.clear();
                weightField.clear();
                dateField.setValue(null);
            } catch (NumberFormatException e) {
                showError("Please enter valid numbers for sets, reps, and weight.");
            }
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }
}
