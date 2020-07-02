package service;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private List<Car> carList = new ArrayList<>();

    private CarService() {
    }

    private static class CarServiceHolder {
        private static final CarService holder_instance = new CarService();
    }

    public static CarService getInstance(){
        return CarServiceHolder.holder_instance;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public List<Car> getCarList() {
        if (carList.size() >= 3)
            return new ArrayList<>(carList);
        else return null;
    }
}
