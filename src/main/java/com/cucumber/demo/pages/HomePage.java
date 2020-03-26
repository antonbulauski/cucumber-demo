package com.cucumber.demo.pages;

import com.cucumber.demo.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String CUCUMBER_URL = "https://cucumber.io/";
    private static final String MENU_LINK_PATTERN = "//*[contains(@class,'nav-link') and contains(text(),'%s')]";
    private static final String CHILD_MENU_LINK_PATTERN = "//*[contains(@class,'menu-docs')]//*[contains(@class,'item item-al')]";

    public void openCucumberWebsite() {
        DriverManager.getDriver().get(CUCUMBER_URL);
    }

    public WebElement menuSection(String linkText) {
        return findElement(By.xpath(format(MENU_LINK_PATTERN, linkText)));
    }

    public List<String> getMenuChildItemTitles() {
        return getTextsFromWebElements(By.xpath(CHILD_MENU_LINK_PATTERN));
    }
}
