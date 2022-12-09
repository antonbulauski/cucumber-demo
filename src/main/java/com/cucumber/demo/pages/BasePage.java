package com.cucumber.demo.pages;

import com.cucumber.demo.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(60);
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
    }

    public WebElement findElement(By by) {
        return this.driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return this.driver.findElements(by);
    }

    public WebElement waitForElement(By by) {
        return new WebDriverWait(this.driver, WAIT_TIMEOUT).until(visibilityOfElementLocated(by));
    }

    public List<String> getTextsFromWebElements(By by) {
        return findElements(by).stream().map(WebElement::getText).collect(toList());
    }
}
