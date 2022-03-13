package com.pivotcoachingacademy.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickCheckBox {

	WebDriver webDriver;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		// Get the URL of the page
		webDriver.get("https://demoqa.com/radio-button");

		// Maximise the browser
		webDriver.manage().window().maximize();
	}

	@Test
	public void clickOnCheckBox() {
		webDriver.findElement(By.xpath("//span[text()='Home']")).click();
	}

	@Test
	public void clickOnImpressiveRadioBtn() {

		webDriver.findElement(By.cssSelector("label[for='impressiveRadio']")).click();
		WebElement getTextFromMessage = webDriver.findElement(By.className("text-success"));
		String actualText=getTextFromMessage.getText();
		Assert.assertEquals(actualText, "Depressive", "Text doesn't match");
	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}
}
