package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Blog listing page. Validates the "Search Here" widget and its search input
 * are present after scrolling down the sidebar.
 */
public class BlogPage extends BasePage {

    private final By searchWidgetHeading = By.xpath("//*[contains(normalize-space(.),'Search Here')]");
    private final By searchField = By.cssSelector("input[type='search'], input[name='s']");

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate blog search field is visible after scrolling")
    public boolean isSearchFieldVisible() {
        waitUtils.scrollToElement(searchWidgetHeading);
        WebElement field = waitUtils.waitForPresence(searchField);
        return waitUtils.scrollAndVerifyVisible(field);
    }

    @Step("Validate blog search field is enabled")
    public boolean isSearchFieldEnabled() {
        WebElement field = waitUtils.waitForPresence(searchField);
        return field.isEnabled();
    }
}
