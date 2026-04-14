package com.autoqa.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.autoqa.driver.DriverFactory;
import com.autoqa.utils.ConfigReader;

public class BaseTest {
    public WebDriver driver;
    public Properties prop;
    public ConfigReader cr;
    public DriverFactory df;

    @BeforeMethod
    public void setup() {
        System.out.println("LOG: Initializing Browser Setup...");
        cr = new ConfigReader();
        prop = cr.init_prop();
        df = new DriverFactory();
        driver = df.init_driver(prop.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        // Keeping browser open for debugging
        System.out.println("LOG: Test execution finished. Browser remains open.");
    }
}