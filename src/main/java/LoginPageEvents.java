package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import base.BaseTest;
import pageObjects.LoginPageElements;
import Utilities.ElementFetch;

public class LoginPageEvents extends BaseTest {

    ElementFetch ele = new ElementFetch();
    WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageElements.name)));
        ele.getWebElement("XPATH", LoginPageElements.name).sendKeys(phone);
        ele.getWebElement("XPATH", LoginPageElements.continueBtn).click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageElements.password)));
        ele.getWebElement("XPATH", LoginPageElements.password).sendKeys(password);
        ele.getWebElement("XPATH", LoginPageElements.signBtn).click();
    }

    public void verifyLoginSuccess() {
        String greet = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(LoginPageElements.greet)
                )).getText();

        Assert.assertTrue(greet.contains("Hello"), "Login failed — Greeting not displayed");
    }
}
