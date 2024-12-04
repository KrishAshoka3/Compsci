package com.example.part5;

import java.io.Serializable;
import java.time.LocalDate;

public class WorkoutLog implements Serializable {
    private String exerciseName;
    private int sets;
    private int reps;
    private double weight;
    private LocalDate date;

    public WorkoutLog(String exerciseName, int sets, int reps, double weight, LocalDate date) {
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.date = date;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return exerciseName + " - " + sets + "x" + reps + " @ " + weight + "kg on " + date;
    }
}