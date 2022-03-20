package waitInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {

	WebDriver webDriver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		wait = new WebDriverWait(webDriver, 10);

		// Get the URL of the page0
		webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void selectGener() {

		WebElement emailInput = webDriver.findElement(By.cssSelector("#email_create"));
		emailInput.sendKeys("31" + "@emal.com");
		// System.out.println(("",
		// 8)+"@emal.com");
		WebElement clickCreateAccount = webDriver.findElement(By.cssSelector("#SubmitCreate"));
		clickCreateAccount.click();

		wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.cssSelector("#id_gender1"))));

		WebElement genderID = webDriver.findElement(By.cssSelector("#id_gender1"));

		genderID.click();
	}

}
