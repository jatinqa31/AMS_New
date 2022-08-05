package pageobject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class Homepage extends TestBase{

	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
  
  @FindBy(xpath="//li[@data-test-id='dynamic-nav-menu_2']")
  WebElement Dashboard_link;
 
  
  public void Click_dashboard()
  {
//	WebDriverWait wait = new WebDriverWait(driver, 15);
//	WebElement wb = product_btn();
//	wb=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='mm_products']//a[@class='dropmenu']")));
	  Dashboard_link.click();
  }


  
}
