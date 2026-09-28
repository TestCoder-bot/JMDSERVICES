package tests;

import base.BaseTest;
import pages.HomePage;
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
@Feature("Home Page")
public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void goToHomePage() {
        navigateTo(ConfigReader.getBaseUrl());
        homePage = new HomePage(driver);
    }

    @Test(description = "Validate 'Advanced Microsoft Office' course is visible after scrolling")
    @Story("Popular Courses")
    @Severity(SeverityLevel.NORMAL)
    @Description("Scrolls to the Popular Courses section and asserts the 'Advanced Microsoft Office' course is displayed.")
    public void validateAdvancedMicrosoftOfficeCourseIsVisible() {
        Assert.assertTrue(homePage.isCourseVisible("Advanced Microsoft Office"),
                "'Advanced Microsoft Office' course is not visible on the Home page");
    }

    @Test(description = "Validate 'MS Excel & MS Word' course is visible after scrolling")
    @Story("Popular Courses")
    @Severity(SeverityLevel.NORMAL)
    @Description("Scrolls to the Popular Courses section and asserts the 'MS Excel & MS Word' course is displayed.")
    public void validateMsExcelAndMsWordCourseIsVisible() {
        Assert.assertTrue(homePage.isCourseVisible("MS Excel & MS Word"),
                "'MS Excel & MS Word' course is not visible on the Home page");
    }

    @Test(description = "Validate 'Power Point & Power BI' course is visible after scrolling")
    @Story("Popular Courses")
    @Severity(SeverityLevel.NORMAL)
    @Description("Scrolls to the Popular Courses section and asserts the 'Power Point & Power BI' course is displayed.")
    public void validatePowerPointAndPowerBiCourseIsVisible() {
        Assert.assertTrue(homePage.isCourseVisible("Power Point & Power BI"),
                "'Power Point & Power BI' course is not visible on the Home page");
    }
}
