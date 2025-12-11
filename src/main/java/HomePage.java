package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.HomePageElements;
import java.time.Duration;

public class HomePage extends BaseTest {

    WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

    public void closeInitialPopupIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePageElements.contBtn))).click();
        } catch (Exception ignored) {}
    }

    public void openSignInPage() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePageElements.accountList))).click();
    }
}