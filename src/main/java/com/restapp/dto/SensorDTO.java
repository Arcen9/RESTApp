package com.restapp.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SensorDTO {
    @Size(min = 3, max = 30, message = "Sensor's name should have more than 3 letters, less than 30")
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
