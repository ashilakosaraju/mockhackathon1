package com.autoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Properties;
import com.autoqa.utils.ConfigReader;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties prop;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        ConfigReader cr = new ConfigReader();
        this.prop = cr.init_prop();
        int timeoutValue = Integer.parseInt(prop.getProperty("timeout"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutValue));
    }

    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}