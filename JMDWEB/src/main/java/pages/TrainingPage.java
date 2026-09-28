package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Training & Skill Development page. Validates the "Our Training Philosophy"
 * heading and its accompanying image after scrolling.
 */
public class TrainingPage extends BasePage {

    private final By trainingPhilosophyHeading =
            By.xpath("//*[contains(normalize-space(.),'Our Training Philosophy')]");

    // The image file on the live site is literally named "traning-philoshpy...png"
    // (typo baked into the CMS asset), so we match on that rather than alt text.
    private final By trainingPhilosophyImage =
            By.xpath("//img[contains(@src,'traning-philoshpy')]");

    public TrainingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate 'Our Training Philosophy' heading is visible")
    public boolean isTrainingPhilosophyHeadingVisible() {
        return waitUtils.scrollAndVerifyVisible(trainingPhilosophyHeading);
    }

    @Step("Validate Training Philosophy image is visible after scrolling")
    public boolean isTrainingPhilosophyImageVisible() {
        waitUtils.scrollToElement(trainingPhilosophyHeading);
        WebElement image = waitUtils.waitForPresence(trainingPhilosophyImage);
        return waitUtils.scrollAndVerifyVisible(image);
    }
}
