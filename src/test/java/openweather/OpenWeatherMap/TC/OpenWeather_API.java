package openweather.OpenWeatherMap.TC;

import org.testng.asserts.SoftAssert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import openweather.OpenWeatherMap.report.Reporter;
import openweather.OpenWeatherMap.testrunner.TestBase;

public class OpenWeather_API extends TestBase{
	RequestSpecification httpRequest;
	Response response;
	JsonPath jsonPathEvaluator;
	SoftAssert st = new SoftAssert();
	
	
	@Given("^I want to send request with cityname parameter \"([^\"]*)\"$")
	public void i_want_to_send_request_with_cityname_parameter(String city) throws Throwable {
		init();
		RestAssured.baseURI = prop.getProperty("api");
		
		httpRequest = RestAssured.given()
		.queryParam("q", city).queryParam("appid", "b6907d289e10d714a6e88b30761fae22");
	}

	@When("^I check in response for the (\\d+) in step$")
	public void i_check_in_response_for_the_in_step(int code)  {
		response = httpRequest.get();
		System.out.println(response.asString());
		int statusCode = response.getStatusCode();
		System.out.println("The status code is: " + statusCode);
		st.assertEquals(statusCode, code);//200
		
		
	}

	@Then("^I verify value matches expected value$")
	public void i_verify_value_matches_expected_value() {
		
		String name = response.jsonPath().getString("name");
		System.out.println(" City name : "+name);
		st.assertEquals(name,"London" ,"weather city does not match");
		String weather = response.jsonPath().getString("weather");
		System.out.println(" City weather : "+weather);
		//st.assertEquals(weather,"London" ,"weather does not match");
		String wind = response.jsonPath().getString("wind");
		System.out.println(" City wind : "+wind);
		//st.assertEquals(wind,"London" ,"weather city does not match");
		String main = response.jsonPath().getString("main");
		System.out.println(" City Temperature Details : "+main);
		//st.assertEquals(main,"London" ,"weather city does not match");
		String coord = response.jsonPath().getString("coord");
		System.out.println(" City Coords : "+coord);
		//st.assertEquals(coord,"London" ,"weather city does not match");
		
	}

	@Then("^the success is logged in report$")
	public void the_success_is_logged_in_report() {
		st.assertAll();
		
	}
	
	
}
