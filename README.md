# DEMOQA-Basic-Test
Framework designed to test simple login functionality using TDD and TESTNG to regulate the execution of tests.

SRC/Main/Java
BasePoint Package:
          code to implement the initial SetUp and Propert definition.URL is taken from Property file   
Pages Package:
          It contains page object model of teh two pages as Home Page and Form Page.
HomePage: 
          Contains the Test for Login and verification of UI elements and ensures that Form option is directed to Form Page.It gets the Username and Password required for login from Property file.        
FormPage: 
          Test to input multiple data in the form Page and submits the data. Data is inputted from Excel sheet using DataProvider.
ReadExcelByDataProvider: 
          DataProvider is implemented using input from calling menthod. Object array is used to store and pass the data to dataprovider section.

SRC/Main/Test
Test Packge:
          Contains the test methods as part of java classes and @Test is used for provide est identification.@BeforeTest is used to initate browser landing and Property declaration.@AfterTest is used to Close the browser regardless of tset case status.

Drivers:
          Contains webdrivers.
          
TestDataExcel:
          Sample TestData used to input form fields and contains variable data types.
Cofig.Properties:
          Property file defines most commonly used property of username and password
          
 POM.XML:
          Dependencies required for maven Project.
          
TESTNG.XML:
          Script to run the tests and provides the test case running configuration.
          
         





