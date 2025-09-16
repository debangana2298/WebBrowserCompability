package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.ElementFetch;
import base.BaseTest;
import pageObjects.LoginPageElements;

public class LoginPageEvents extends BaseTest {
	
ElementFetch ele= new ElementFetch();
HomePage homePage= new HomePage();
WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5));

	
	public void signIn(){
		
		homePage.page();
		homePage.signInPage();
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageElements.nameField)));
		ele.getWebElement("XPATH", LoginPageElements.nameField).sendKeys("8617716749");	
  }
	
	public void singnInAcc() {
		
		homePage.page();
		homePage.signInPage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageElements.name)));
		ele.getWebElement("XPATH", LoginPageElements.name).sendKeys("8617716749");		
		ele.getWebElement("XPATH", LoginPageElements.continueBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageElements.password)));
		ele.getWebElement("XPATH", LoginPageElements.password).sendKeys("12345678");
		ele.getWebElement("XPATH", LoginPageElements.signBtn).click();
		
	}
	
	public void verificationLogin() {
        
        homePage.page();
		homePage.signInPage();
		ele.getWebElement("XPATH", LoginPageElements.name).sendKeys("8617716749");		
		ele.getWebElement("XPATH", LoginPageElements.continueBtn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageElements.password)));
		ele.getWebElement("XPATH", LoginPageElements.password).sendKeys("12345678");
		ele.getWebElement("XPATH", LoginPageElements.signBtn).click();
		System.out.println(ele.getWebElement("XPATH", LoginPageElements.greet).getText());
		
		
	}

}
