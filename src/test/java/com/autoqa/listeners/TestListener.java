package com.autoqa.listeners;

import com.autoqa.base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.autoqa.utils.ExtentReportManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentReportManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // FIX: Get the driver instance from the actual test class that failed
        WebDriver driver = null;
        Object testClass = result.getInstance();
        driver = ((BaseTest) testClass).driver; 

        if (driver != null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = result.getMethod().getMethodName() + "_" + timestamp + ".png";
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String path = System.getProperty("user.dir") + "/screenshots/" + fileName;
                FileUtils.copyFile(srcFile, new File(path));
                // Add screenshot to Extent Report
                test.addScreenCaptureFromPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}