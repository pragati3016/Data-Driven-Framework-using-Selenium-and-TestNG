package com.ddf.test.LoginTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.ddf.base.BaseUI_v4;
import com.ddf.utils.ExtentReportManager;

public class loginTest_v4 extends BaseUI_v4 {
	
	ExtentReports report=ExtentReportManager.getReportInstance();
	@Test
	public void testOne() throws InterruptedException, IOException {
		
		logger = report.createTest("Test one");
		logger.log(Status.INFO, "Initializing the browser");
		invokeBrowser("chrome");
		logger.log(Status.INFO, "Opening URL");
		openURL("websiteurl");
		Thread.sleep(2000);
		logger.log(Status.INFO, "Clicking sign in button"); 
		elementClick("signinButton_Xpath");
		logger.log(Status.INFO, "Entering Username"); 
		enterText("usernameTB_Xpath","U S E R N A M E");
		logger.log(Status.INFO, "Entering Password"); 
		enterText("passwordTB_Id","l o n g - p a s s w o r d");
		logger.log(Status.INFO, "Signing In"); 
		elementClick("SignBtn_Xpath");
		logger.log(Status.FAIL,"Test case failed");
		takeScreenShotOnFailure();

		Thread.sleep(2000);
		tearDown();
	}
	
	@AfterTest
	public void endReport() {
		report.flush();
	}
}
