package webtable2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestWebTables {

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
		webDriver.get("https://www.w3schools.com/html/html_tables.asp");

		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void testWebTable() {
		String personName = "Helen Bennett";
		List<WebElement> noOfRows = webDriver.findElements(By.xpath("//table[@class='ws-table-all']//tbody//tr"));
		List<WebElement> noOfColums = webDriver.findElements(By.xpath("//table[@class='ws-table-all']//tbody//tr//th"));

		System.out.println("Total no. of rows " + noOfRows.size());
		System.out.println("Total no of colums " + noOfColums.size());

		String beforeXpath = "//table[@class='ws-table-all']//tbody//tr[";
		String afterXpath = "]//td[";

		for (int i = 2; i <= noOfRows.size(); i++) {
			for (int j = 1; j <= noOfColums.size(); j++) {
				WebElement finalElement = webDriver.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]"));
				if (finalElement.getText().contains(personName)) {
					finalElement.click();
				}
			}

		}

	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

}
