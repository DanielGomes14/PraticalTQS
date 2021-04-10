import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SeleniumJupiter.class)
class BlazeDemoRefactorTest {
    private WebDriver driver;
    private static final String BLAZE_URL = "https://blazedemo.com/";

    public BlazeDemoRefactorTest(FirefoxDriver driver){
        this.driver = driver;
    }

    @Test
    public void blazedemotest () {
        driver.get(BLAZE_URL);
        driver.findElement(By.cssSelector("form")).click();
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'Boston']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(3)")).click();
        driver.findElement(By.cssSelector("form")).click();
        driver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'London']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertThat(driver.getTitle(), is("BlazeDemo - reserve"));
        driver.findElement(By.cssSelector("tr:nth-child(5) .btn")).click();
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("Your flight from TLV to SFO has been reserved."));
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
        assertThat(driver.getTitle(), is("BlazeDemo Confirmation"));
    }
}