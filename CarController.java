package com.Cartrader.Richinternet.controller;

import com.Cartrader.Richinternet.dto.Car;
import com.Cartrader.Richinternet.exception.CarNotFoundException;
import com.Cartrader.Richinternet.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class CarController {
    @Autowired
    private
    CarRepository carRepository;

    @GetMapping("cars")
    public Page<Car> getAllCars(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @GetMapping("cars/{carId}")
    public Car getAllCars(@PathVariable int carId) {
        Optional<Car> result = carRepository.findById(carId);
        return result.get();
    }

    @DeleteMapping("cars/{carId}")
    public void deleteCarById(@PathVariable int carId) {
        try {
            carRepository.deleteById(carId);
        } catch (EmptyResultDataAccessException e) {
            throw new CarNotFoundException("Unable to delete car with id: "+ carId);
        }
    }

    @PostMapping("cars/")
    public ResponseEntity createCar(@RequestBody Car newCar) {
        Car car = carRepository.save(newCar);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(car.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("cars/")
    public ResponseEntity updateCar(@RequestBody Car newCar) {
        Car car;
        if(newCar.getId() != null) {
            car = carRepository.save(newCar);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(car.getId()).toUri();
            return ResponseEntity.created(location).build();
        } else
        {
            car = carRepository.save(newCar);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
}


