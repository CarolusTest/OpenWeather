package openweather.OpenWeatherMap.report;

import java.io.File;

public enum ExtentProperties {
    INSTANCE;
    private String reportPath;
    private String projectName;

  

    ExtentProperties() {
        this.reportPath = "output" + File.separator + "Run_" + System.currentTimeMillis() + File.separator
                + "report.html";
        this.projectName = "default";
    }
    
    
    
    public String getReportPath() {
        return reportPath;
    }

   
    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    

}