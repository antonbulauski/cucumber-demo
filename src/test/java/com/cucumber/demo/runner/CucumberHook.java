package com.cucumber.demo.runner;

import com.cucumber.demo.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHook {

    @Before
    public void setupDriver() {
        DriverManager.setupDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
