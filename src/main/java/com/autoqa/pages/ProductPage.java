package com.autoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By productsLink = By.xpath("//a[@href='/products']");
    private By searchBox = By.id("search_product");
    private By searchBtn = By.id("submit_search");
    private By addToCart = By.xpath("(//a[text()='Add to cart'])[1]");
    private By viewCart = By.xpath("//u[text()='View Cart']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void searchAndAdd(String item) {
        clickElement(productsLink);
        waitForElement(searchBox).sendKeys(item);
        clickElement(searchBtn);
        clickElement(addToCart);
        clickElement(viewCart);
    }
}