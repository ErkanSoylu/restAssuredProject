# restAssuredProject
include testNG and RestAssured API test cases


Login and User Information API Tests
This repository contains API tests for logging a user in and retrieving their information. The tests are implemented using the Rest Assured library and TestNG.

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites
You will need to have the following software installed on your machine:

Java Development Kit (JDK) 8 or later
Maven
You will also need to have access to the API endpoint for logging in and retrieving user information.

Installing
Clone the repository to your local machine:


git clone https://github.com/[USERNAME]/api-tests.git
Navigate to the root directory of the project:


cd api-tests
Compile and package the project using Maven:


mvn package
Running the Tests
To run the tests, use the following command:


mvn test
The test results will be printed to the console.

Project Structure
The project is structured as follows:

Copy code
api-tests
└── src
    └── test
        ├── java
        │   └── RestAssuredTests.java
        └── resources
            └── log4j2.xml
            
RestAssuredTests.java contains the test case for logging a user in and retrieving their information.
log4j2.xml contains the configuration for the log4j2 logging library.
Test Case
The test case is contained in the RestAssuredTests class and has the following methods:

public String loginUserService()
This method logs a user in with a specified phone number and password. It returns the login token if the login is successful, or null if the token field is not found in the response.

public void getUserInfo()
This method retrieves the user's information using a GET request. The authorization header is set with the login token obtained from the loginUserService method. The response status code and body are printed to the console.

Dependencies
The following dependencies are used in this project:

io.rest-assured:rest-assured:3.3.0 for making HTTP requests and validating the responses.
org.json:json:20210131 for parsing JSON responses.
org.testng:testng:7.3.0 for running the tests.
org.apache.logging.log4j:log4j-core:2.15.0 for logging.

Resources
Rest Assured documentation
TestNG documentation
Log4j2 documentation
