package openweather.OpenWeatherMap.testrunner;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import openweather.OpenWeatherMap.report.Reporter;

public class TestBase {

	public static Properties prop,propLocators;
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");

	public static void init() {
		prop = new Properties();
//		propLocators = new Properties();
		try {
			FileInputStream ip = new FileInputStream(projectPath + "\\Config\\Environment.properties");
			prop.load(ip);
//			FileInputStream fis = new FileInputStream(projectPath + "\\Locators\\homepage.properties");
//			propLocators.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.assignAuthor("Carolus Dabre");
	}

	public static void initialization() throws Exception {
		init();
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", projectPath + "\\Browser\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} 
//		else if (browserName.equals("firefox")) {
//
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\Exec\\geckodriver.exe");		
//			w = new FirefoxDriver();
//		}

	}
}
