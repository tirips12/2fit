package com.example.a2fit;

public class sleepModel {
    private Integer SleepTime;

    // set constructors

    public sleepModel(Integer SleepTime) {
        this.SleepTime = SleepTime;
    }


    //  used tostring method to print class object's contents

    @Override
    public String toString() {
        return "sleepModel{" +
                "SleepTime=" + SleepTime +
                '}';
    }


    // set getters & setters


    public Integer getSleepTime() {
        return SleepTime;
    }

    public void setSleepTime(Integer sleepTime) {
        SleepTime = sleepTime;
    }
}