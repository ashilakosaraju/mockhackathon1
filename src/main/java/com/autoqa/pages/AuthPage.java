package com.autoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AuthPage extends BasePage {

    private By loginNavLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By signupName = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    private By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    private By mrRadio = By.id("id_gender1");
    private By passwordField = By.id("password");
    private By days = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By address1 = By.id("address1");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobile = By.id("mobile_number");
    private By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    private By continueBtn = By.xpath("//a[@data-qa='continue-button']");
    private By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");
    private By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private By loginPass = By.xpath("//input[@data-qa='login-password']");
    private By loginBtn = By.xpath("//button[@data-qa='login-button']");

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public void goToAuthPage() {
        clickElement(loginNavLink);
    }

    public void fillSignupForm(String name, String email, String pwd) {
        waitForElement(signupName).sendKeys(name);
        driver.findElement(signupEmail).sendKeys(email);
        clickElement(signupBtn);
        
        waitForElement(mrRadio).click();
        driver.findElement(passwordField).sendKeys(pwd);
        new Select(driver.findElement(days)).selectByVisibleText("15");
        new Select(driver.findElement(months)).selectByVisibleText("May");
        new Select(driver.findElement(years)).selectByVisibleText("1995");
        
        driver.findElement(firstName).sendKeys(name);
        driver.findElement(lastName).sendKeys("User");
        driver.findElement(address1).sendKeys("123 Automation St");
        new Select(driver.findElement(country)).selectByVisibleText("India");
        driver.findElement(state).sendKeys("Telangana");
        driver.findElement(city).sendKeys("Hyderabad");
        driver.findElement(zipcode).sendKeys("500001");
        driver.findElement(mobile).sendKeys("9876543210");
        
        clickElement(createAccountBtn);
        clickElement(continueBtn);
    }

    public void logout() {
        clickElement(logoutBtn);
    }

    public void login(String email, String pwd) {
        waitForElement(loginEmail).sendKeys(email);
        driver.findElement(loginPass).sendKeys(pwd);
        clickElement(loginBtn);
    }
}