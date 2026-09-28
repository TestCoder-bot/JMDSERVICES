package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contact Us page. Validates the phone number, email (Cloudflare-obfuscated
 * mailto link) and corporate office address are present.
 */
public class ContactPage extends BasePage {

    private final By phoneNumber = By.xpath("//*[contains(text(),'78272-78738')]");

    // Cloudflare email-protection renders the mailto link as
    // <a href=".../cdn-cgi/l/email-protection#...">, decoded client-side by its JS.
    private final By emailLink = By.cssSelector("a[href*='email-protection']");

    private final By address = By.xpath("//*[contains(normalize-space(.),'Gaur City Mall')]");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate phone number is displayed")
    public boolean isPhoneNumberDisplayed() {
        return waitUtils.scrollAndVerifyVisible(phoneNumber);
    }

    @Step("Validate email link is displayed")
    public boolean isEmailDisplayed() {
        return waitUtils.scrollAndVerifyVisible(emailLink);
    }

    @Step("Get email link text/href")
    public String getEmailHref() {
        WebElement element = waitUtils.waitForPresence(emailLink);
        return element.getAttribute("href");
    }

    @Step("Validate corporate office address is displayed")
    public boolean isAddressDisplayed() {
        return waitUtils.scrollAndVerifyVisible(address);
    }
}
