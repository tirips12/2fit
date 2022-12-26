package com.example.a2fit;

public class UserModel {
    private String name;
    private String surname;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Integer t_weight;
    private Boolean isMale;
    private Boolean isFemale;
    private Integer p_id;

    // set constructors

    public UserModel(String name, String surname, Integer age, Integer height, Integer weight, Integer t_weight, Boolean isMale, Boolean isFemale, Integer p_id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.t_weight = t_weight;
        this.isMale = isMale;
        this.isFemale = isFemale;
        this.p_id = p_id;
    }




    //  used tostring method to print class object's contents


    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", t_weight=" + t_weight +
                ", isMale=" + isMale +
                ", isFemale=" + isFemale +
                ", p_id=" + p_id +
                '}';
    }

    // set getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getT_weight() {
        return t_weight;
    }

    public void setT_weight(Integer t_weight) {
        this.t_weight = t_weight;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public Boolean getFemale() {
        return isFemale;
    }

    public void setFemale(Boolean female) {
        isFemale = female;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }
}
