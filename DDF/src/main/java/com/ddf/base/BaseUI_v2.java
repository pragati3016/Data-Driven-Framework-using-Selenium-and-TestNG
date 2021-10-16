package com.ddf.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUI_v2 {

	public WebDriver driver;
	public Properties prop;

	
	public void invokeBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//test//resources//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}

		if (prop == null) {
			prop = new Properties();


			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "//src//test//resources//objectRepository//projectConfig.properties");
				prop.load(file);

			} catch (Exception e) {
				//reportFail(e.getMessage());
				e.printStackTrace();
			}

		}

		
	}

	public void openURL(String websiteURLkey) {
		driver.get(prop.getProperty(websiteURLkey));
	}

	public void tearDown() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void elementClick(String xpathkey) {
		driver.findElement(By.xpath(prop.getProperty(xpathkey))).click();
	}

	public void enterText(String xpathkey, String data) {
		driver.findElement(By.xpath(prop.getProperty(xpathkey))).sendKeys(data);
	}
}
