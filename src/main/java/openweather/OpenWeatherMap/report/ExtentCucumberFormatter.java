package openweather.OpenWeatherMap.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.mongodb.MongoClientURI;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.testng.IResultMap;


	public class ExtentCucumberFormatter implements Reporter, Formatter {
	    private static ExtentReports extentReports;
	    private static ExtentHtmlReporter htmlReporter;
	    private static ThreadLocal<ExtentTest> featureTestThreadLocal = new InheritableThreadLocal<ExtentTest>();	  
	    private static ThreadLocal<ExtentTest> scenarioOutlineThreadLocal = new InheritableThreadLocal<ExtentTest>();
	    static ThreadLocal<ExtentTest> scenarioThreadLocal = new InheritableThreadLocal<ExtentTest>();
	    private static ThreadLocal<LinkedList<Step>> stepListThreadLocal =
	        new InheritableThreadLocal<LinkedList<Step>>();
	    static ThreadLocal<ExtentTest> stepTestThreadLocal = new InheritableThreadLocal<ExtentTest>();
	    private boolean scenarioOutlineFlag;

	    public ExtentCucumberFormatter(File file) {
	        setExtentHtmlReport(file);
	        setExtentReport();
	        stepListThreadLocal.set(new LinkedList<Step>());
	        scenarioOutlineFlag = false;
	    }

	    private static void setExtentHtmlReport(File file) {
	        if (htmlReporter != null) {
	            return;
	        }
	        if (file == null || file.getPath().isEmpty()) {
	            file = new File(ExtentProperties.INSTANCE.getReportPath());
	        }
	        if (!file.exists()) {
	            file.getParentFile().mkdirs();
	        }
	        htmlReporter = new ExtentHtmlReporter(file);
	    }

	    static ExtentHtmlReporter getExtentHtmlReport() {
	        return htmlReporter;
	    }

	    private static void setExtentReport() {
	        if (extentReports != null) {
	            return;
	        }
	        extentReports = new ExtentReports();
	        ExtentProperties extentProperties = ExtentProperties.INSTANCE;

	        
	        extentReports.attachReporter(htmlReporter);
	        htmlReporter.config().setDocumentTitle("CarolusFramework : QA Project Report");
			htmlReporter.config().setReportName("CarolusFramework : Project Report");
	        htmlReporter.config().setChartVisibilityOnOpen(false);
	    }

	    static ExtentReports getExtentReport() {
	        return extentReports;
	    }

	        ExtentProperties extentProperties = ExtentProperties.INSTANCE;


	    public void feature(Feature feature) {
	        featureTestThreadLocal.set(getExtentReport().createTest(com.aventstack.extentreports.gherkin.model.Feature.class, feature.getName()));
	        ExtentTest test = featureTestThreadLocal.get();

	        for (Tag tag : feature.getTags()) {
	            test.assignCategory(tag.getName());
	        }
	    }

	    public void scenarioOutline(ScenarioOutline scenarioOutline) {
	        scenarioOutlineFlag = true;
	        ExtentTest node = featureTestThreadLocal.get()
	            .createNode(com.aventstack.extentreports.gherkin.model.ScenarioOutline.class, scenarioOutline.getName());
	        scenarioOutlineThreadLocal.set(node);
	    }

	    public void examples(Examples examples) {
	        ExtentTest test = scenarioOutlineThreadLocal.get();

	        String[][] data = null;
	        List<ExamplesTableRow> rows = examples.getRows();
	        int rowSize = rows.size();
	        for (int i = 0; i < rowSize; i++) {
	            ExamplesTableRow examplesTableRow = rows.get(i);
	            List<String> cells = examplesTableRow.getCells();
	            int cellSize = cells.size();
	            if (data == null) {
	                data = new String[rowSize][cellSize];
	            }
	            for (int j = 0; j < cellSize; j++) {
	                data[i][j] = cells.get(j);
	            }
	        }
	        test.info(MarkupHelper.createTable(data));
	    }

	    public void startOfScenarioLifeCycle(Scenario scenario) {
	        if (scenarioOutlineFlag) {
	            scenarioOutlineFlag = false;
	        }

	        ExtentTest scenarioNode;
	        if (scenarioOutlineThreadLocal.get() != null && scenario.getKeyword().trim()
	            .equalsIgnoreCase("Scenario Outline")) {
	            scenarioNode =
	                scenarioOutlineThreadLocal.get().createNode(com.aventstack.extentreports.gherkin.model.Scenario.class, scenario.getName());
	        } else {
	            scenarioNode =
	                featureTestThreadLocal.get().createNode(com.aventstack.extentreports.gherkin.model.Scenario.class, scenario.getName());
	        }

	        for (Tag tag : scenario.getTags()) {
	            scenarioNode.assignCategory(tag.getName());
	        }
	        scenarioThreadLocal.set(scenarioNode);
	    }

	

	    public void step(Step step) {
	        if (scenarioOutlineFlag) {
	            return;
	        }
	        stepListThreadLocal.get().add(step);
	    }

	    public void endOfScenarioLifeCycle(Scenario scenario) {

	    }

	    public void done() {
	        getExtentReport().flush();
	    }

	    public void close() {

	    }

	    public void eof() {

	    }

	    public void before(Match match, Result result) {

	    }

	    public void result(Result result) {
	    	 ExtentTest test = scenarioOutlineThreadLocal.get();
	        if (scenarioOutlineFlag) {
	            return;
	        }

	        if (Result.PASSED.equals(result.getStatus())) {
	            stepTestThreadLocal.get().pass(Result.PASSED);


	        } else if (Result.FAILED.equals(result.getStatus())) {
	            stepTestThreadLocal.get().info("");

	            stepTestThreadLocal.get().fail(result.getError());

	        } else if (Result.SKIPPED.equals(result)) {
	            stepTestThreadLocal.get().skip(Result.SKIPPED.getStatus());
	        } else if (Result.UNDEFINED.equals(result)) {
	            stepTestThreadLocal.get().skip(Result.UNDEFINED.getStatus());
	        }
	    }

	    public void after(Match match, Result result) {

	    }

	    public void match(Match match) {
	        Step step = stepListThreadLocal.get().poll();
	        String data[][] = null;
	        if (step.getRows() != null) {
	            List<DataTableRow> rows = step.getRows();
	            int rowSize = rows.size();
	            for (int i = 0; i < rowSize; i++) {
	                DataTableRow dataTableRow = rows.get(i);
	                List<String> cells = dataTableRow.getCells();
	                int cellSize = cells.size();
	                if (data == null) {
	                    data = new String[rowSize][cellSize];
	                }
	                for (int j = 0; j < cellSize; j++) {
	                    data[i][j] = cells.get(j);
	                }
	            }
	        }

	        ExtentTest scenarioTest = scenarioThreadLocal.get();
	        ExtentTest stepTest = null;

	        try {
	            stepTest = scenarioTest.createNode(new GherkinKeyword(step.getKeyword()), step.getKeyword() + step.getName());
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	        if (data != null) {
	            Markup table = MarkupHelper.createTable(data);
	            stepTest.info(table);
	        }

	        stepTestThreadLocal.set(stepTest);
	    }

	    public void embedding(String mimeType, byte[] data) {

	    }

	    public void write(String text) {

	    }

		public void syntaxError(String state, String event, List<String> legalEvents, String uri, Integer line) {
			// TODO Auto-generated method stub
			
		}

		public void uri(String uri) {
			// TODO Auto-generated method stub
			
		}

		public void background(Background background) {
			// TODO Auto-generated method stub
			
		}

		public void scenario(Scenario scenario) {
			// TODO Auto-generated method stub
			
		}
	}