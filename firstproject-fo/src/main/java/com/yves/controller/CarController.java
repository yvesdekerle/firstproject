package com.yves.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yves.dto.CarDto;
import com.yves.service.CarService;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<CarDto> getAllCars() {
        return carService.findAll();
    }
    
    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getNoteById(@PathVariable(value = "id") Long carId) {
        CarDto car = carService.findOne(carId);
        if(car == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(car);
    }
    
    @GetMapping("/cars/n/{id}")
    public CarDto getNote(@PathVariable(value = "id") Long carId) {
        return carService.findOne(carId);
    }
   
}
