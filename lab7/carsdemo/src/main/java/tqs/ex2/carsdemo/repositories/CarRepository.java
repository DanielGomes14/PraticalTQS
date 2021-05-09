package tqs.ex2.carsdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tqs.ex2.carsdemo.entities.Car;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {
    //Find By Id is already implemented, no need to override
    // same applies to findAll()
}

