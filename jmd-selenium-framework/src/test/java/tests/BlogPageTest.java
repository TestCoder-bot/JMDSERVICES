package tests;

import base.BaseTest;
import pages.BlogPage;
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
@Feature("Blog Page")
public class BlogPageTest extends BaseTest {

    private BlogPage blogPage;

    @BeforeMethod(alwaysRun = true)
    public void goToBlogPage() {
        navigateTo(ConfigReader.getBlogUrl());
        blogPage = new BlogPage(driver);
    }

    @Test(description = "Validate the blog search field is visible after scrolling")
    @Story("Search Widget")
    @Severity(SeverityLevel.NORMAL)
    @Description("Scrolls to the 'Search Here' widget and asserts the search input field is displayed.")
    public void validateSearchFieldIsVisible() {
        Assert.assertTrue(blogPage.isSearchFieldVisible(),
                "Search field is not visible on the Blog page");
    }

    @Test(description = "Validate the blog search field is enabled")
    @Story("Search Widget")
    @Severity(SeverityLevel.MINOR)
    @Description("Asserts the search input field is enabled (usable), not just present.")
    public void validateSearchFieldIsEnabled() {
        Assert.assertTrue(blogPage.isSearchFieldEnabled(),
                "Search field is present but not enabled on the Blog page");
    }
}
