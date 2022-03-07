package com.pivotcoachingacademy.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumScript {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		wd = new ChromeDriver();

		// Get the URL of the page
		wd.get("http://www.google.com");

		// Maximise the browser
		wd.manage().window().maximize();
	}

	@Test
	public void firstTest() {

		WebElement searchBox = wd.findElement(By.name("q"));
		searchBox.sendKeys("Inderjit");

	}

}
