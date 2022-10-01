package com.restapp.util;

import com.restapp.models.Measurement;
import com.restapp.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {
    private final SensorsService sensorsService;

    @Autowired
    public MeasurementValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return this.getClass().equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;

        if(measurement.getTemperature() > 100 || measurement.getTemperature() < -100){
            errors.rejectValue("temperature", "", "Temperature should be greater than -100 " +
                    "but less than 100");
        }
        if(sensorsService.getSensorByName(measurement.getSensor().getName()).isEmpty()){
            errors.rejectValue("sensor", "", "There is no sensor with that name");
        }
    }
}