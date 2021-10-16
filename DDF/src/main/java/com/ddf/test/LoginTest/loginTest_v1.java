package com.ddf.test.LoginTest;

import org.testng.annotations.Test;

import com.ddf.base.BaseUI_v1;

public class loginTest_v1 extends BaseUI_v1 {

	@Test
	public void testOne() throws InterruptedException {
		
		invokeBrowser("chrome");
		//invokeBrowser("firefox");
		//invokeBrowser("MicrosoftEdge");
		openURL("https://www.rediff.com/");
		elementClick("//a[contains(text(),'Sign in')]");
		enterText("//input[@id='login1']","U S E R N A M E");
		Thread.sleep(2000);
		tearDown();
	}
	
	//Call a different browser - firefox
	@Test(dependsOnMethods="testOne")
	public void testTwo() throws InterruptedException {
		//invokeBrowser("chrome");
		invokeBrowser("firefox");
		//invokeBrowser("MicrosoftEdge");
		openURL("https://money.rediff.com/index.html");
		elementClick("//*[@id=\"signin_info\"]/a[1]");
		enterText("//*[@id=\"useremail\"]","pragatipatil3016@rediffmail.com");
		enterText("//*[@id=\"userpass\"]","Prag@3016");
		elementClick("//*[@id=\"loginsubmit\"]");
		Thread.sleep(5000);		
		elementClick("//*[@id=\"createPortfolio\"]");

		Thread.sleep(2000);
		tearDown();
	}
	
	//Exercise - Call a different browser - Edge
	@Test(dependsOnMethods="testTwo")
	public void testThree() throws InterruptedException {
		//invokeBrowser("chrome");
		//invokeBrowser("firefox");
		invokeBrowser("MicrosoftEdge");
		openURL("https://shopping.rediff.com/");
		elementClick("//*[@id=\"sigin_info\"]/a[1]");
		enterText("/html/body/table[2]/tbody/tr[1]/td/table[2]/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/table/tbody/tr[1]/td[2]/input","qwerty@gmail.com");
		enterText("/html/body/table[2]/tbody/tr[1]/td/table[2]/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/table/tbody/tr[4]/td[2]/input","@#$%");
		Thread.sleep(2000);
		tearDown();
	}
}
