package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Home page (https://jmdservice.com/). Only responsibility used by this
 * suite: confirm the "Popular Courses" section shows the expected course
 * names once scrolled into view.
 *
 * NOTE: on the live site the course headings are exactly:
 *   "Advanced Microsoft Office", "MS Excel & MS Word", "Power Point & Power BI"
 */
public class HomePage extends BasePage {

    private final By popularCoursesHeading = By.xpath("//*[contains(normalize-space(.),'Popular Courses')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By courseByName(String courseName) {
        // Matches the course heading/link whatever tag WordPress renders it as.
        return By.xpath("//*[self::h1 or self::h2 or self::h3 or self::h4 or self::a]"
                + "[contains(normalize-space(.),\"" + courseName + "\")]");
    }

    @Step("Scroll to Popular Courses section")
    public void scrollToPopularCoursesSection() {
        waitUtils.scrollToElement(popularCoursesHeading);
    }

    @Step("Validate course '{0}' is visible after scrolling")
    public boolean isCourseVisible(String courseName) {
        scrollToPopularCoursesSection();
        WebElement course = waitUtils.waitForPresence(courseByName(courseName));
        return waitUtils.scrollAndVerifyVisible(course);
    }

    @Step("Get displayed text of course '{0}'")
    public String getCourseText(String courseName) {
        WebElement course = waitUtils.waitForPresence(courseByName(courseName));
        return course.getText().trim();
    }
}
