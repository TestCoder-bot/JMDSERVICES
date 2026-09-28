package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Single place for every explicit wait and scroll operation used across the
 * framework. Page objects hold one instance of this class instead of talking
 * to WebDriverWait / JavascriptExecutor directly.
 */
public class WaitUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor jsExecutor;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    // ---------------------------------------------------------------
    // Waits
    // ---------------------------------------------------------------

    @Step("Wait for element to be visible: {0}")
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Step("Wait for element to be visible")
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Step("Wait for element to be clickable")
    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Step("Wait for element to be clickable: {0}")
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Step("Wait for element presence: {0}")
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Step("Wait for page to finish loading")
    public void waitForPageLoad() {
        wait.until(driver -> "complete".equals(jsExecutor.executeScript("return document.readyState")));
    }

    /**
     * Small, explicit, last-resort pause for JS-driven animations that don't
     * expose a reliable condition to wait on (e.g. smooth-scroll settling).
     * Prefer the waitFor* methods above wherever possible.
     */
    public void pauseMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ---------------------------------------------------------------
    // Scrolling
    // ---------------------------------------------------------------

    @Step("Scroll element into view")
    public void scrollToElement(WebElement element) {
        jsExecutor.executeScript(
                "arguments[0].scrollIntoView({behavior:'instant', block:'center', inline:'center'});", element);
        pauseMillis(300); // let sticky headers / lazy-loaded images settle
    }

    @Step("Scroll element into view: {0}")
    public void scrollToElement(By locator) {
        scrollToElement(waitForPresence(locator));
    }

    @Step("Scroll window by ({0}, {1}) pixels")
    public void scrollByPixels(int x, int y) {
        jsExecutor.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
        pauseMillis(300);
    }

    @Step("Scroll to bottom of page")
    public void scrollToBottom() {
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        pauseMillis(300);
    }

    @Step("Scroll to top of page")
    public void scrollToTop() {
        jsExecutor.executeScript("window.scrollTo(0, 0);");
        pauseMillis(300);
    }

    /**
     * Scrolls an element into view and waits for it to actually be visible,
     * which is the combination almost every page object needs.
     */
    @Step("Scroll to and verify visibility of element")
    public boolean scrollAndVerifyVisible(WebElement element) {
        scrollToElement(element);
        try {
            return waitForVisibility(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Scroll to and verify visibility of element: {0}")
    public boolean scrollAndVerifyVisible(By locator) {
        WebElement element = waitForPresence(locator);
        return scrollAndVerifyVisible(element);
    }
}
