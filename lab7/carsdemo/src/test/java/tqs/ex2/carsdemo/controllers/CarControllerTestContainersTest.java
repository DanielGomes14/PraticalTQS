package tqs.ex2.carsdemo.controllers;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import io.restassured.RestAssured;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import tqs.ex2.carsdemo.JsonUtil;
import tqs.ex2.carsdemo.entities.Car;
import tqs.ex2.carsdemo.repositories.CarRepository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class CarControllerTestContainersTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private CarRepository repository;

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer("postgres")
            .withUsername("admin")
            .withPassword("password")
            .withDatabaseName("test");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }

    @Test
     void whenPostCar_thenCreateCar() throws Exception {
        Car car_1 = new Car("I8", "BMW");
        repository.saveAndFlush(car_1);

        RestAssured.given().header("Content-Type", "application/json")
                .body(JsonUtil.toJson(car_1))
                .post(getBaseUrl()+"/api/v1/cars")
                .then().assertThat().statusCode(201)
                .and().body("maker", equalTo("BMW"))
                .and().body("model", equalTo("I8"));
    }

    @Test
     void testGetValidCarDetails() {
        Car mclaren = new Car("I8", "BMW");
        repository.saveAndFlush(mclaren);

        RestAssured.given().when()
                .get(getBaseUrl()+"/api/v1/cars/"+mclaren.getCarId().intValue())
                .then().assertThat().statusCode(200)
                .and().body("maker", equalTo("BMW"))
                .and().body("model", equalTo("I8"));
    }

    @Test
     void testGetInvalidCarDetails() {
        RestAssured.given().when()
                .get(getBaseUrl()+"/api/v1/cars/99")
                .then().assertThat().statusCode(404);
    }

    @Test
     void testGetAllCars() {
        createTestCar("I8", "BMW");
        createTestCar("A4", "Audi");

        RestAssured.given().when()
                .get(getBaseUrl()+"/api/v1/cars")
                .then().assertThat().statusCode(200)
                .and().body("", hasSize(2))
                .and().body("model[0]", is("I8"))
                .and().body("maker[0]",is("BMW"))
                .and().body("model[1]", is("A4"))
                .and().body("maker[1]",is("Audi"));
    }


    private void createTestCar(String model, String maker) {
        Car car = new Car(model, maker);
        repository.saveAndFlush(car);
    }

    public String getBaseUrl() {
        return "http://localhost:"+randomServerPort;
    }
}