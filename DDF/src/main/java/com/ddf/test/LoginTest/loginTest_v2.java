package com.ddf.test.LoginTest;

import org.testng.annotations.Test;

import com.ddf.base.BaseUI_v2;

public class loginTest_v2 extends BaseUI_v2 {

	@Test
	public void testOne() throws InterruptedException {
		invokeBrowser("chrome");
		openURL("websiteurl");
		elementClick("signinButton_Xpath");
		enterText("usernameTB_Xpath","U S E R N A M E");
		Thread.sleep(2000);
		tearDown();
	}
	
	@Test(dependsOnMethods="testOne")
	public void testTwo() throws InterruptedException {
		invokeBrowser("chrome");
		openURL("websiteurl");
		elementClick("createAccount_Xpath");
		enterText("FullName_Xpath","Hello There");
		enterText("RediffMailID_Xpath","qwerty@rediffmail.com");
		enterText("Password_Xpath","@#$%");
		enterText("RePassword_Xpath","@#$%");
		enterText("AltMailID_Xpath","asdfg@rediffmail.com");
		enterText("MobNo_Xpath","1234567890");
		elementClick("FemaleBtn_Xpath");

		Thread.sleep(5000);
		tearDown();
	}
	
	@Test(dependsOnMethods="testTwo")
	public void testThree() throws InterruptedException {
		invokeBrowser("chrome");
		openURL("website_URL");
		elementClick("signin_Id");
		enterText("Email_Xpath","qwerty@gmail.com");
		enterText("PassField_Xpath","@#$%");

		Thread.sleep(5000);
		tearDown();
	}
}
