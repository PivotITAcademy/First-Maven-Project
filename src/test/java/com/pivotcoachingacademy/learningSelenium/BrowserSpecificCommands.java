package com.pivotcoachingacademy.learningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserSpecificCommands {
	
	WebDriver webDriver;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		// Get the URL of the page
		webDriver.get("http://automationpractice.com/index.php?controller=contact");

		// Maximise the browser
		webDriver.manage().window().maximize();
	}
	
	@Test
	public void getPageTitle() {
		String pageTitle=webDriver.getTitle();
		System.out.println(pageTitle);
	}
	
	@Test
	public void getPageURL() {
		String pageURL=webDriver.getCurrentUrl();
		System.out.println(pageURL);
		
	}
	
	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

}
