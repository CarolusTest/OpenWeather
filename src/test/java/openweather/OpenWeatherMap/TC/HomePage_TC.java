package openweather.OpenWeatherMap.TC;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import openweather.OpenWeatherMap.PO.HomePage_PO;
import openweather.OpenWeatherMap.report.Reporter;
import openweather.OpenWeatherMap.testrunner.DriverCommon;
import openweather.OpenWeatherMap.testrunner.TestBase;

public class HomePage_TC extends TestBase {

	
	DriverCommon dc;
	HomePage_PO hp;//=PageFactory.initElements(driver, HomePage_PO.class);
	SoftAssert st;
	boolean status;
	String actual;
	int flag=0;
	
	//First Scenario
	@Given("^url for weather map website$")
	public void url_for_weather_map_website() throws Exception {
		initialization();
		if(flag==0) {
			driver.manage().deleteAllCookies();
			flag=1;
		}
		driver.get(prop.getProperty("url"));
		hp=PageFactory.initElements(driver, HomePage_PO.class);//new HomePage_PO();
		dc=new DriverCommon();
		st = new SoftAssert();
	}

	@When("^I get navigated to homepage using provided url$")
	public void i_get_navigated_to_homepage_using_provided_url() {
		dc.impliciteWait(10);
		status=hp.getHomePageLogo().isDisplayed();
		st.assertEquals(status, true);
	}

	@Then("^I validate the fields on UI$")
	public void i_validate_the_fields_on_UI() {
		status=hp.getSearchOption().isEnabled();
		System.out.println("search : "+status);
		st.assertTrue(status);
		
		dc.scrollScreen(hp.getWidgetDisplayed());
		status=hp.getWidgetDisplayed().isDisplayed();
		st.assertEquals(status, true);
		
		String actualText=hp.getWeatherNote().getText();
		Reporter.addStepLog(" Homepage Weather Note: \n "+actualText);
		System.out.println(" Weather Note Present on Homepage : "+actualText);
		
		Reporter.addStepLog(" Cookies Notification verified : "+hp.getCookiesNotification().isDisplayed());
	}

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws IOException {
		//Printing values as it might change with time of execution.
		st.assertAll();
		Reporter.addStepLog(" Weather for : "+hp.getWeatherForCity().getText());
		Reporter.addStepLog(" Humidity : "+hp.getHumidityDetails().getText());
		Reporter.addStepLog(" Wind : "+hp.getWindDetails().getText());
		Reporter.addStepLog(" Temperature : "+hp.getVerifyTempDisplayed().getText());
		dc.captureScreen(projectPath, "First scenario");
		driver.close();
	}
	
	//Second Scenario
	@When("^I enter Invalid city in search and click on search button$")
	public void i_enter_Invalid_city_in_search_and_click_on_search_button() {
		dc.impliciteWait(10);
		hp.getSearchOption().sendKeys("mvn");
		hp.getSearchButton().click();
		
	}

	@Then("^I validate that response contains Not Found$")
	public void i_validate_that_response_contains_Not_Found() throws IOException {
		actual=hp.getInvalidNotFound().getText();
		System.out.println(" :: "+actual);
		st.assertTrue(actual.endsWith("Not found"));
		System.out.println(" contains string "+actual.contains("Not found"));
		dc.captureScreen(projectPath, "Second scenario");
		st.assertAll();
		driver.close();
	}
	
	//Third Scenario
	@When("^I enter valid city in search and click on search button$")
	public void i_enter_valid_city_in_search_and_click_on_search_button() throws Throwable {

		hp.getSearchOption().sendKeys("mumbai");
		hp.getSearchButton().click();
	}

	@Then("^validate that response contains valid details$")
	public void validate_that_response_contains_valid_details() throws Throwable {
		dc.impliciteWait(5);
		actual=(hp.getVerifyCity().getText());
		st.assertTrue(actual.contains("Mumbai"));

		Reporter.addStepLog(" Weather for : "+actual);
		Reporter.addStepLog(" Temperature : "+hp.getCityTemperature().getText());
		Reporter.addStepLog(" Geo Coords : "+hp.getVerifyGeoCoords().getText());
		Reporter.addStepLog(" Temperature Details : "+hp.getCityTempdetails().getText());
		
		
		dc.captureScreen(projectPath, "Third scenario");
		st.assertAll();
		driver.close();
		
	}
	
}
