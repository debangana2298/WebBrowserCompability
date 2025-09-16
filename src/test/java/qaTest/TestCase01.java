package qaTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.ElementFetch;
import base.BaseTest;
import pageEvents.HomePage;
import pageEvents.LoginPageEvents;

public class TestCase01 extends BaseTest {
	
	ElementFetch ele;
	HomePage homePage;
	LoginPageEvents login;
	
	 @BeforeMethod
	    public void initPages() {
	        ele = new ElementFetch();
	        homePage = new HomePage();
	        login = new LoginPageEvents();
	    }
	
	@Test(priority=1)
	
	public void Crdentials() {
			login.singnInAcc();
		
	}
	
	@Test(priority=2)
	public void verification()  {
			login.verificationLogin();
	}
	
	@Test(priority=3)
	public void EnteringCredentials() {
		  
		  login.signIn();
		  
		 
	}
	
	
	
	

}
