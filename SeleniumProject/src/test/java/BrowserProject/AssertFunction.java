package BrowserProject;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class AssertFunction {
public static void main (String [] args) throws InterruptedException {
	RemoteWebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in");
//	driver.manage().window().maximize();
	String mainwindow = driver.getWindowHandle();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Apple iPhone 13 (128GB) - Starlight");
	driver.findElement(By.id("nav-search-submit-button")).click();
	String searchItem =driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]")).getText();
	System.out.println(searchItem);
	String expectedItem = "Apple iPhone 13 (128GB) - Starlight";
	Assert.assertTrue(searchItem.contains(expectedItem));
	driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]")).click();
	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs.get(1));
	 WebElement buyNowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buy-now-button")));
     
     // Click the "Buy Now" button
     buyNowButton.click();
 
//	Thread.sleep(5000);
	driver.close();

	
 }
}
