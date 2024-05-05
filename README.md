# Automated Testing for Skleptest.pl

This project is dedicated to automating tests for the website [skleptest.pl](https://skleptest.pl/) using the Selenium WebDriver tool.

## Description

## Project goal

The aim of the project is to ensure high application quality through the automation of the testing process for the Skleptest.pl website. Automation allows tests to be executed in a repeatable and effective manner, contributing to faster detection of errors and improvement of product quality.

### Tested Functionality
The following functionalities are tested through automated tests:
- Links on the homepage and subpages
- Buttons on the homepage and subpages
- Newsletter subscription
- Login functionality
- Providing data for the billing address form
- Adding products to the cart

### Tools Used
- **Selenium WebDriver:** Used for automating interactions with web browsers.
- **TestNG:** Framework for creating and managing automated tests.
- **Allure:** Tool for generating clear reports with test results.
- **Qase:** Test management tool, integrated with the project for better progress tracking and task management.
- **Mockaroo:** Used for generating test data for tests.

### Supported Browsers
Test automation allows tests to be run on three popular web browsers:
- Google Chrome
- Mozilla Firefox
- Microsoft Edge

## Reporting

Test result reports are generated using the Allure tool, enabling clear and transparent presentation of test results.

## Integration with Qase

The project has been integrated with the Qase tool for better test management. Updates regarding test progress and results can be tracked in the Qase interface.

## Generating Test Data

Test data used in tests has been generated using the Mockaroo tool, ensuring diversity and realism of data in the introduced test scenarios.

## Issue with Tests on Mozilla Firefox Browser

⚠️ Currently, there is an issue with tests related to the billing address form on the Mozilla Firefox browser. Therefore, it is recommended to either skip these tests by removing them from the .xml file for TestNG or using the @Ignore annotation from TestNG when running them on this browser. Work on resolving this issue is ongoing and will be implemented as soon as possible.




![Java](https://img.shields.io/badge/Java-%230A1A2F?style=flat&logo=openjdk&logoColor=%236875CD) ![Selenium](https://img.shields.io/badge/Selenium-%230A1A2F?style=flat&logo=Selenium&logoColor=%2300cc00) ![Webdriver](https://img.shields.io/badge/Webdriver-%230A1A2F?style=flat&logo=Webdriver
) ![Intelij Idea](https://img.shields.io/badge/-IntelliJ%20IDEA-0A1A2F?style=flat&logo=intelliJ-idea&logoColor=0a76ef) ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-%230A1A2F?style=flat&logo=Visual%20Studio&logoColor=%2348aaeb) ![Qase](https://img.shields.io/badge/Qase-%230A1A2F?style=flat&logo=Qase&logoColor=%236875CD)
