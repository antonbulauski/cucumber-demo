package com.cucumber.demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        tags = "@smoke",
        glue = "com.cucumber.demo",
        features = "src/test/resources/features")
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
