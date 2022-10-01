package com.restapp.util;


import com.restapp.models.Sensor;
import com.restapp.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {

    private final SensorsService sensorsService;

    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return this.getClass().equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;

        if(sensorsService.getSensorByName(sensor.getName()).isPresent())
            errors.rejectValue("name", "", "Sensor with this name already exists");

        if(sensor.getName().length() < 3 || sensor.getName().length() > 30)
            errors.rejectValue("name", "", "Sensor's name should contain more than 3 " +
                    "letters but less then 30");
    }
}
