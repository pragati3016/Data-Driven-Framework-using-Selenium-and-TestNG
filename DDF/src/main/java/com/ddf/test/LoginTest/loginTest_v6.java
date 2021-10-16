package com.ddf.test.LoginTest;

import java.io.IOException;
import java.util.Hashtable;

import com.ddf.utils.TestDataProvider;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import com.ddf.base.BaseUI_v6;
import com.ddf.utils.ExtentReportManager;

public class loginTest_v6 extends BaseUI_v6 {
	ExtentReports report=ExtentReportManager.getReportInstance();
	
	
	@Test(dataProvider="getTestOneData")
	public void testOne(Hashtable<String, String> dataTable) throws InterruptedException, IOException {
		logger = report.createTest("Test one");
		invokeBrowser("chrome");
		openURL("webURL");
		elementClick("signinButton_Xpath");
		enterText("emailID_Xpath",dataTable.get("Username"));
		enterText("passwordField_Xpath",dataTable.get("password"));
		elementClick("submitBtn_Xpath");
		elementClick("createPF_Xpath");
		enterName("PFTextbox_Xpath");
		elementClick("createPFBtn_Xpath");
		logger.log(Status.PASS,"Test case passed successfully");

		Thread.sleep(2000);
		tearDown();
	}
	
	@AfterTest
	public void endReport() {
		report.flush();
	}
	
	
	@DataProvider
	public Object[][] getTestOneData(){
		return TestDataProvider.getTestData("SignUp.xlsx", "Sheet1", "Sign Up");
	}
	
}
