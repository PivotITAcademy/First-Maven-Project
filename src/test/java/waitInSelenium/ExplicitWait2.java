package waitInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait2 {

	WebDriver webDriver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		wait = new WebDriverWait(webDriver, 30);

		// Get the URL of the page0
		webDriver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void testExplicitWait() {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(text(),'Click me to start timer')]")));
		
		webDriver.findElement(By.xpath("//button[contains(text(),'Click me to start timer')]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'WebDriver')]")));

		String text = webDriver.findElement(By.xpath("//p[contains(text(),'WebDriver')]")).getText();
		Assert.assertEquals(text, "WebDriver");
	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

}
