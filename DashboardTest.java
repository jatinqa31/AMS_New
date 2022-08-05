package Smoke;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.TestAllureListener;
import pageobject.Dashboard;
import pageobject.Homepage;
import pageobject.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import testBase.TestBase;

@Listeners({listeners.TestAllureListener.class})
public class DashboardTest extends TestBase{
	
//	public DashboardTest() throws IOException {
//        super();
//    }
	
	SoftAssert sa = new SoftAssert();
	public static int count=0;
	
	//Dashboard dp1 = new Dashboard(TestBase.driver);
	
	Dashboard dp1;

	@BeforeClass//With this code null pointer java.lang.NullPointerException: Cannot invoke "pageobject.Dashboard.Click_inputPage()" because "this.dp1" is null
	public void initTest(){
	   dp1  = PageFactory.initElements(driver, Dashboard.class);
	}
	
	
	@Test(priority=1,description="Verify_Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Title")
	
	public void Verify_Dashboard_Title() 
	{
		sa.assertEquals(driver.getTitle(),"AMS Portal" );
		sa.assertAll();
	}
	
	@Test(priority=2,dependsOnMethods="Verify_Dashboard_Title")
	public void Click_Maintenance_cases() 
	{
	try {
		Thread.sleep(7000);
			System.out.println("Dashboard "+dp1);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Actions actionObj = new Actions(driver);
			actionObj.keyUp(Keys.CONTROL).sendKeys(Keys.UP).build().perform();
		    Actions a= new Actions(driver);
		    a.sendKeys(Keys.PAGE_DOWN).build().perform();
//			JavascriptExecutor jse = (JavascriptExecutor)driver;
//			jse.executeScript("window.scrollTo(0,-document.body.scrollLeft)");

//			js.executeScript("window.scrollBy(0,-250)", "");
			Actions actions = new Actions(driver);
			// Page Up
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).build().perform();
			dp1.Click_inputPage().sendKeys("2");
			dp1.Click_Maintenance();
			dp1.pagination_count();
		}
		catch(Exception e) {
			//System.out.println("Cause of  " + e.getCause());
			e.printStackTrace();
		}
	}	
	
	@Test(priority=3)
	public void Traverse_pages() 
	{
		Dashboard dp = new Dashboard(driver);
//		for(int i=1;i<dp.pagination_count();i++) {
//			driver.get("https://www.gmail.com");
//			driver.get("https://www.facebook.com");
//			driver.get("https://www.pizzahut.com");
//			driver.get("https://www.gmail.com");
//		}
	}	
	
}
