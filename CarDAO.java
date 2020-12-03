package com.Cartrader.Richinternet.dao;
import com.Cartrader.Richinternet.dto.Car;
import com.Cartrader.Richinternet.exception.CarNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Component
public class CarDAO {
    private List<Car> carList = new ArrayList(Arrays.asList(new Car(0,
            "BMW BEAST",
            100, "Beast",
            "blue", 2009,
            200,
            40000,
            "Good")

    ));
    public List<Car> findAll() {
        return carList;
    }

    public Optional<Object> findById(int id) {
        Car foundCar = findCar(id);
        if(foundCar !=null)
            return Optional.ofNullable(foundCar);
        throw new CarNotFoundException("Unable to find car with id : " + id);
    }

    public Car findCar(int carId) {
        Car foundCar = null;
        for(Car car : carList) {
            if(car.getId() == carId) {
                foundCar = car;
                break;
            }
        }
        return foundCar;
    }

    public void deleteCar(int id) {
        Car foundCar = findCar(id);
        if(foundCar !=null) {
            carList.remove(foundCar);
        } else {
            throw new CarNotFoundException("Unable to find car with id : " + id);
        }
    }

    public void createWine(Car newCar) {
        carList.add(newCar);
    }

    public boolean updateCar(Car car) {
        boolean updated = true;
        Car foundCar = findCar(car.getId());
        if(foundCar != null){
            int index = carList.indexOf(foundCar);
            carList.remove(index);
            carList.add(index, car);
        } else {
            carList.add(car);
            updated = false;
        }
        return updated;
    }
}
