# HCl AutoQA: E-Commerce Automation Framework

## 🚀 Project Overview
This repository contains a professional **Selenium-Java** automation framework developed for the HCL Hackathon. It automates a complete end-to-end user journey on the **Automation Exercise** website, covering everything from account creation to final order payment.

The framework is built using the **Page Object Model (POM)** to ensure high maintainability, reusability, and scalability.

---

## 📅 Project Execution Timeline (Rapid Deployment)

This project was developed in an intensive 24-hour cycle to demonstrate agile development capabilities:

* **Yesterday Morning:** Requirement analysis, framework skeleton setup (Maven, DriverFactory), and BasePage utility development.
* **Yesterday Afternoon:** Developed **Module 1 (Authentication)** with dynamic email generation to ensure repeatable test runs.
* **Yesterday Evening:** Developed **Module 2 (Product Search)** and **Module 3 (Cart Management)**. Integrated **TestNG Listeners** for failure handling.
* **This Morning:** Finalized **Module 4 (Checkout & Payment)**, integrated **Extent Reports (Spark)**, and completed final regression testing and documentation.

---

## 🛠 Framework Key Features
- **Design Pattern:** Strictly followed **Page Object Model (POM)**.
- **Reporting:** Integrated **Extent Reports** providing a detailed visual dashboard of test results.
- **Synchronization:** Zero usage of `Thread.sleep()`. All waits are handled via **Explicit Waits (WebDriverWait)**.
- **Configuration:** Environment variables like `URL`, `Browser`, and `Timeout` are centralized in `config.properties`.
- **Proof of Work:** Automatic **Screenshot Capture** on test failure and order confirmation.

---

## 📂 Project Structure
- `src/main/java/com/autoqa/pages`: Page classes containing locators and action methods.
- `src/main/java/com/autoqa/utils`: Shared utilities like `ConfigReader` and `ExtentReportManager`.
- `src/test/java/com/autoqa/tests`: End-to-End Test execution scripts.
- `reports/`: Location of the generated `ExtentReport.html`.
- `screenshots/`: Visual proof of successful execution and order placement.

---

## 🛠 Tech Stack
- **Language:** Java 11+
- **Automation:** Selenium WebDriver 4.x
- **Test Runner:** TestNG
- **Reporting:** Extent Reports (Spark Reporter)
- **Build Tool:** Maven

---

## 🏃 How to Run the Project
1. Clone the repository: `git clone https://github.com/dhathri25/HCl-AutoQA-ECommerce-Website-Project1.git`
2. Ensure Maven is installed and configured.
3. Open the project in your IDE (Eclipse/IntelliJ).
4. Right-click on `testng.xml` and select **Run As > TestNG Suite**.
5. After execution, open `reports/ExtentReport.html` to view the results.

---
*Developed by Dhathri Putty for the HCL Hackathon.*