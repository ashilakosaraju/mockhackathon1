# Project Design & Planning Document

## 1. Requirement Analysis
The goal was to automate the "Automation Exercise" e-commerce site. 
Key modules identified:
- User Authentication (Registration/Login)
- Product Discovery (Search)
- Cart Management (Add/Remove)
- Checkout Process (Payment/Confirmation)

## 2. Framework Selection
- **Pattern:** Page Object Model (POM) to separate UI locators from test logic.
- **Language:** Java with Selenium WebDriver.
- **Testing Engine:** TestNG for assertions and test execution.
- **Reporting:** Extent Reports for stakeholder-friendly results.

## 3. Automation Strategy
- **Synchronization:** Used Explicit Waits (WebDriverWait) to handle dynamic elements, ensuring a "No Thread.sleep" policy.
- **Data Management:** Implemented `config.properties` for environment-level variables (URL, Browser, Timeouts).
- **Error Handling:** Integrated TestNG Listeners to capture screenshots automatically upon any test failure.

## 4. Execution Plan (Day-wise Progress)
- **Day 1:** Framework skeleton setup (Maven, BasePage, DriverFactory).
- **Day 2:** Module 1 (Auth) - Registration and Login logic.
- **Day 3:** Module 2 & 3 - Product Search and Cart functionality.
- **Day 4:** Module 4 - Checkout, Payment, and Final Reporting integration.
- **Day 5:** GitHub documentation and Final Code Review.