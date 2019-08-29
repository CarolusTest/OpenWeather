#Author: Carolus Dabre
#Keywords Summary : Test For Prudent Application
# API test demo

Feature: API tests fo open weather API
  I want to send API request and validate response against it

  Scenario Outline: Send valid request for mumbai city
    Given I want to send request with cityname parameter <name>
    When I check in response for the <value> in step
    Then I verify value matches expected value

    Examples: 
      | name  | value |
      | "London,uk" | 200 |
