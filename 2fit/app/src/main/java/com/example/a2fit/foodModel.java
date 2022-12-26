package com.example.a2fit;

public class foodModel {
    private Integer bfast;
    private Integer lunch;
    private Integer dinner;

    // set constructors

    public foodModel(Integer bfast, Integer lunch, Integer dinner) {
        this.bfast = bfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }


    //  used tostring method to print class object's contents

    @Override
    public String toString() {
        return "foodModel{" +
                "bfast='" + bfast + '\'' +
                ", lunch='" + lunch + '\'' +
                ", dinner='" + dinner + '\'' +
                '}';
    }


    // set getters & setters


    public Integer getBfast() {
        return bfast;
    }


    public void setBfast(Integer bfast) {
        this.bfast = bfast;
    }

    public Integer getLunch() {
        return lunch;
    }

    public void setLunch(Integer lunch) {
        this.lunch = lunch;
    }

    public Integer getDinner() {
        return dinner;
    }

    public void setDinner(Integer dinner) {
        this.dinner = dinner;
    }
}