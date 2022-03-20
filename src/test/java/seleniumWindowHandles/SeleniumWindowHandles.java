package seleniumWindowHandles;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumWindowHandles {

	WebDriver webDriver;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		// Get the URL of the page
		webDriver.get("https://demoqa.com/browser-windows");

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void itdentifyWindowWithSelenium() {
		String parentHandle = webDriver.getWindowHandle();
		String secondHandle = "";
		String thirdHandle = "";

		WebElement newTabBtn = webDriver.findElement(By.id("tabButton"));

		newTabBtn.click();

		Set<String> handles1 = webDriver.getWindowHandles();

		for (String handle : handles1) {
			if (!handle.equals(parentHandle)) {
				secondHandle = handle;
			}
		}

		newTabBtn.click();
		Set<String> handles2 = webDriver.getWindowHandles();
		for (String handle : handles2) {
			if (!handle.equals(parentHandle) && !handle.equals(secondHandle)) {
				thirdHandle = handle;
			}

		}

		//Switching to new Window
		webDriver.switchTo().window(thirdHandle);

		WebElement getTextFrom3rdTab = webDriver.findElement(By.id("sampleHeading"));

		System.out.println(getTextFrom3rdTab.getText());

		//Switching back 
		webDriver.switchTo().window(parentHandle);

		System.out.println(webDriver.findElement(By.xpath("//div[text()='Browser Windows']")).getText());
	}
	
	@Test
	public void mamathaQuestion() {
		String parentHandle = webDriver.getWindowHandle();
		System.out.println("parent" + " " + parentHandle );
		String secondHandle = "";
		String thirdHandle = "";

		WebElement newTabBtn = webDriver.findElement(By.id("tabButton"));

		newTabBtn.click();
		secondHandle = webDriver.getWindowHandle();
		System.out.println("Second" + " " + secondHandle );

		
	
	}

}
