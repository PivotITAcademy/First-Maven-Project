package seleniumIframes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumIframe {

	WebDriver webDriver;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome Driver 99\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		// Get the URL of the page
		webDriver.get("https://demoqa.com/frames");

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void testIframe() {
		//Switching to iframe using index
		webDriver.switchTo().frame(2);

		WebElement text = webDriver.findElement(By.id("sampleHeading"));
		System.out.println(text.getText());
	}
	
	@Test
	public void testIframe2() {
		webDriver.switchTo().frame("frame1");

		WebElement text = webDriver.findElement(By.id("sampleHeading"));
		System.out.println(text.getText());
	}
	
	
	
	@Test
	public void testIframe3() {
		webDriver.switchTo().frame("frame1");

		WebElement text = webDriver.findElement(By.id("sampleHeading"));
		System.out.println(text.getText());
		
		
		//Switch back
		webDriver.switchTo().defaultContent();
		WebElement text1=webDriver.findElement(By.cssSelector("#framesWrapper div"));
		System.out.println(text1.getText());
	}
	
	@Test
	public void testIframe4() {
		webDriver.switchTo().frame("frame1");

		WebElement text = webDriver.findElement(By.id("sampleHeading"));
		System.out.println(text.getText());
		
		
		//Switch back
		webDriver.switchTo().defaultContent();
		WebElement text1=webDriver.findElement(By.cssSelector("#framesWrapper div"));
		System.out.println(text1.getText());
		
		webDriver.switchTo().frame("frame2");
		WebElement text2Element=webDriver.findElement(By.id("sampleHeading"));
		System.out.println(text2Element.getText());
		
	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

}
