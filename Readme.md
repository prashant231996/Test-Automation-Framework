
Java Test Automation Framework

Java Console Project for managing students data.

This is a Java-based Test Automation Framework built with TestNG for testing and Maven for dependency management and CLI execution.

It supports Data-Driven Testing, Cloud Execution on LambdaTest, and Headless Mode for faster test runs.

Detailed reports are generated using Extent Reports, and logs are managed using Log4j.
## Author
-Prashant More
- [@Linked In](https://www.linkedin.com/in/prashant-more-a64974228/)
-Email Address: prashantmore.sdet@gmail.com


## 🚀 About Me
Hi My name is Prashant more, I have 4 years of experience in Automation Testing using testchnologies like Selenium Webdriver, RestAssured, Appium, PlayWright.

My major experties in WebAutomation Testing using selenium and Java. API Automation testing using RestAssured. 


## Tech Stack

**Programming Language:** Java


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/prashant231996/)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/prashant-more-a64974228/)


## Prerequisites

Make sure the following tools are installed:

- **Java JDK 11+**
- **Apache Maven 3.6+**
- Git
- Internet Connection (for LambdaTest execution)

## Key Features

✅ TestNG for test orchestration and assertions

✅ Maven Surefire Plugin for CLI-based execution

✅ Data-Driven Testing using:

OpenCSV
 – CSV file-based data

Apache POI
 – Excel-based data

Gson
 – JSON-based data

✅ Fake Data Generation using Java Faker

✅ Cloud Execution on LambdaTest

✅ Headless Mode for faster local test runs

✅ Extent Reports for detailed HTML test reports

✅ Log4j integration for logging test events

✅ Cross-browser execution (Chrome, Firefox, Edge, etc.)

🧩 Framework Dependencies

The framework uses the following core dependencies (managed via pom.xml):

- Dependency	Purpose
- TestNG	Testing framework
- Selenium WebDriver	Browser automation
- Apache POI	Excel data handling
- OpenCSV	CSV data handling
- Gson	JSON data handling
- Faker	Fake data generation
- Extent Reports	Reporting
- Log4j	Logging
- Maven Surefire Plugin	CLI test execution
- LambdaTest Selenium Grid	Cloud execution

⚡ How to Run Tests

You can execute tests from the Command Line Interface (CLI) using Maven.

The framework supports three parameters:

- Parameter	Description	Accepted Values
- browser	Browser to run tests on	chrome, firefox, edge, etc.
- isLambdaTest	Run tests on LambdaTest	true / false
- isHeadless	Run tests in headless mode	true / false
▶️ Example Commands

1️⃣ Run Tests Locally (Headless Mode)
mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true

2️⃣ Run Tests Locally (Normal Mode)
mvn clean test -Dbrowser=firefox -DisLambdaTest=false -DisHeadless=false

3️⃣ Run Tests on LambdaTest
mvn clean test -Dbrowser=edge -DisLambdaTest=true -DisHeadless=false

🧾 Test Reports and Logs After test execution:

- Extent Report: Generated at reports/report.html:
     Open it in a browser to view test results with screenshots, logs, and execution details.

- Log File: Generated in logs/log.log

## Integration the project Githiub Actions
This automation framework is integrated with github actions. 
The test will be executed at 11:30PM IST every single day.
