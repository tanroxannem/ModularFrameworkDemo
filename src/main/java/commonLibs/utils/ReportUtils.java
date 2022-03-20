package commonLibs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {

	ExtentSparkReporter htmlReport; // for HTML report

	ExtentReports extentReports; // to generate report

	ExtentTest extentTest; // to create test cases

	public ReportUtils(String htmlReportFilename) {
		// TODO Auto-generated constructor stub //just type the name and press CTRL +
		// space bar
		
		htmlReportFilename = htmlReportFilename.trim();

		htmlReport = new ExtentSparkReporter(htmlReportFilename);

		extentReports = new ExtentReports();

		extentReports.attachReporter(htmlReport);

	}

	public void createATestCase(String testcaseName) {
		extentTest = extentReports.createTest(testcaseName);
	}

	/* status = error or warning log; comment = what comment need to pass. */
	public void addTestLog(Status status, String comment) {
		extentTest.log(status, comment);
	}
	
	public void attachedScreenshotToReport(String filename) throws Exception{
		extentTest.addScreenCaptureFromPath(filename);
	}

	/* whenever you're starting a report you always need to close the report. */
	public void flushReport() {
		extentReports.flush();
	}

}
