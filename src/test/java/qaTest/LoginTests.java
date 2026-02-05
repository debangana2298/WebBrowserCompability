package qaTest;

import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.HomePage;
import pageEvents.LoginPageEvents;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() {

        HomePage home = new HomePage();
        LoginPageEvents login = new LoginPageEvents();

        home.closeInitialPopupIfPresent();
        home.openSignInPage();

        login.enterPhone("8617716749");
        login.enterPassword("12345678");

        login.verifyLoginSuccess();
    }
}