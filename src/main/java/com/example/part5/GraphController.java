package com.example.part5;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GraphController {
    @FXML
    private LineChart<Number, Number> lineChart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    public void setClientData(Client client) {
        xAxis.setLabel("Time (hours)");
        yAxis.setLabel("Weight (kg)");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(client.getName());

        // Assuming you have a method to get workout logs for the client
        for (WorkoutLog log : client.getWorkoutLogs()) {
            double timeInHours = log.getDate().atStartOfDay().getHour(); // Example conversion
            series.getData().add(new XYChart.Data<>(timeInHours, log.getWeight()));
        }

        lineChart.getData().add(series);
    }
}