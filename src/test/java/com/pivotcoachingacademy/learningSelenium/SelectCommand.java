package com.pivotcoachingacademy.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectCommand {

	
	WebDriver webDriver;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		// Get the URL of the page
		webDriver.get("https://demo.guru99.com/test/newtours/register.php");

		// Maximise the browser
		webDriver.manage().window().maximize();
	}


	@Test
	public void selectCountry() {
		WebElement country=webDriver.findElement(By.name("country"));
		
		Select select=new Select(country);
		
		//select by index
		select.selectByIndex(5);
		
		//Selct By value
		select.selectByValue("ARGENTINA");
		
		//Select by Visible Text
		
		select.selectByVisibleText("AMERICAN SAMOA");
		
		//Deselect
		select.deselectAll();
		
		
	}

	@AfterMethod
	public void tearDown() {
		//webDriver.quit();
	}
}
