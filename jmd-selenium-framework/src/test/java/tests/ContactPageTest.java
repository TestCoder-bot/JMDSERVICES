package tests;

import base.BaseTest;
import pages.ContactPage;
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
@Feature("Contact Page")
public class ContactPageTest extends BaseTest {

    private ContactPage contactPage;

    @BeforeMethod(alwaysRun = true)
    public void goToContactPage() {
        navigateTo(ConfigReader.getContactUrl());
        contactPage = new ContactPage(driver);
    }

    @Test(description = "Validate phone number is available on the Contact page")
    @Story("Contact Details")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Asserts the phone number '+91 78272-78738' is displayed on the Contact page.")
    public void validatePhoneNumberIsAvailable() {
        Assert.assertTrue(contactPage.isPhoneNumberDisplayed(),
                "Phone number is not displayed on the Contact page");
    }

    @Test(description = "Validate email is available on the Contact page")
    @Story("Contact Details")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Asserts the (Cloudflare-obfuscated) email link is displayed on the Contact page.")
    public void validateEmailIsAvailable() {
        Assert.assertTrue(contactPage.isEmailDisplayed(),
                "Email is not displayed on the Contact page");
    }

    @Test(description = "Validate corporate office address is available on the Contact page")
    @Story("Contact Details")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Asserts the corporate office address ('Gaur City Mall, Greater Noida') is displayed.")
    public void validateAddressIsAvailable() {
        Assert.assertTrue(contactPage.isAddressDisplayed(),
                "Corporate office address is not displayed on the Contact page");
    }
}
