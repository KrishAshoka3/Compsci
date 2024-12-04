package com.example.part5;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.time.LocalDate;

public class MainController {
    @FXML
    private ListView<Client> clientListView;
    @FXML
    private TextField clientNameField;
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
    @FXML
    private ListView<String> logListView;

    @FXML
    public void addClient() {
        String clientName = clientNameField.getText();
        if (clientName != null && !clientName.isEmpty()) {
            Client newClient = new Client(clientName);
            clientListView.getItems().add(newClient);
            clientNameField.clear();
        }
    }

    public void addClient(String clientName) {
        if (clientName != null && !clientName.isEmpty()) {
            Client newClient = new Client(clientName);
            clientListView.getItems().add(newClient);
        }
    }

    @FXML
    private void addWorkoutLog() {
        if (clientListView.getItems().isEmpty()) {
            showAlert("No Client", "Please add a client before adding a workout.");
            return;
        }

        try {
            String exerciseName = exerciseNameField.getText();
            int sets = Integer.parseInt(setsField.getText());
            int reps = Integer.parseInt(repsField.getText());
            double weight = Double.parseDouble(weightField.getText());
            LocalDate date = dateField.getValue();

            if (!exerciseName.isEmpty() && date != null) {
                WorkoutLog newLog = new WorkoutLog(exerciseName, sets, reps, weight, date);
                workoutListView.getItems().add(newLog);
                logListView.getItems().add(newLog.toString());
                exerciseNameField.clear();
                setsField.clear();
                repsField.clear();
                weightField.clear();
                dateField.setValue(null);
            }
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid numbers for sets, reps, and weight.");
        }
    }

    @FXML
    private void showGraph() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/part5/graph.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        GraphController controller = loader.getController();
        Client currentClient = getCurrentClient();
        controller.setClientData(currentClient);
        stage.show();
    }

    private Client getCurrentClient() {
        return new Client("Example Client");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}