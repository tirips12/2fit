package com.example.a2fit;

public class exerciseModel {
    private String ExerciseType;
    private Integer BurnedKcal;

    // set constructors

    public exerciseModel(String ExerciseType, Integer BurnedKcal) {
        this.ExerciseType = ExerciseType;
        this.BurnedKcal = BurnedKcal;
    }


    //  used tostring method to print class object's contents


    @Override
    public String toString() {
        return "exerciseModel{" +
                "ExerciseType='" + ExerciseType + '\'' +
                ", BurnedKcal='" + BurnedKcal + '\'' +
                '}';
    }

    // set getters & setters
    public Integer getBurnedKcal() {
        return BurnedKcal;
    }

    public void setBurnedKcal(Integer burnedKcal) {
        BurnedKcal = burnedKcal;
    }

    public String getExerciseType() {
        return ExerciseType;
    }

    public void setExerciseType(String exerciseType) {
        ExerciseType = exerciseType;
    }


}