$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("homepage.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Carolus Dabre"
    },
    {
      "line": 2,
      "value": "#Keywords Summary : Test For Prudent Application"
    },
    {
      "line": 3,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 4,
      "value": "#| (Data Tables)"
    },
    {
      "line": 5,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 6,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 7,
      "value": "#\"\""
    },
    {
      "line": 8,
      "value": "## (Comments)"
    },
    {
      "line": 9,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 11,
  "name": "Open Weather Map website",
  "description": "I want to use this website for testing weather information on Homepage.",
  "id": "open-weather-map-website",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 14,
  "name": "verify Homepage weather details",
  "description": "",
  "id": "open-weather-map-website;verify-homepage-weather-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "url for weather map website",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I get navigated to homepage using provided url",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I validate the fields on UI",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "check more outcomes",
  "keyword": "And "
});
formatter.match({
  "location": "HomePage_TC.url_for_weather_map_website()"
});
formatter.result({
  "duration": 21383600000,
  "status": "passed"
});
formatter.match({
  "location": "HomePage_TC.i_get_navigated_to_homepage_using_provided_url()"
});
formatter.result({
  "duration": 122705800,
  "status": "passed"
});
formatter.match({
  "location": "HomePage_TC.i_validate_the_fields_on_UI()"
});
formatter.result({
  "duration": 305458100,
  "status": "passed"
});
formatter.match({
  "location": "HomePage_TC.check_more_outcomes()"
});
formatter.result({
  "duration": 2780458200,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "verify Invalid city weather search result",
  "description": "",
  "id": "open-weather-map-website;verify-invalid-city-weather-search-result",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "url for weather map website",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I enter Invalid city in search and click on search button",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I validate that response contains Not Found",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePage_TC.url_for_weather_map_website()"
});
formatter.result({
  "duration": 20088858400,
  "status": "passed"
});
formatter.match({
  "location": "HomePage_TC.i_enter_Invalid_city_in_search_and_click_on_search_button()"
});
formatter.result({
  "duration": 3824982300,
  "status": "passed"
});
formatter.match({
  "location": "HomePage_TC.i_validate_that_response_contains_Not_Found()"
});
formatter.result({
  "duration": 2539909300,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "verify valid city weather search result and validated",
  "description": "",
  "id": "open-weather-map-website;verify-valid-city-weather-search-result-and-validated",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "url for weather map website",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I enter valid city in search and click on search button",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "validate that response contains valid details",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePage_TC.url_for_weather_map_website()"
});
formatter.result({
  "duration": 18903947200,
  "status": "passed"
});
formatter.match({
  "location": "HomePage_TC.i_enter_valid_city_in_search_and_click_on_search_button()"
});
formatter.result({
  "duration": 3993653400,
  "status": "passed"
});
formatter.match({
  "location": "HomePage_TC.validate_that_response_contains_valid_details()"
});
formatter.result({
  "duration": 2916953000,
  "status": "passed"
});
formatter.uri("openweather_API.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Carolus Dabre"
    },
    {
      "line": 2,
      "value": "#Keywords Summary : Test For Prudent Application"
    },
    {
      "line": 3,
      "value": "# API test demo"
    }
  ],
  "line": 5,
  "name": "API tests fo open weather API",
  "description": "I want to send API request and validate response against it",
  "id": "api-tests-fo-open-weather-api",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Send valid request for mumbai city",
  "description": "",
  "id": "api-tests-fo-open-weather-api;send-valid-request-for-mumbai-city",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I want to send request with cityname parameter \u003cname\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I check in response for the \u003cvalue\u003e in step",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I verify value matches expected value",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "api-tests-fo-open-weather-api;send-valid-request-for-mumbai-city;",
  "rows": [
    {
      "cells": [
        "name",
        "value"
      ],
      "line": 14,
      "id": "api-tests-fo-open-weather-api;send-valid-request-for-mumbai-city;;1"
    },
    {
      "cells": [
        "\"London,uk\"",
        "200"
      ],
      "line": 15,
      "id": "api-tests-fo-open-weather-api;send-valid-request-for-mumbai-city;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 15,
  "name": "Send valid request for mumbai city",
  "description": "",
  "id": "api-tests-fo-open-weather-api;send-valid-request-for-mumbai-city;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I want to send request with cityname parameter \"London,uk\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I check in response for the 200 in step",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I verify value matches expected value",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "London,uk",
      "offset": 48
    }
  ],
  "location": "OpenWeather_API.i_want_to_send_request_with_cityname_parameter(String)"
});
formatter.result({
  "duration": 1068981700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 28
    }
  ],
  "location": "OpenWeather_API.i_check_in_response_for_the_in_step(int)"
});
formatter.result({
  "duration": 2872470900,
  "status": "passed"
});
formatter.match({
  "location": "OpenWeather_API.i_verify_value_matches_expected_value()"
});
formatter.result({
  "duration": 946143100,
  "status": "passed"
});
});