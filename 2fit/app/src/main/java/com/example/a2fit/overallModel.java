package com.example.a2fit;

public class overallModel {
    private Integer KCAL_INTAKE;
    private Integer T_WEIGHT;
    private Integer BMI;

    public overallModel(Integer KCAL_INTAKE, Integer T_WEIGHT, Integer BMI) {
        this.KCAL_INTAKE = KCAL_INTAKE;
        this.T_WEIGHT = T_WEIGHT;
        this.BMI = BMI;
    }

    //  used tostring method to print class object's contents

    @Override
    public String toString() {
        return "overallModel{" +
                "KCAL_INTAKE=" + KCAL_INTAKE +
                ", T_WEIGHT=" + T_WEIGHT +
                ", BMI=" + BMI +
                '}';
    }

    // set getters & setters

    public Integer getKCAL_INTAKE() {
        return KCAL_INTAKE;
    }

    public void setKCAL_INTAKE(Integer KCAL_INTAKE) {
        this.KCAL_INTAKE = KCAL_INTAKE;
    }

    public Integer getT_WEIGHT() {
        return T_WEIGHT;
    }

    public void setT_WEIGHT(Integer t_WEIGHT) {
        T_WEIGHT = t_WEIGHT;
    }

    public Integer getBMI() {
        return BMI;
    }

    public void setBMI(Integer BMI) {
        this.BMI = BMI;
    }
}



