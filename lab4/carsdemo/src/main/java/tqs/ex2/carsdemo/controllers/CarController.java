package tqs.ex2.carsdemo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqs.ex2.carsdemo.entities.Car;
import tqs.ex2.carsdemo.services.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
            Car carsaved =  carService.saveCar(car);
            return new ResponseEntity<>(carsaved, HttpStatus.CREATED);
    }

    @GetMapping("/cars")
    public ResponseEntity<?> getCars(){
        List cars = carService.getAllCars();
        return new ResponseEntity<>(cars,HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<?> getCar(@PathVariable long id){
        Car car = carService.getCarDetails(id).orElse(null);
        return new ResponseEntity<>(car,HttpStatus.OK);
    }


}
