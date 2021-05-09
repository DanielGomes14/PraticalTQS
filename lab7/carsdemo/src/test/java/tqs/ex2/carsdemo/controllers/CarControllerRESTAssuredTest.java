package tqs.ex2.carsdemo.controllers;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import tqs.ex2.carsdemo.JsonUtil;
import tqs.ex2.carsdemo.entities.Car;
import tqs.ex2.carsdemo.services.CarService;
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;

@WebMvcTest
class CarControllerRESTAssuredTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService service;

    @BeforeEach
    public void setUp(){
        RestAssuredMockMvc.mockMvc(mvc);
    }

    @Test
    void whenValidInput_thenCreateCar() throws IOException {
        Car bmw = new Car("I8","BMW");
        when(service.saveCar(Mockito.any())).thenReturn(bmw);
        RestAssuredMockMvc.given().header("Content-Type", "application/json")
                .body(JsonUtil.toJson(bmw))
                .post("api/v1/cars")
                .then().assertThat().statusCode(201)
                .and().body("model", is(bmw.getModel()))
                .and().body("maker", is(bmw.getMaker()));
        verify(service, times(1)).saveCar(bmw);

    }

    @Test
    void whenGetCars_thenReturnCars(){
        Car car_1 = new Car("I8", "BMW");
        Car car_2 = new Car("A4", "Audi");
        List<Car> cars = Arrays.asList(car_1,car_2);
        when(service.getAllCars()).thenReturn(cars);
        RestAssuredMockMvc.given().when()
                .get("api/v1/cars")
                .then().assertThat().statusCode(200)
                .and().body("",hasSize(2))
                .and().body("model[0]", is(car_1.getModel()))
                .and().body("maker[0]",is(car_1.getMaker()))
                .and().body("model[1]", is(car_2.getModel()))
                .and().body("maker[1]",is(car_2.getMaker()));

        verify(service, times(1)).getAllCars();
    }

    @Test
    void whenGetCar_thenReturnCar(){
        Car car_1 = new Car("I8", "BMW");
        car_1.setCarId(1L);
        when(service.getCarDetails(car_1.getCarId())).thenReturn(Optional.of(car_1));
        RestAssuredMockMvc.given().when()
                .get("/api/v1/cars/1").then()
                .statusCode(200)
                .and().body("maker",is(car_1.getMaker()))
                .and().body("model",is(car_1.getModel()));
        verify(service, times(1)).getCarDetails(car_1.getCarId());

    }

    @Test
    void whenInvalidCar_thenReturnCar(){
        RestAssuredMockMvc.given().when()
                .get("/api/v1/cars/99")
                .then().assertThat().statusCode(404);
        verify(service, times(1)).getCarDetails(99L);

    }


}
