package pageEvents;
import pageObjects.HomePageElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ElementFetch;
import base.BaseTest;

public class HomePage extends BaseTest {
	
ElementFetch ele= new ElementFetch();

public void BaseTest(WebDriver driver) {
    base.BaseTest.driver = driver;
}

public void page() {
	
	 try {
	        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePageElements.contBtn))).click();
	        
	    } catch (TimeoutException e) {
	        
	    }
}
	
	public void signInPage() {
		
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePageElements.accountList))).click();
		
	}


}
