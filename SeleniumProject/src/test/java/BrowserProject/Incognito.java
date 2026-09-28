package BrowserProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Incognito {
    public static void main(String[] args) {
        // Set system property for ChromeDriver
      
    // Create ChromeOptions instance
    ChromeOptions options = new ChromeOptions();
    
    // Add incognito argument
    options.addArguments("--incognito");

    // Initialize WebDriver with Chrome options
    RemoteWebDriver driver = new ChromeDriver(options);
    
    // Open a URL to check if it's working
    driver.get("https://www.fb.com");

    // Perform your test actions...

    // Close the browser
//    driver.quit();
}
}