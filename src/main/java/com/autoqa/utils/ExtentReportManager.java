package com.autoqa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("AutoQA Hackathon Results");
            spark.config().setDocumentTitle("Test Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}