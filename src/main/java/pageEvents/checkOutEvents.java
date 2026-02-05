package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class checkOutEvents extends BaseTest {
	 WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

	    // Locators from your script
	   By proceedToCheckoutBtn= By.xpath("//a[@id='nav-cart']");
       By proceedBtn= By.xpath("//input[@name='proceedToALMCheckout-foq3ZnlEaO']");
	   By continueBtn= By.xpath("(//a[@name='proceedToCheckout'][normalize-space()='Continue'])[1]");

	    /**
	     * Clicks "Proceed to Checkout" from cart page.
	     */
	    public void clickProceedToCheckout() {
	        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
	    }
	    public void proceedBtnClick() {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(proceedBtn)).click();
	    }

	    /**
	     * Clicks the "Continue" or confirm button after checkout step.
	     */
	    public void clickContinue() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn)).click();
	    }

	    /**
	     * Full checkout flow
	     */
	    public void completeCheckout() {
	        clickProceedToCheckout();
	        proceedBtnClick();
	        clickContinue();
	    }

}
