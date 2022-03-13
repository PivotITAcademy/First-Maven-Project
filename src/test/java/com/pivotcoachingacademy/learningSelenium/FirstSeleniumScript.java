package com.pivotcoachingacademy.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumScript {
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
	public void sendkeysTest() {

		// Identifying the elements
		WebElement fullName = webDriver.findElement(By.id("userName"));
		WebElement email = webDriver.findElement(By.id("userEmail"));
		WebElement cAddress = webDriver.findElement(By.id("currentAddress"));
		WebElement pAddress = webDriver.findElement(By.id("permanentAddress"));

		// Perform Send Keys
		fullName.sendKeys("Manvir");
		email.sendKeys("msp@it.com");
		cAddress.sendKeys("Ontario");
		pAddress.sendKeys("India");

	}

	@Test
	public void clickSubmitBtn() {
		// Identifying the elements
		WebElement fullNameInput = webDriver.findElement(By.id("userName"));
		WebElement emailInput = webDriver.findElement(By.id("userEmail"));
		WebElement cAddressInput = webDriver.findElement(By.id("currentAddress"));
		WebElement pAddressInput = webDriver.findElement(By.id("permanentAddress"));
		WebElement submitBtn = webDriver.findElement(By.id("submit"));

		// Perform Send Keys
		fullNameInput.sendKeys("Manvir");
		emailInput.sendKeys("msp@it.com");
		cAddressInput.sendKeys("Ontario");
		pAddressInput.sendKeys("India");

		// Clicking
		submitBtn.click();

	}

	@Test
	public void isSubmitBtnDisplayed() {
		// Identifying the elements
		WebElement submitBtn = webDriver.findElement(By.id("submit"));

		boolean isDisplayed = submitBtn.isDisplayed();
		System.out.println("Is Button Displayed " + isDisplayed);
	}

	@Test
	public void isBtnEnabled() {
		// Identifying the elements
		WebElement submitBtn = webDriver.findElement(By.id("submit"));

		boolean isEnabled = submitBtn.isEnabled();
		System.out.println("Is Button Enabled " + isEnabled);
	}

	@Test
	public void submitSignUpForm() {

		WebElement firstNameInput = webDriver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement lastNameInput = webDriver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		WebElement phoneInput = webDriver.findElement(By.xpath("//input[@placeholder='Phone']"));
		WebElement emailInput = webDriver.findElement(By.xpath("//input[@placeholder='Email']"));
		WebElement passWordInput = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
		WebElement submitBtn = webDriver.findElement(By.xpath("//button[@type='submit']"));
		WebElement clickCookie = webDriver.findElement(By.id("cookie_stop"));

		// Send keys OR Text
		// Accept Cookies
		clickCookie.click();

		firstNameInput.sendKeys("Neeru");
		lastNameInput.sendKeys("Singala");
		phoneInput.sendKeys("6472152994");
		emailInput.sendKeys("msp@it.com");
		passWordInput.sendKeys("Password1");

		// submit The form
		submitBtn.click();

	}

	@Test
	public void getTextFromAutomationWebsite() {

		WebElement contactUsMessage = webDriver.findElement(By.cssSelector("#center_column .page-heading.bottom-indent"));

		String message=contactUsMessage.getText();
		
		System.out.println(message);
		
	}

}
