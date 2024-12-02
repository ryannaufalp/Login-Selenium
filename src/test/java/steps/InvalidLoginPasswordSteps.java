package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

import static org.testng.Assert.*;

public class InvalidLoginPasswordSteps {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @Before
    public void setUp() {
        if (DriverManager.getDriver() == null) {
            DriverManager.createDriver();
        }
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Given("the user is on the login page invalid password")
    public void userIsOnLoginPage() {
        driver = DriverManager.getDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        wait = new WebDriverWait(driver, Duration.ofMillis(10));
        System.out.println("Thread: " + Thread.currentThread().getId() + " - Executing steps");
    }


    @When("the user enters invalid credentials password")
    public void theUserEntersInvalidCredentialsPassword() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("incorrectPassword");
    }


    @And("clicks the login button invalid password")
    public void clicksTheLoginButton() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("an error message should be displayed for password incorrect")
    public void anErrorMessageShouldBeDisplayedforPasswordIncorrect() {
        By errorTag = By.id("error");
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorTag));
        String errorMessage = driver.findElement(errorTag).getText();
        assertEquals("Your password is invalid!", errorMessage);
    }

}
