package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
        cars.add(new Car("Лада", "Веста", 2018));
        cars.add(new Car("Лада", "Гранта", 2015));
        cars.add(new Car("Лада", "Приора", 2017));
        cars.add(new Car("Лада", "XRAY", 2021));
        cars.add(new Car("Лада", "Ларгус", 2023));
    }

    public List<Car> listCars(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
