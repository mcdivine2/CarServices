package com.example.myapplication;

public class Cars {
    private int id;
    private String name;
    private String model;
    private String year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    // Corrected getCar method to return car details
    public String getCar() {
        return "Car Id "+ id + " Name " + name + " Model " + model + " Year " + year;
    }

    // Corrected setCar method to set car properties
    public void setCar(int id,String name, String model, String year) {
        this.id=id;
        this.name = name;
        this.model = model;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
