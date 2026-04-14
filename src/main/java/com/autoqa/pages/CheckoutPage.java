package com.autoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private By proceedBtn = By.xpath("//a[text()='Proceed To Checkout']");
    private By messageBox = By.name("message");
    private By placeOrder = By.xpath("//a[text()='Place Order']");
    
    // Payment Locators
    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expMonth = By.name("expiry_month");
    private By expYear = By.name("expiry_year");
    private By payBtn = By.id("submit");
    private By successText = By.xpath("//b[text()='Order Placed!']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void completePurchase(String name) {
        clickElement(proceedBtn);
        waitForElement(messageBox).sendKeys("Hackathon Order");
        clickElement(placeOrder);
        
        waitForElement(nameOnCard).sendKeys(name);
        driver.findElement(cardNumber).sendKeys("424242424242");
        driver.findElement(cvc).sendKeys("311");
        driver.findElement(expMonth).sendKeys("12");
        driver.findElement(expYear).sendKeys("2030");
        clickElement(payBtn);
    }

    public boolean isOrderConfirmed() {
        return waitForElement(successText).isDisplayed();
    }
}