package tests;

import base.BaseTest;
import pages.AboutPage;
import utils.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

@Epic("JMD Service Website")
@Feature("About Page")
public class AboutPageTest extends BaseTest {

    private AboutPage aboutPage;

    @BeforeMethod(alwaysRun = true)
    public void goToAboutPage() {
        navigateTo(ConfigReader.getAboutUrl());
        aboutPage = new AboutPage(driver);
    }

    @Test(description = "Validate every 'Read More' element on the About page is clickable")
    @Story("Read More links")
    @Severity(SeverityLevel.CRITICAL)
    @Description("The About page repeats a 'Read More' call-to-action for each service block. "
            + "This asserts each one is present, displayed, enabled and clickable.")
    public void validateReadMoreIsClickable() {
        List<WebElement> readMoreElements = aboutPage.getReadMoreElements();

        Assert.assertFalse(readMoreElements.isEmpty(), "No 'Read More' elements found on the About page");

        for (int i = 0; i < readMoreElements.size(); i++) {
            WebElement element = readMoreElements.get(i);
            boolean clickable = aboutPage.isReadMoreClickable(element, i + 1);
            logReadMoreDiagnostics(element, i + 1, clickable);

            Assert.assertTrue(clickable, "'Read More' element #" + (i + 1) + " is not clickable");
        }
    }

    @Step("'Read More' #{1} clickable = {2}")
    private void logReadMoreDiagnostics(WebElement element, int index, boolean clickable) {
        // Rendered as an Allure step purely so the report shows tag name / clickability per instance.
        String tagName = aboutPage.getReadMoreTagName(element, index);
        System.out.println("Read More #" + index + " -> tag=<" + tagName + "> clickable=" + clickable);
    }
}
