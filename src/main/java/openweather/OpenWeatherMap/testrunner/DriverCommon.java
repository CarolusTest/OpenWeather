package openweather.OpenWeatherMap.testrunner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.et.Eeldades;
import openweather.OpenWeatherMap.report.Reporter;

public class DriverCommon extends TestBase{

public static WebDriverWait wait;
	
	
	public void explicitWaitElementLocated(int seconds,By webElement) {
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
	}
	
	public void explicitWaitToBeClickable(int seconds,By element) {
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void explicitWaitPresenceOfElementLocated(int seconds,By webElement) {
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated( webElement));
	}
	
	public void impliciteWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public void fluentWait() {
		
	}
	
	public void webPageLoadTimeOut(int seconds) {
		driver.manage().timeouts().pageLoadTimeout(seconds,TimeUnit.SECONDS);
	}
	
	public void captureScreen(String projectPath,String scnName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=projectPath+"\\Screenshots\\"+scnName+".png";
		FileHandler.copy(scrFile, new File(screenshotPath));
		Reporter.addScreen(screenshotPath);
	}
	
	public void scrollScreen(WebElement wb) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", wb);
	}

	
}
