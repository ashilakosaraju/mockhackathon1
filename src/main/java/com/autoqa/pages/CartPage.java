package com.autoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
    private By cartItems = By.xpath("//tr[contains(@id,'product-')]");
    private By deleteItem = By.className("cart_quantity_delete");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        clickElement(cartBtn);
    }

    public int getCartCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeItem() {
        clickElement(deleteItem);
    }
}