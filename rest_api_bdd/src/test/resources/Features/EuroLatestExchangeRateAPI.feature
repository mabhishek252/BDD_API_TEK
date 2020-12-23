#Author: Abhishek.Mishra
#Description: Feature file to validate API response against Latest EURO Foreign Exchange reference rates

Feature: REST API for Foreign Exchange Rates

  @Regression
  Scenario: Get Latest Foreign Exchange reference rates
    Given API for Latest Exchange rates
    When Send Http Get Request for API
    Then Validate the Latest Exchange rates
    
  Scenario: Get Latest Foreign Exchange reference rates for future Date     
    Given API for Latest Exchange rates with future date
    When Send Http Get Request for future date
    Then Validate the Latest Exchange rates for future date
    
    