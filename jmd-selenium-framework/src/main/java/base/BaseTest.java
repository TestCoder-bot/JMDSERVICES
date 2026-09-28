package base;

import utils.ConfigReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Every test class extends this. Handles browser start-up/tear-down so
 * individual test classes only deal with page objects and assertions.
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.initDriver(ConfigReader.getBrowser());
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @Step("Navigate to {0}")
    protected void navigateTo(String url) {
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
