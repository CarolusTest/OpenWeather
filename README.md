# OpenWeather
PrudentTest

Following Project consist all Tests given for OpenWeather App.
1.Validate Information on Homepage
2.Validate Invalid City search Results
3.Validate Valid city weather Search Result
4.Validate weather API request response against provided inputs.

Git Repository 


How to Run
Pull project from Git repository to local Machine.
Import project in Eclipse from local Repository.
Make sure Java_Home is configured properly in your system.
Right click on pom.xml -> Run As -> Maven Clean 
and then Right click on pom.xml -> Run As -> Maven install

Check Report
# Run following command in Jenkins script console to view Extent report with graphs and coverage properly
Manage Jenkins -> script console -> enter below command and click run button before running build.

System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "default-src * 'unsafe-inline' 'unsafe-eval'; script-src * 'unsafe-inline' 'unsafe-eval'; connect-src * 'unsafe-inline'; img-src * data: blob: 'unsafe-inline'; frame-src *; style-src * 'unsafe-inline';")

#In Jenkins Report directory contains execution report.
http://localhost:8080/job/PrudentTest/ws/Report/OpenWeather_Report.html




