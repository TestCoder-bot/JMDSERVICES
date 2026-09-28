package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * About Us page. The page repeats a "Read More" call-to-action for each core
 * service block (Manpower / Security / Training). This page object exposes
 * every "Read More" element and a helper to check whether a given one is
 * genuinely clickable.
 */
public class AboutPage extends BasePage {

    private final By readMoreElements = By.xpath("//*[normalize-space(text())='Read More']");

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get all 'Read More' elements on the About page")
    public List<WebElement> getReadMoreElements() {
        return driver.findElements(readMoreElements);
    }

    /**
     * "Clickable" here means: present, displayed, enabled, and Selenium's
     * explicit wait for clickability succeeds. This intentionally does not
     * follow through a navigation - the goal is to flag "Read More" text that
     * LOOKS like a link/button but has no working click target, which is
     * exactly the kind of bug this check exists to catch.
     */
    @Step("Validate 'Read More' element #{1} is clickable")
    public boolean isReadMoreClickable(WebElement element, int index) {
        waitUtils.scrollToElement(element);
        try {
            WebElement clickable = waitUtils.waitForClickable(element);
            return clickable.isDisplayed() && clickable.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Get tag name of 'Read More' element #{1} (diagnostic - is it even an <a>?)")
    public String getReadMoreTagName(WebElement element, int index) {
        return element.getTagName();
    }
}
