package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    public static void createDriver() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64/chromedriver.exe");
        threadLocalDriver.set(new ChromeDriver());
        threadLocalDriver.get().manage().window().maximize();
        System.out.println("Thread: " + Thread.currentThread().getId() + " - Setting up browser");
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void quitDriver() {
        if (threadLocalDriver.get() != null) {
            threadLocalDriver.get().quit();
            threadLocalDriver.remove();
            System.out.println("Thread: " + Thread.currentThread().getId() + " - Closing browser");
        }
    }
}
