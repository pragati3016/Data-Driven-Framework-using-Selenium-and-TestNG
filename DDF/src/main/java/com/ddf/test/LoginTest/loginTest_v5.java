package com.ddf.test.LoginTest;

import java.io.IOException;
import java.util.Hashtable;

import com.ddf.utils.TestDataProvider;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import com.ddf.base.BaseUI_v5;
import com.ddf.utils.ExtentReportManager;

public class loginTest_v5 extends BaseUI_v5 {
	ExtentReports report=ExtentReportManager.getReportInstance();
	
	
	@Test(dataProvider="getTestOneData")
	public void testOne(Hashtable<String, String> dataTable) throws InterruptedException, IOException {
		logger = report.createTest("Test one");
		invokeBrowser("chrome");
		openURL("websiteurl");
		elementClick("signin_Xpath");
		enterText("usernameTextbox_Xpath",dataTable.get("Username"));
		System.out.println("Username: dT.get(Username)"+dataTable.get("Username"));
		enterText("passwordTextbox_Id",dataTable.get("password"));
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
		return TestDataProvider.getTestData("TestData_Testmanagement.xlsx", "Feature 1", "Test Four");
	}
	
}
