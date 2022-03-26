package javascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class javascriptExecutor {

	WebDriver webDriver;
	WebElement signInBtn;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		// Get the URL of the page
		webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// Maximise the browser
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) webDriver;
	}

	@Test
	public void interactWith() {

		signInBtn = webDriver.findElement(By.id("SubmitLogin"));

		signInBtn.click();

	}

	@Test
	public void testLogin() {

		js.executeScript("document.getElementById('SubmitLogin').click();");

	}
}
