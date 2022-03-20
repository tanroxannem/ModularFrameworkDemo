package com.demo.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.demo.pages.LoginPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigUtils;
import commonLibs.utils.ReportUtils;
import commonLibs.utils.ScreenshotsUtils;

public class BaseTests {

	CommonDriver cmnDriver;
	String url;

	WebDriver driver;

	LoginPage loginPage;

	String configFileName;
	String currentWorkingDirectory;

	Properties configProperty;

	String reportFilename;
	ReportUtils reportUtils;
	
	ScreenshotsUtils screenshot;

	@BeforeSuite
	public void preSetup() throws Exception {
		currentWorkingDirectory = System.getProperty("user.dir");

		configFileName = currentWorkingDirectory + "/config/config.properties";
		reportFilename = currentWorkingDirectory + "/reports/guru99TestReports.html";

		configProperty = ConfigUtils.readProperties(configFileName);

		reportUtils = new ReportUtils(reportFilename);
	}

	@BeforeClass
	public void setup() throws Exception {

		url = configProperty.getProperty("baseUrl");

		String browserType = configProperty.getProperty("browserType");

		cmnDriver = new CommonDriver(browserType);

		driver = cmnDriver.getDriver();

		cmnDriver.navigateToUrl(url);

		loginPage = new LoginPage(driver);
		
		screenshot = new ScreenshotsUtils(driver);
	}

	@AfterMethod
	public void postTestAction(ITestResult result) throws Exception {
		/*
		 * ITestResult is a method/argument that automatically pass when we run this
		 * afterMethod which restores the result of test case
		 */

		String testcasename = result.getName();
		long executionTime = System.currentTimeMillis();

		String screenshotFilename = currentWorkingDirectory + "/screenshots/" + testcasename + executionTime + ".jpeg";

		if (result.getStatus() == ITestResult.FAILURE) {

			reportUtils.addTestLog(Status.FAIL, "One or more steps failed");

			screenshot.captureAndSaveScreenshot(screenshotFilename);
			
			reportUtils.attachedScreenshotToReport(screenshotFilename); 
		}
	}

	@AfterClass
	public void teardown() {
		cmnDriver.closeAllbrowser();
	}

	@AfterSuite
	public void postTeardown() {
		reportUtils.flushReport();
	}

}
