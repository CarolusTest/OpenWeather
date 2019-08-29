package openweather.OpenWeatherMap.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import openweather.OpenWeatherMap.testrunner.TestBase;

public class HomePage_PO extends TestBase {

	@FindBy(xpath="//a[@class='navbar-brand']/img")
	public WebElement homePageLogo;
	
	@FindBy(xpath="//*[@id='q' and @placeholder='Your city name']")
	private WebElement searchOption;
	
	@FindBy(xpath="//*[@id='searchform']/button")
	private WebElement searchButton;
	
	@FindBy(xpath="//*[@id='forecast_list_ul']/div")
	private WebElement invalidNotFound;
	
	@FindBy(xpath="//*[@id='weather-widget']")
	private WebElement widgetDisplayed;
	
	@FindBy(xpath="//div[@class='widget__temperature']/p")
	private WebElement weatherNote;
	
	@FindBy(xpath="//p[contains(text(),'We use cookies')]")
	private WebElement cookiesNotification;
	
	@FindBy(xpath="//*[@id='weather-widget']/h2")
	private WebElement weatherForCity;
	
	@FindBy(xpath="//*[@class='weather-widget__temperature']")///text()[1]
	private WebElement verifyTempDisplayed;
	
	@FindBy(xpath="//*[@id='weather-widget-wind']")
	private WebElement windDetails;
	
	@FindBy(xpath="//td[contains(text(),'Humidity')]/following-sibling::td")
	private WebElement humidityDetails;
	
	@FindBy(xpath="//a[contains(text(),'More weather')]")
	private WebElement moreWeatherDetails;
	
	@FindBy(xpath="//tr/td[2]/b/a")
	private WebElement verifyCity;
	
	@FindBy(xpath="//tr/td[2]/p[1]/span")
	private WebElement cityTemperature;
	
	@FindBy(xpath="//tr/td[2]/p[contains(text(),'temperature')]")
	private WebElement cityTempdetails;
	
	@FindBy(xpath="//tr/td[2]/p[contains(text(),'Geo coords')]")
	private WebElement verifyGeoCoords;
	
	public WebElement getHomePageLogo() {
		return homePageLogo;
	}
	
	public WebElement getSearchOption() {
		return searchOption;
	}
	
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public WebElement getInvalidNotFound() {
		return invalidNotFound;
	}
	
	public WebElement getWidgetDisplayed() {
		return widgetDisplayed;
	}
	
	public WebElement getWeatherNote() {
		return weatherNote;
	}
	
	public WebElement getCookiesNotification() {
		return cookiesNotification;
	}
	
	public WebElement getWeatherForCity() {
		return weatherForCity;
	}
	
	public WebElement getVerifyTempDisplayed() {
		return verifyTempDisplayed;
	}
	
	public WebElement getWindDetails() {
		return windDetails;
	}
	
	public WebElement getHumidityDetails() {
		return humidityDetails;
	}
	
	public WebElement getMoreWeatherDetails() {
		return moreWeatherDetails;
	}
	
	public WebElement getVerifyCity() {
		return verifyCity;
	}
	
	public WebElement getCityTemperature() {
		return cityTemperature;
	}
	
	public WebElement getCityTempdetails() {
		return cityTempdetails;
	}
	
	public WebElement getVerifyGeoCoords() {
		return verifyGeoCoords;
	}
	

}
