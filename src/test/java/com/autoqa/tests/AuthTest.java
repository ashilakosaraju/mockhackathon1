package com.autoqa.tests;

import com.autoqa.base.BaseTest;
import com.autoqa.pages.AuthPage;
import com.autoqa.pages.ProductPage;
import com.autoqa.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {

    // 1. DATA PROVIDER for Login (Requirement 4.2)
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            { "invalid_user_hcl1@mail.com", "WrongPass123" },
            { "invalid_user_hcl2@mail.com", "WrongPass456" }
        };
    }

    // 2. POSITIVE E2E TEST
    @Test(priority = 1)
    public void verifyEndToEndHackathonFlow() {
        AuthPage auth = new AuthPage(driver);
        ProductPage product = new ProductPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        String email = "hcl_user" + System.currentTimeMillis() + "@gmail.com";
        String pwd = prop.getProperty("password");

        auth.goToAuthPage();
        auth.fillSignupForm("Ashila", email, pwd);
        auth.logout();

        auth.goToAuthPage();
        auth.login(email, pwd);

        product.searchAndAdd("Blue Top");

        checkout.completePurchase("Kosaraju Ashila");
        Assert.assertTrue(checkout.isOrderConfirmed(), "Order confirmation was not displayed!");
    }

    // 3. DATA-DRIVEN NEGATIVE TEST (Requirement 4.2 & 3.5)
    @Test(priority = 2, dataProvider = "loginData")
    public void verifyLoginWithInvalidCredentials(String userEmail, String userPwd) {
        AuthPage auth = new AuthPage(driver);
        auth.goToAuthPage();
        
        System.out.println(">>> Testing Invalid Login for: " + userEmail);
        auth.login(userEmail, userPwd);
        
        String currentUrl = driver.getCurrentUrl();
        boolean isStillOnAuthPage = currentUrl.contains("login") || currentUrl.contains("signup");
        
        Assert.assertTrue(isStillOnAuthPage, "System allowed login with invalid credentials!");
    }
}