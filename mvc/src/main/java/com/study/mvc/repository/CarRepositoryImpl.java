package com.study.mvc.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CarRepository")
public class CarRepositoryImpl implements CarRepository{

    @Override
    public List<String> getCarNames() {
        return List.of("아반떼", "쏘나타");
    }

    @Override
    public int insertCar(String carNames) {
        System.out.println("등록된 차량: " + carNames);
        return 1;
    }
}
