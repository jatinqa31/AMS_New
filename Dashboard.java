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
//-----------------------------------------------------

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;


import testBase.TestBase;

public class Dashboard extends TestBase{

 public Dashboard(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
  
  @FindBy(xpath="//div[text()='Maintenance Cases']")
  WebElement Maintenance_cases;
  
  @FindBy(xpath="//input[@id='pyGridActivePage']")
  WebElement input_page;
  
  @FindBy(xpath="//table[@id='bodyTbl_right']//tr//th")
  List<WebElement> Dashboard_header_elms;
  
  @FindBy(xpath="//table[@id='bodyTbl_right']//tr")
  List<WebElement> Dashboard_table_row;
  
//  @FindBy(xpath="//table[@id='bodyTbl_right']//tr//td")
//  List<WebElement> Dashboard_rows;
  
  @FindBy(xpath="//table[@id='grid-desktop-paginator']/tbody/tr/td[3]/nobr/a")
  WebElement Pagination_table;
  
  @FindBy(xpath="//button[@title='Next Page']")
  WebElement dashboard_pages;
  
  @FindBy(xpath="//a[text()='Next']")
  WebElement Next_page_link;
  
  @FindBy(xpath="//label[@data-test-id='20141007100658002115508']")
  WebElement record_count;
  
  
  @FindBy(xpath="//a[@id='pui_filter']")
  WebElement filter_button1;
  
  @FindBy(xpath="//data-test-id[@class='20141118104047081580062-DatePicker']")
  WebElement calander1;
  
  @FindBy(xpath="//data-test-id[@class='201411181040470816801140-DatePicker']")
  WebElement calander2;
  
  public WebElement Click_inputPage()
  {
	return input_page; 
  }

  
  public void Dashboard_table()
  {
try {
	   		Thread.sleep(3000);
	   		// Let's get header first
	   		List<String> allHeaderNames = new ArrayList<String>();
	   		for (WebElement header : Dashboard_header_elms) {
	   			String headerName = header.getText();
	   			allHeaderNames.add(headerName);
	   		}
	   		// Each row will be a key value pair. So we will use LinkedHashMap so that order can be retained.All map will be added to a list.
			List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
			// Get total rows count
			// Starting from 2 as first row is header. Remember xpath index starts from 1
			System.out.println("rows count "+ Dashboard_table_row.size());
			for (int i=2; i<=Dashboard_table_row.size()-1; i++) 
			{
				// Getting specific row with each iteration	Locating only cells of specific row. Creating a map to store key-value pair data. It will be created for each iteration of row
				LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
				// Iterating each cell
				String specificRowLoc = "//table[@id='bodyTbl_right']//tr[" + i + "]";
				// Locating only cells of specific row.
				List<WebElement> allColumnsEle = Dashboard_table_row.get(i).findElements(By.tagName("td"));
				//driver.findElement(By.xpath(specificRowLoc)).findElements(By.tagName("td"));
				for (int j=0; j<allColumnsEle.size(); j++) {
					// Getting cell value
					String cellValue = allColumnsEle.get(j).getText();
					// We will put in to map with header name and value with iteration Get jth index value from allHeaderNames and jth cell value of row
					eachRowData.put(allHeaderNames.get(j), cellValue);
				}
				allTableData.add(eachRowData);// After iterating row completely, add in to list.
	   		}
			System.out.println(allTableData);	
}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
  }
  

  public void pagination_count() throws InterruptedException
  {
	  Thread.sleep(3000);
	  int recordcount=Integer.parseInt(record_count.getText())/5;
	   for (int i=1;i<=recordcount;i++) {
//		   waitExplecit(driver,4000,Next_page_link);
		   Thread.sleep(3000);
		   dashboard_pages.click();
		   Dashboard_table();
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
	   

  }
  
  
//  public void Click_Maintenance()
//  {
//	  	Actions actions = new Actions(driver);
//		// Page Up
//		actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).build().perform();
//		actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).build().perform();
//		WebDriverWait wait = new WebDriverWait(driver, 4000);
//		wait.until(ExpectedConditions.elementToBeClickable(Maintenance_cases));
//		System.out.println("Selected "+Maintenance_cases.isDisplayed());
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click()", Maintenance_cases);
//  }
  
  public void Filter1_click()
  {
	  filter_button1.click();
  }

  public void Calander1_click()
  {
	  calander1.click();
  }
  
  public void readTableDataInListOfMap(String Key) {
	  
  }
}