#Author: Carolus Dabre
#Keywords Summary : Test For Prudent Application
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Open Weather Map website
  I want to use this website for testing weather information on Homepage.

  Scenario: verify Homepage weather details
    Given url for weather map website
    When I get navigated to homepage using provided url
    Then I validate the fields on UI
    And check more outcomes

	Scenario: verify Invalid city weather search result
    Given url for weather map website
    When I enter Invalid city in search and click on search button
    Then I validate that response contains Not Found
    
  Scenario: verify valid city weather search result and validated
    Given url for weather map website
    When I enter valid city in search and click on search button
    Then validate that response contains valid details
