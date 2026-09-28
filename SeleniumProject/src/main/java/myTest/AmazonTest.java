package myTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class AmazonTest {
ChromeDriver driver;
//	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	 
	@BeforeMethod
public void setup() {
		System.setProperty("webDriver.chrome.driver","C:\\Program Files\\Google\\Chrome");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable--notifications");
		driver=new ChromeDriver(options);	
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	String element1= driver.findElement(By.xpath("//div[@class='a-row a-text-center']")).getText();
	System.out.println("Text is ="+element1);
}
	@Test
	public void verifytitle() {
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void getLogo() {
		boolean element = driver.findElement(By.xpath("//a[@href='/ref=nav_logo']")).isDisplayed();
		Assert.assertTrue(element);
		
	}
	
	
	
	
@AfterMethod
public void stop() {
	
//		driver.close();
	}
}
