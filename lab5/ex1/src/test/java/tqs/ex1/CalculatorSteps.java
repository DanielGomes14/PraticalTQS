package tqs.ex1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorSteps {

    private Calculator calculator;

    @Given("a calculator I just turned on$")
    public void startup(){
        calculator = new Calculator();
    }
    @When("I add {int} and {int}")
    public void add(int num1, int num2){
        calculator.push(num1);
        calculator.push(num2);
        calculator.push("+");
    }
    @When("I subtract {int} to {int}")
    public void subtract(int num1, int num2){
        calculator.push(num1);
        calculator.push(num2);
        calculator.push("-");
    }
    @Then("the result is {double}")
    public  void result(double expected){
        assertEquals(expected,calculator.value());
    }

}