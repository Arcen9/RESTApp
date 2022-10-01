package com.restapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MeasurementDTO {
    @Size(min = -100, max = 100, message = "Temperature should be greater than -100, less than 100")
    private double temperature;

    @NotNull
    private boolean Raining;

    @NotNull
    private SensorDTO sensor;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isRaining() {
        return Raining;
    }

    public void setRaining(boolean raining) {
        Raining = raining;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
