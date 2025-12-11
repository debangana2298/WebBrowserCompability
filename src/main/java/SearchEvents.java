package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import java.time.Duration;

import base.BaseTest;

public class SearchEvents extends BaseTest {

    WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

    By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
    By searchBtn = By.xpath("//input[@id='nav-search-submit-button']");
    By coffeeOption = By.xpath("//div[@aria-label='coffee powder in fresh']");

    public void searchProduct(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys(product);
        driver.findElement(searchBtn).click();
    }
    
    public void selectCoffeeFreshOption(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys(product); // only type
    	}

    public void clearSearch() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox))
                .sendKeys(Keys.CONTROL, "a", Keys.DELETE);
    }
    
    

    public void verifySearchResults(String expectedKeyword) {
        String title = driver.getTitle();
        Assert.assertTrue(title.toLowerCase().contains(expectedKeyword.toLowerCase()),
                "Search failed — keyword not present in title");
    }
}