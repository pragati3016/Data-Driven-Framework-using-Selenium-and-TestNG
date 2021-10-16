package com.ddf.test.LoginTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.ddf.base.BaseUI_v3;
import com.ddf.utils.ExtentReportManager;

public class loginTest_v3 extends BaseUI_v3 {
	
	ExtentReports report=ExtentReportManager.getReportInstance();
	@Test
	public void testOne() throws InterruptedException, IOException {

		logger = report.createTest("Test one");
		logger.log(Status.INFO, "Initializing the browser");
		invokeBrowser("Chrome");
		logger.log(Status.INFO, "Opening URL");
		openURL("webURL");
		logger.log(Status.INFO, "Clicking sign in button"); 
		elementClick("signinButton_Xpath");
		logger.log(Status.INFO, "Entering Username"); 
		enterText("emailID_Xpath","pragatipatil3016@rediffmail.com");
		logger.log(Status.INFO, "Entering Password"); 
		enterText("passwordField_Xpath","Prag@3016");
		logger.log(Status.INFO, "Signing In"); 
		elementClick("submitBtn_Xpath");
		logger.log(Status.PASS,"Test case passed");
		
		Thread.sleep(2000);
		tearDown();

	}
	
	@AfterTest
	public void endReport() {
		report.flush();
	}
}
