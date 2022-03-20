package actionSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {

	WebDriver webDriver;
	Actions action;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		// Get the URL of the page
		webDriver.get("https://demoqa.com/tool-tips");

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Maximise the browser
		webDriver.manage().window().maximize();
		action = new Actions(webDriver);
	}

	@Test
	public void mouseHover() {
		WebElement mouseHoverElement = webDriver.findElement(By.id("toolTipButton"));
		action.moveToElement(mouseHoverElement).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String attributeValue = mouseHoverElement.getAttribute("aria-describedby");
		Assert.assertEquals("buttonToolTip", attributeValue);
	}
}
