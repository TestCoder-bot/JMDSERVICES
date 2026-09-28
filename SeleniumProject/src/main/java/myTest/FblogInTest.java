package myTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FblogInTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFacebookLogin() throws InterruptedException {

        driver.get("https://www.facebook.com/");

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));
        WebElement loginBtn = driver.findElement(By.name("login"));

        // Enter dummy credentials
        email.sendKeys("test@example.com");
        password.sendKeys("wrongPassword123");
        loginBtn.click();

        Thread.sleep(3000);

        // Validation: FB should stay on login page or show error
        boolean isStillOnLoginPage = driver.getCurrentUrl().contains("login");

        // Assert the condition
        Assert.assertTrue(isStillOnLoginPage, "❌ Expected to remain on login page, but login succeeded!");

        System.out.println("✔ Assertion passed: Login failed as expected.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
