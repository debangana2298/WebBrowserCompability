package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class addToCartEvents extends BaseTest {

    WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

    // Locators from your given flow
    public By chickenAddBtn = By.xpath("//button[@id='a-autoid-3-announce']");
    public By pastaAddBtn= By.xpath("//button[@id='a-autoid-5-announce']");
    By coffeeOption = By.xpath("//div[@aria-label='coffee powder in fresh']");
    By addToCartCoffeeBtn = By.xpath("//button[@id='a-autoid-6-announce']");
    

   
    public void addChickenToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(chickenAddBtn)).click();
    }

   
    public void addPastaToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(pastaAddBtn)).click();
    }

  
    public void addCoffeeToCart() {
        // Select coffee from the dropdown
        wait.until(ExpectedConditions.elementToBeClickable(coffeeOption)).click();

        // Add coffee to cart
        wait.until(ExpectedConditions.elementToBeClickable(addToCartCoffeeBtn)).click();
    }

}