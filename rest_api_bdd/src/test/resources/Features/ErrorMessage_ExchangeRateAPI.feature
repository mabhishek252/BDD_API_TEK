#Author: Abhishek.Mishra
#Description: Feature file to validate error message on API response for incomplete or incorrect API

Feature: REST API for Foreign Exchange Rates

   
  Scenario: Get valid error message for incomplete API     
    Given Incomplete API for Exchange rates
    When Send Http Get Request for Incomplete API
    Then Validate the error message
    
    