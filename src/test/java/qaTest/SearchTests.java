package qaTest;


import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.HomePage;
import pageEvents.LoginPageEvents;
import pageEvents.SearchEvents;
import pageEvents.addToCartEvents;
import pageEvents.checkOutEvents;

public class SearchTests extends BaseTest {

    @Test
    public void searchChicken() {

        HomePage home = new HomePage();
        LoginPageEvents login = new LoginPageEvents();
        SearchEvents search = new SearchEvents();
        addToCartEvents add = new addToCartEvents();
        checkOutEvents checkout = new checkOutEvents();

        home.closeInitialPopupIfPresent();
        home.openSignInPage();

        login.enterPhone("8617716749");
        login.enterPassword("12345678");
        login.verifyLoginSuccess();

        search.searchProduct("chicken breast boneless");
        search.verifySearchResults("chicken");
        add.addChickenToCart();
        
        search.clearSearch();
        search.searchProduct("pasta");
        search.verifySearchResults("pasta");
        add.addPastaToCart();
        
        search.clearSearch();
        search.selectCoffeeFreshOption("coffee");
        add.addCoffeeToCart();
        
        checkout.completeCheckout();
        
        
        
    }
}
