package com.autoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthPage extends BasePage {

    private By signupName = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    private By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    
    private By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private By loginPwd = By.xpath("//input[@data-qa='login-password']");
    private By loginBtn = By.xpath("//button[@data-qa='login-button']");
    
    private By pwdField = By.id("password");
    private By fName = By.id("first_name");
    private By lName = By.id("last_name");
    private By addr = By.id("address1");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zip = By.id("zipcode");
    private By mobile = By.id("mobile_number");
    private By createAccBtn = By.xpath("//button[@data-qa='create-account']");
    private By continueBtn = By.xpath("//a[@data-qa='continue-button']");
    private By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public void goToAuthPage() {
        driver.get("https://automationexercise.com/login");
    }

    public void fillSignupForm(String name, String email, String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupName)).sendKeys(name);
        driver.findElement(signupEmail).sendKeys(email);
        jsClick(driver.findElement(signupBtn));

        wait.until(ExpectedConditions.visibilityOfElementLocated(pwdField)).sendKeys(pwd);
        driver.findElement(fName).sendKeys(name);
        driver.findElement(lName).sendKeys("User");
        driver.findElement(addr).sendKeys("123 ABC Street");
        driver.findElement(state).sendKeys("TS");
        driver.findElement(city).sendKeys("Hyderabad");
        driver.findElement(zip).sendKeys("501010");
        driver.findElement(mobile).sendKeys("9123456789");
        
        jsClick(wait.until(ExpectedConditions.elementToBeClickable(createAccBtn)));
        jsClick(wait.until(ExpectedConditions.elementToBeClickable(continueBtn)));
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail)).sendKeys(email);
        driver.findElement(loginPwd).sendKeys(password);
        jsClick(wait.until(ExpectedConditions.elementToBeClickable(loginBtn)));
    }

    public void logout() {
        jsClick(wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)));
    }

    private void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}