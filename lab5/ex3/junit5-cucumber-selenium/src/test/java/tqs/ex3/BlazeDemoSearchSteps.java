package tqs.ex3;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsNot.not;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BlazeDemoSearchSteps {

    private WebDriver driver;

    @When("I navigate to {string}")
    public void navigateTo(String url) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @And("I want to travel from {string} to {string}")
    public void travelFromTo(String from, String to){
        driver.manage().window().setSize(new Dimension(973, 723));
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = '" + from + "']" )).click();
        }
        driver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = '" + to + "']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @And("I want to my flight from {string}")
    public void travelAirline(String airline){
        assertThat(driver.findElement(
                By.cssSelector("tr:nth-child(5) > td:nth-child(4)")).getText(),
                is(airline));
        driver.findElement(By.cssSelector("tr:nth-child(5) .btn")).click();
    }
    @And("I Enter my Personal Information")
    public void enterInformation(){
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("João Silva");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("123 Main St");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Anytown");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("sdlfgçs");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("121334");
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("234423354");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("João Silva");
        driver.findElement(By.cssSelector(".checkbox")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
    @Then("The Flight Final Price Should be {int}")
    public void confirmPrice(int price){
        assertThat(driver.findElement(
                By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText(),
                is(price+ " USD"));
    }

}
