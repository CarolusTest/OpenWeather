package openweather.OpenWeatherMap.testrunner;

import org.apache.commons.exec.OS;
import org.kohsuke.rngom.digested.DChoicePattern;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.deps.com.thoughtworks.xstream.core.JVM;
import openweather.OpenWeatherMap.report.ExtentProperties;
import openweather.OpenWeatherMap.report.Reporter;

@CucumberOptions(

	features = { "resources.features" }, glue = { "openweather/OpenWeatherMap/TC", }, monochrome = true,
		

		plugin = { "pretty", "html:target/cucumber-reports/Report", "openweather.OpenWeatherMap.report.ExtentCucumberFormatter:", }

)

public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public static void setup() {

		String projectPath = System.getProperty("user.dir");

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(projectPath + "\\Report\\OpenWeather_Report.html");

	}
	

	@AfterClass
	public static void teardown() {
		String OStype;
		String projectPath = System.getProperty("user.dir");
		String pFilesX86 = System.getenv("ProgramFiles(X86)");
	    if (pFilesX86 !=(null)){
	    	OStype=" 64bit";
	    	System.out.println(" 64bit");
	    }
	    else{
	    	OStype=" 32bit";
	    	System.out.println(" 32bit");
	    }
		//Reporter.loadXMLConfig(new File(projectPath+"\\Config\\extent-config.xml"));
		
		Reporter.setSystemInfo("USER", System.getProperty("user.name"));
		Reporter.setSystemInfo("OS", System.getProperty("os.name")+" :: "+OStype);
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Capabilities cap = ((RemoteWebDriver) TestBase.driver).getCapabilities();
		Reporter.setSystemInfo("Browser exe compatible with "," chrome 75.0 version ");
		Reporter.setSystemInfo("Browser execution version ", cap.getBrowserName()+" :: "+cap.getVersion());
//		Reporter.setSystemInfo("Machine ", "Windows 10 : " + "64 Bit");
		Reporter.setSystemInfo("Selenium Version ", "3.141.5");
		Reporter.setSystemInfo("Cucumber Version ", "1.2.5");
		Reporter.setSystemInfo("Rest Assured ", "3.3.0");
		Reporter.setSystemInfo("Maven ", "3.5.2");
		Reporter.setSystemInfo("Java Version ", "1.8.0_211");

	}

}
