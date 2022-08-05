package pageobject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class Dashboard extends TestBase{

	public Dashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
  
  @FindBy(xpath="//div[text()='Maintenance Cases']")
  WebElement Maintenance_cases;
  
  @FindBy(xpath="//input[@id='pyGridActivePage']")
  WebElement input_page;
   
  @FindBy(xpath="//table[@id='grid-desktop-paginator']/tbody/tr/td[3]/nobr/a")
  WebElement Pagination_table;
  
  @FindBy(xpath="//button[@title='Next Page']")
  WebElement dashboard_pages;
  
  @FindBy(xpath="//a[text()='Next']")
  WebElement Next_page_link;
  

  public WebElement Click_inputPage()
  {
	return input_page; 
  }

  
  public void Click_Maintenance()
  {
//	  Actions actions = new Actions(driver);
//		// Page Up
//		actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).build().perform();
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//		wait.until(ExpectedConditions.elementToBeClickable(Maintenance_cases));
//		System.out.println("Selected "+Maintenance_cases.isDisplayed());
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click()", Maintenance_cases);
  }

  public int pagination_count() throws InterruptedException
  {
	  //Thread.sleep(3000);
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//	wait.until(ExpectedConditions.elementToBeClickable(Next_page_link));
	   int count=0;
	   
	   for (int i=1;i<=5;i++) {
		   Thread.sleep(3000);
		   dashboard_pages.click();
	   }
	   
	   
//	   List<WebElement> allLinks = Pagination_table.findElements(By.tagName("a"));
//	   
//	   int size=allLinks.size();
//	   for (int i=1;i<=size;i++) {
//		   allLinks.get(i).click();
//	   }
	   
//	   for(WebElement link:allLinks)
//	   {
//		   System.out.println(link.getText() + " - " + link.getAttribute("href"));
//	   }
	   

	   return count;
  }
  
  public void traverse_page()
  {
	  
  }
    
}
