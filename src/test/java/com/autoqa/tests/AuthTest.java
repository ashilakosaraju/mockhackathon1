package com.autoqa.tests;

import com.autoqa.base.BaseTest;
import com.autoqa.pages.AuthPage;
import com.autoqa.pages.ProductPage;
import com.autoqa.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {

    @Test(priority = 1)
    public void verifyEndToEndHackathonFlow() {
        AuthPage auth = new AuthPage(driver);
        ProductPage product = new ProductPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        String email = "hcl_user" + System.currentTimeMillis() + "@gmail.com";
        String pwd = prop.getProperty("password");

        auth.goToAuthPage();
        auth.fillSignupForm("Dhathri", email, pwd);
        auth.logout();

        auth.goToAuthPage();
        auth.login(email, pwd);

        product.searchAndAdd("Blue Top");

        checkout.completePurchase("Dhathri Putty");
        Assert.assertTrue(checkout.isOrderConfirmed(), "Order confirmation was not displayed!");
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {
        AuthPage auth = new AuthPage(driver);
        auth.goToAuthPage();
        
        // Testing negative scenario
        auth.login("non_existent_user_hcl@mail.com", "WrongPass123");
        
        // If login fails, we should still be on the login page
        String currentUrl = driver.getCurrentUrl();
        boolean isStillOnAuthPage = currentUrl.contains("login") || currentUrl.contains("signup");
        
        Assert.assertTrue(isStillOnAuthPage, "System incorrectly allowed login with invalid credentials!");
    }
}