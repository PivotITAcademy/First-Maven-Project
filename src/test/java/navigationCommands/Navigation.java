package navigationCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Navigation {

	
	WebDriver webDriver;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		// Get the URL of the page
		webDriver.get("https://demoqa.com/droppable");

		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Maximise the browser
		webDriver.manage().window().maximize();

	}
	
	@Test
	public void navigationCommands() {
		//Command to go to particular URL
		
		webDriver.navigate().to("https://www.google.com/");
		
		
		
		//Move back
		webDriver.navigate().back();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//move forward
		webDriver.navigate().forward();
		
		//Reload
		webDriver.navigate().refresh();
		
	}
}
