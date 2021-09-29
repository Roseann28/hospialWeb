package com.cohort.nine.basicMeasurements;

public class BasicMeasurements {
    private int height;
    private int weight;
    private String bloddPressure;
    private int id;

    public BasicMeasurements(int id,int height, int weight, String bloddPressure) {
        this.height = height;
        this.weight = weight;
        this.bloddPressure = bloddPressure;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBloddPressure() {
        return bloddPressure;
    }

    public void setBloddPressure(String bloddPressure) {
        this.bloddPressure = bloddPressure;
    }
}
