package com.autoqa.tests;

import com.autoqa.base.BaseTest;
import com.autoqa.pages.RegisterPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyRegistrationFlow() {
       
        RegisterPage registerPage = new RegisterPage(driver);
        
        String email = prop.getProperty("username");
        registerPage.enterSignupDetails("Test User", email);
        
        System.out.println("Registration Step 1 initiated for: " + email);
    }
}