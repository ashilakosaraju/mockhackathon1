package com.autoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    // Strict POM Locators
    private By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
    private By proceedBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By commentBox = By.xpath("//textarea[@name='message']");
    private By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");
    
    // Payment specific locators (Using exact names/IDs for stability)
    private By cardName = By.xpath("//input[@name='name_on_card']");
    private By cardNum = By.xpath("//input[@name='card_number']");
    private By cardCvc = By.xpath("//input[@name='cvc']");
    private By expMonth = By.xpath("//input[@name='expiry_month']");
    private By expYear = By.xpath("//input[@name='expiry_year']");
    private By payBtn = By.xpath("//button[@id='submit']");
    private By successMsg = By.xpath("//*[contains(text(),'Order Placed!')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void completePurchase(String name) {
        // 1. Go to Cart
        jsClick(wait.until(ExpectedConditions.elementToBeClickable(cartBtn)));

        // 2. Click Proceed to Checkout
        jsClick(wait.until(ExpectedConditions.elementToBeClickable(proceedBtn)));
        
        // 3. Add comment and click Place Order
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentBox)).sendKeys("HCL Hackathon Order");
        jsClick(wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)));

        // 4. Fill Payment Details (Ensuring visibility before typing)
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardName)).sendKeys(name);
        driver.findElement(cardNum).sendKeys("4111111111111111");
        driver.findElement(cardCvc).sendKeys("123");
        driver.findElement(expMonth).sendKeys("12");
        driver.findElement(expYear).sendKeys("2028");

        // 5. Final Pay and Confirm
        WebElement finalButton = wait.until(ExpectedConditions.elementToBeClickable(payBtn));
        jsClick(finalButton);
    }

    public boolean isOrderConfirmed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}