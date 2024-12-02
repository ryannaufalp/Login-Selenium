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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

import static org.testng.Assert.*;

public class ValidLoginSteps {
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

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        driver = DriverManager.getDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        wait = new WebDriverWait(driver, Duration.ofMillis(10));
        System.out.println("Thread: " + Thread.currentThread().getId() + " - Executing steps");
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        driver.findElement(By.id("submit")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        By textMessage = By.xpath("//*[@id=\"loop-container\"]/div/article/div[1]/h1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(textMessage));
        WebElement textElement = driver.findElement(textMessage);
        String text = textElement.getText();

        assertEquals(text, "Logged In Successfully");

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

}
