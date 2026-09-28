package listeners;

import base.DriverFactory;
import utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

/**
 * Registered in testng.xml. Reacts to every test outcome; the interesting
 * case is onTestFailure, where it grabs a screenshot from the still-open
 * WebDriver session and:
 *   1. saves it to disk (test-output/screenshots), and
 *   2. attaches it to the Allure report so it shows up right on the failed step.
 */
public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("===== Starting test suite: " + context.getName() + " =====");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        System.out.println("FAILED: " + testName);

        try {
            WebDriver driver = DriverFactory.getDriver();

            // Save to disk for local debugging.
            String path = ScreenshotUtils.captureAndSave(driver, testName);
            System.out.println("Screenshot saved: " + path);

            // Attach to the Allure report.
            byte[] screenshotBytes = ScreenshotUtils.captureAsBytes(driver);
            Allure.addAttachment(
                    "Screenshot on failure - " + testName,
                    new ByteArrayInputStream(screenshotBytes));

            // Also capture page source, handy when a locator is simply wrong.
            Allure.addAttachment("Page source", "text/html", driver.getPageSource(), ".html");

        } catch (Exception e) {
            System.err.println("Could not capture failure screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("===== Finished test suite: " + context.getName() + " =====");
    }
}
