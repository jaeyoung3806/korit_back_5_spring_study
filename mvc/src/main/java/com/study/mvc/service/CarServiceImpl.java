package com.study.mvc.service;

import com.study.mvc.repository.CarRepository;
import com.study.mvc.repository.CarRepositoryImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarServiceImpl implements CarService{

    private final String componentName =  "a";

    @Override
    @Qualifier(componentName)
    public String getCarNames() {

        return null;
    }

    @Override
    public int addCar(String carName) {
        return 0;
    }
}
