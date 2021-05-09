package tqs.ex1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
class TodosTest {

    @BeforeEach
    void setUp(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    @Test
    void whenGetAllTodos_returnOk(){
        get("/todos")
                .then()
                .assertThat().statusCode(200);
    }
    @Test
    void whenGetAllTodos_verifyTitle(){
        get("/todos")
                .then()
                .assertThat()
                .body("[3].title",equalTo("et porro tempora"));
    }

    @Test
    void whenGetAllTodos_verifyBodyContent() {
        get("/todos")
                .then()
                .assertThat()
                .body("id", hasItems(198,199));
    }
}