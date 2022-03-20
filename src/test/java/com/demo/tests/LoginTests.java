package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTests extends BaseTests {

	@Parameters({ "username", "userPassword" })
	@Test
	public void verifyUserLoginWithCorrectCredentials(String username, String password) {

		reportUtils.createATestCase("Verify User Login With Correct Credentials");

		reportUtils.addTestLog(Status.INFO, "Performing Login");

		loginPage.loginToApplication(username, password);

		String expectedTitle = "Guru99 Bank Manager HomePage - for fail TC";
		String actualTitle = cmnDriver.getTitleOfThePage();
		
		reportUtils.addTestLog(Status.INFO, "Comparing expected and actual title");

		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
