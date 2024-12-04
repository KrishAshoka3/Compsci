package com.example.part5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    private String name;
    private List<WorkoutLog> workoutLogs;

    public Client(String name) {
        this.name = name;
        this.workoutLogs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addWorkoutLog(WorkoutLog log) {
        workoutLogs.add(log);
    }

    public List<WorkoutLog> getWorkoutLogs() {
        return workoutLogs;
    }
}