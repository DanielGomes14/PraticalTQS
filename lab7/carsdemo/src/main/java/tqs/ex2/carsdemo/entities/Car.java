package tqs.ex2.carsdemo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue
    private Long carId;

    private String maker;
    private String model;

    public Car(){
    }
    public  Car(String model, String maker){
        this.model = model;
        this.maker = maker;
    }
}
