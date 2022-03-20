package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAlerts {

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
		webDriver.get("https://demoqa.com/alerts");
		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void acceptAlert() {
		WebElement alertBtn = webDriver.findElement(By.id("alertButton"));

		alertBtn.click();
		// Accepting alert
		webDriver.switchTo().alert().accept();

	}

	@Test
	public void dismissAlert() {
		WebElement confirmButton = webDriver.findElement(By.id("confirmButton"));
		confirmButton.click();

		// dismissing the alert
		webDriver.switchTo().alert().dismiss();

	}

	@Test
	public void timerAlert() {

		WebElement confirmButton = webDriver.findElement(By.id("timerAlertButton"));
		confirmButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		// dismissing the alert
		webDriver.switchTo().alert().dismiss();
	}

	@Test
	public void promptAlert() {
		String textToBePassed = "Pivot";
		WebElement alertButton = webDriver.findElement(By.id("promtButton"));
		alertButton.click();
		Alert alert = webDriver.switchTo().alert();
		alert.sendKeys(textToBePassed);
		alert.accept();

	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

}
