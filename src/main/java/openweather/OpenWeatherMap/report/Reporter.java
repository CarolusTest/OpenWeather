package openweather.OpenWeatherMap.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reporter {
    private static Map<String, Boolean> systemInfoKeyMap = new HashMap<String, Boolean>();

    private Reporter() {
    }

   
    public static ExtentHtmlReporter getExtentHtmlReport() {
        return ExtentCucumberFormatter.getExtentHtmlReport();
    }

   
  
    public static ExtentReports getExtentReport() {
        return ExtentCucumberFormatter.getExtentReport();
    }

   
    public static void loadXMLConfig(String xmlPath) {
        getExtentHtmlReport().loadXMLConfig(xmlPath);
    }

   
    public static void loadXMLConfig(File file) {
        getExtentHtmlReport().loadXMLConfig(file);
    }

  
    public static void addStepLog(String message) {
        getCurrentStep().info(message);
    }

    public static void addScreen(String imagePath) throws IOException {
    	getCurrentStep().addScreenCaptureFromPath(imagePath, " Scenario ScreenShot ");
    }
    

 
    public static void setSystemInfo(String key, String value) {
        if (systemInfoKeyMap.isEmpty() || !systemInfoKeyMap.containsKey(key)) {
            systemInfoKeyMap.put(key, false);
        }
        if (systemInfoKeyMap.get(key)) {
            return;
        }
        getExtentReport().setSystemInfo(key, value);
        systemInfoKeyMap.put(key, true);
    }

   

  
    public static void setTestRunnerOutput(String outputMessage) {
        getExtentReport().setTestRunnerOutput(outputMessage);
    }

  
    public static void assignAuthor(String... authorName) {
        getCurrentScenario().assignAuthor(authorName);
    }

    private static ExtentTest getCurrentStep() {
        return ExtentCucumberFormatter.stepTestThreadLocal.get();
    }

    private static ExtentTest getCurrentScenario() {
        return ExtentCucumberFormatter.scenarioThreadLocal.get();
    }
}