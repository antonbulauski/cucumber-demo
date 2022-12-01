package com.cucumber.demo.steps;

import com.cucumber.demo.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuSteps {

    private final HomePage homePage = new HomePage();

    @When("the user opens Cucumber website")
    public void openCucumberWebsite() {
        homePage.openCucumberWebsite();
    }

    @When("the user click on the Allow all cookies button")
    public void clickAllowAllCookiesButton() {
        homePage.allowAllCookiesButton().click();
    }

    @When("the user clicks on the {string} section")
    public void clickOnSpecificMenuSection(String linkText) {
        homePage.menuSection(linkText).click();
    }

    @Then("there are {int} child menu items displayed")
    public void verifyItemsQuantity(int expectedSize) {
        assertThat(homePage.getMenuChildItemTitles())
                .as("Columns quantity is not as expected")
                .hasSize(expectedSize);
    }
}
