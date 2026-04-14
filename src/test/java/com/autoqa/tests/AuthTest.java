package com.autoqa.tests;

import com.autoqa.base.BaseTest;
import com.autoqa.pages.AuthPage;
import com.autoqa.pages.ProductPage;
import com.autoqa.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {

    @Test
    public void verifyEndToEndHackathonFlow() {
        AuthPage auth = new AuthPage(driver);
        ProductPage product = new ProductPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        String pwd = prop.getProperty("password");

        // Module 1: Registration
        auth.goToAuthPage();
        auth.fillSignupForm("Dhathri", email, pwd);
        auth.logout();

        // Module 1: Login
        auth.goToAuthPage();
        auth.login(email, pwd);

        // Module 2 & 3: Search & Cart
        product.searchAndAdd("Blue Top");

        // Module 4: Buy/Checkout
        checkout.completePurchase("Dhathri Putty");
        
        // Assert
        Assert.assertTrue(checkout.isOrderConfirmed(), "Order confirmation was not displayed!");
    }
}