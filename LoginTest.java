package Smoke;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.TestAllureListener;
import pageobject.Homepage;
import pageobject.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import testBase.TestBase;

@Listeners({listeners.TestAllureListener.class})
public class LoginTest extends TestBase{
	SoftAssert sa = new SoftAssert();
	public static int count=0;
	

	
	@Test(priority=1,description="Verify_Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Title")
	
	public void Verify_Title() 
	{
		//assert.assertTrue(false);
		sa.assertEquals(driver.getTitle(),"Login Page" );
		sa.assertAll();
	}
	
	@Test(priority=2,dependsOnMethods="Verify_Title")
	public void Login_with_Invalid_credentials() 
	{
		LoginPage lp = new LoginPage(driver);
		//System.out.println("Login with invalid credentials");
		lp.EnterUsernam("wrong_username");
		lp.EnterPswd("pswddfhdg");
		lp.Login_click();
		String error_msg=lp.read_error();
		sa.assertEquals(error_msg,"The information you entered was not recognized" );
		sa.assertAll();
	}	
	
	@Test(priority=3)
	public void Login_with_Valid_credentials() 
	{
		LoginPage lp = new LoginPage(driver);
		Homepage hp= new Homepage(driver);
		//System.out.println("Login with valid credentials");
		lp.EnterUsernam("MaintenanceInCharge_4");
		lp.EnterPswd("rules");
		lp.Login_click();
		sa.assertEquals(driver.getTitle(),"AMS Portal");
		sa.assertAll();
		hp.Click_dashboard();
	}
	
}
