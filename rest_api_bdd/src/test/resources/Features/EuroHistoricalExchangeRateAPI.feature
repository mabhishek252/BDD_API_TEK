#Author: Abhishek.Mishra
#Description: Feature file to validate API response against Historical EURO Foreign Exchange reference rates

Feature: REST API to fetch Historical Foreign Exchange Rates

  @Regression
  Scenario: Get Historical Foreign Exchange reference rates
    Given API for Historical Exchange rates
    When Send Http Get Request for Historical API
    Then Validate the Historical Exchange rates
    

    
    