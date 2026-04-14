# Project Design & Planning Document - AutoQA

## 1. Requirement Analysis
The objective was to build a robust, production-ready automation suite for the "Automation Exercise" platform. 
**Key Modules Automated:**
- **Module 1:** User Authentication (Dynamic Registration & Secure Login).
- **Module 2:** Product Discovery (Search functionality).
- **Module 3:** Cart Management (Add to Cart from Search).
- **Module 4:** Checkout & Payment (Address verification, Payment entry, and Order confirmation).

## 2. Framework Architecture & Selection
- **Pattern:** **Page Object Model (POM)**. This was chosen to ensure that UI changes only require updates in one place (Page Classes), keeping the Test Classes clean and readable.
- **Language:** Java 11.
- **Drivers:** Selenium WebDriver managed via WebDriverManager.
- **Execution Engine:** TestNG (using `testng.xml` for suite management).
- **Reporting:** **Extent Reports (Spark)** for professional, high-level stakeholder reporting.

## 3. Strict Automation Strategies Applied
As per the hackathon's "Strict Rules," the following strategies were implemented:
- **Synchronization (Rule 5):** Strictly **Zero usage of `Thread.sleep()`**. All synchronization is handled via `WebDriverWait` (Explicit Waits) to ensure the framework is fast and non-flaky.
- **Configuration (Rule 4.5):** All environment constants (URL, Browser, Timeout) are stored in `config.properties`. No hardcoding exists in the logic.
- **Failure Handling (Rule 4.6):** Implemented **TestNG Listeners** to automatically trigger screenshots on any test failure, which are then attached to the Extent Report.
- **POM Strictness (Rule 4.1):** Locators are kept `private` within Page classes to maintain strict encapsulation.

## 4. Rapid Execution Timeline (24-Hour Sprint)
To demonstrate Agile efficiency, the project was completed in an intensive sprint:
- **Morning:** Framework skeleton, `BasePage` architecture, and `ConfigReader` setup.
- **Afternoon:** Development of Authentication and Product Search modules.
- **Evening:** Development of Cart and Checkout modules; Listener and Extent Report integration.
- **Late Night/Morning:** Regression testing, bug fixing (NullPointer issues), and finalizing documentation for GitHub deployment.