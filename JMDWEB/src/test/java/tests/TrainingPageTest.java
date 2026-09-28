package tests;

import base.BaseTest;
import pages.TrainingPage;
import utils.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("JMD Service Website")
@Feature("Training Page")
public class TrainingPageTest extends BaseTest {

    private TrainingPage trainingPage;

    @BeforeMethod(alwaysRun = true)
    public void goToTrainingPage() {
        navigateTo(ConfigReader.getTrainingUrl());
        trainingPage = new TrainingPage(driver);
    }

    @Test(description = "Validate 'Our Training Philosophy' heading is visible after scrolling")
    @Story("Training Philosophy")
    @Severity(SeverityLevel.MINOR)
    @Description("Scrolls to and asserts the 'Our Training Philosophy' heading is displayed.")
    public void validateTrainingPhilosophyHeadingIsVisible() {
        Assert.assertTrue(trainingPage.isTrainingPhilosophyHeadingVisible(),
                "'Our Training Philosophy' heading is not visible on the Training page");
    }

    @Test(description = "Validate 'Our Training Philosophy' image is visible after scrolling")
    @Story("Training Philosophy")
    @Severity(SeverityLevel.NORMAL)
    @Description("Scrolls to the training philosophy section and asserts its accompanying image is displayed.")
    public void validateTrainingPhilosophyImageIsVisible() {
        Assert.assertTrue(trainingPage.isTrainingPhilosophyImageVisible(),
                "Training Philosophy image is not visible on the Training page");
    }
}
