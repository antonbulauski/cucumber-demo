package com.cucumber.demo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Optional;

public final class DriverManager {

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(20);
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setupDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT);
        driver.manage().timeouts().pageLoadTimeout(WAIT_TIMEOUT);
        threadLocalDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(driver -> {
            driver.quit();
            threadLocalDriver.remove();
        });
    }
}
