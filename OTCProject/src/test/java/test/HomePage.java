/**
 * Author: Jason Nierenburg
 * Creation Date May 20 2015
 * Overview: This test script covers testing the top portion of the "http://www.otcmarkets.com/stock/OTCM/quote" page
 * Test 1 - assert all items.  
 * Test 2 - output all items
 * Test 3 - validate the data
 * 
 */
package test;


import static org.testng.AssertJUnit.assertFalse;

import java.util.concurrent.TimeUnit;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.IOException;

import page.QuotePage;


public class HomePage {
	WebDriver driver;
	QuotePage objQuotePage;

	

	
	@BeforeSuite
	public void setup(){
        driver = new FirefoxDriver();
		System.out.println("starting before suite");
	//	System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe"); 
	//	driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.otcmarkets.com/stock/OTCM/quote");
        driver.manage().window().maximize();
        
        System.out.println("Finished with before suite");
        System.out.println();
	}
	

	@AfterSuite
	public void shutdown() {
		driver.close();
		System.out.println("Webdriver is closing");
		//driver.quit();
	}

	@Test(priority=1)
	//do all items exist
	
	public void test_quote_page_items_exist()
	{
		System.out.println("Starting Test1: asserting all items exist");
		
			/** left most column */
		objQuotePage = new QuotePage(driver);
		assertFalse(objQuotePage.getLastPriceChg().isEmpty());
		assertFalse(objQuotePage.getCurPrice().isEmpty());
		assertFalse(objQuotePage.getbboPrice().isEmpty());
		assertFalse(objQuotePage.getbboSize().isEmpty());
		
			/** column 2*/
		assertFalse(objQuotePage.getPrevClose().isEmpty());
		assertFalse(objQuotePage.getCurOpen().isEmpty());
			
			/** column 3*/
		assertFalse(objQuotePage.getDailyRange().isEmpty());
		assertFalse(objQuotePage.getYearRange().isEmpty());
		
			/** column 4*/
		assertFalse(objQuotePage.getVolume().isEmpty());
		assertFalse(objQuotePage.getDividend().isEmpty());
			
			/** column 5*/
		assertFalse(objQuotePage.getAverageVolume().isEmpty());
		assertFalse(objQuotePage.getNetDividend().isEmpty());			
			
			/** headers */
		assertFalse(objQuotePage.getSymbol().isEmpty());
		assertFalse(objQuotePage.getCompanyName().isEmpty());
		assertFalse(objQuotePage.getClassType().isEmpty());
		assertFalse(objQuotePage.getReportingType().isEmpty());
		assertFalse(objQuotePage.getTier().isEmpty());
		assertFalse(objQuotePage.getLawFirm().isEmpty());
		assertFalse(objQuotePage.getTradeDate().isEmpty());

		System.out.println("Finished Test1 asserting all items exist");
		System.out.println();
		
	}
	
	//output data
	@Test(priority=2)
	public void test_quote_page(){
		System.out.println("Starting Test2 outputting all data");
		objQuotePage = new QuotePage(driver);
		
		System.out.println("test is starting");
		System.out.println("Last Price Change: "+objQuotePage.getLastPriceChg());
		System.out.println("Current Price: "+objQuotePage.getCurPrice());
		System.out.println("BBO Price: "+objQuotePage.getbboPrice());
		System.out.println("BBO Size: "+objQuotePage.getbboSize());
		System.out.println("Prev Close: "+objQuotePage.getPrevClose());
		System.out.println("Open: "+objQuotePage.getCurOpen());
		System.out.println("Daily Range: "+objQuotePage.getDailyRange());
		System.out.println("Year Range: "+objQuotePage.getYearRange());
		System.out.println("Volume: "+objQuotePage.getVolume());
		System.out.println("Dividend: "+objQuotePage.getDividend());		
		System.out.println("Average Volume: "+objQuotePage.getAverageVolume());
		System.out.println("Net Dividend: "+objQuotePage.getNetDividend());
		System.out.println("symbol: "+objQuotePage.getSymbol());
		System.out.println("companyName: "+objQuotePage.getCompanyName());
		System.out.println("classType: "+objQuotePage.getClassType());
		System.out.println("reportingType: "+objQuotePage.getReportingType());
		System.out.println("tier: "+objQuotePage.getTier());
		System.out.println("lawFirm: "+objQuotePage.getLawFirm());
		System.out.println("tradeDate: "+objQuotePage.getTradeDate());
		System.out.println("Test 2 is now ending");
		System.out.println();
	}
	
	@Test(priority=3)
	//validate data
	public void test_quote_page_data_validation(){
		System.out.println("Starting Test 3: validate data");
		objQuotePage = new QuotePage(driver);
		String tempText = "";
		double tempDouble = 0;
		
		/** left most column */
		//lastPriceChg
		
		//curPrice
		tempText = objQuotePage.getCurPrice();
		if(tempText=="N/A"){
		System.out.println("curPrice is N/A");	
		}else{
			tempDouble = Double.parseDouble(tempText);
			if(tempDouble>=0){
				System.out.println("curPrice is valid");
			} else {
				System.out.println("curPrice is Invalid");
			}
		}
		//bboPrice	
		
		//bboSize
		
		/** column 2*/
		//prevClose
		tempText = objQuotePage.getPrevClose();
		try {
		if(tempText=="N/A"){
			System.out.println("prevClose is N/A");	
		}else{
			tempDouble = Double.parseDouble(tempText);
			if(tempDouble>=0){
				System.out.println("prevClose is valid");
			} else {
				System.out.println("preClose is invalid");
			}
		}
		} catch (NumberFormatException e){
			System.out.println("PrevClose is "+tempText+" and it is unknown whether this is valid");
		}
		
		//curOpen
		tempText = objQuotePage.getCurOpen();
		try {
			if(tempText=="N/A"){
				System.out.println("curOpen is N/A");	
			}else{
				tempDouble = Double.parseDouble(tempText);
				if(tempDouble>=0){
					System.out.println("curOpen is valid");
				} else {
					System.out.println("curOpen is invalid");
				}
			}
		} catch (NumberFormatException e){
			System.out.println("curOpen is "+tempText+" and it is unknown whether this is valid");
		}
		
		/** column 3*/
		//dailyRange
		
		//yearRange
		
		/** column 4*/
		//volume
		tempText = objQuotePage.getVolume();
		try {
		if(tempText=="N/A"){
			System.out.println("Volume is N/A");	
		}else{
			tempDouble = Double.parseDouble(tempText);
			if(tempDouble>=0){
				System.out.println("Volume is valid");
			} else {
				System.out.println("Volume is invalid");
			}
		}
		} catch (NumberFormatException e){
			System.out.println("Volume is "+tempText+" and it is unknown whether this is valid");
		}
		
		//dividend
		tempText = objQuotePage.getDividend();
		try {
		if(tempText=="N/A"){
			System.out.println("Dividend is N/A");	
		}else{
			tempDouble = Double.parseDouble(tempText);
			if(tempDouble>=0){
				System.out.println("Dividend is valid");
			} else {
				System.out.println("Dividend is invalid");
			}
		}
		} catch (NumberFormatException e){
			System.out.println("Dividend is "+tempText+" and it is unknown whether this is valid");
		}
		
		/** column 5*/
		//averageVolume
		tempText = objQuotePage.getAverageVolume();
		try {
		if(tempText=="N/A"){
			System.out.println("averageVolume is N/A");	
		}else{
			tempDouble = Double.parseDouble(tempText);
			if(tempDouble>=0){
			System.out.println("averageVolume is valid");
			} else {
				System.out.println("averageVolume is invalid");
			}
		}
		} catch (NumberFormatException e){
			System.out.println("averageVolume is "+tempText+" and it is unknown whether this is valid");
		}
		
		//netDividend
		tempText = objQuotePage.getDividend();
		try {
		if(tempText=="N/A"){
			System.out.println("Dividend is N/A");	
		}else{
			tempDouble = Double.parseDouble(tempText);
			if(tempDouble>=0){
			System.out.println("Net Dividend is valid");
			} else {
				System.out.println("Net Dividend is invalid");
			}
		}
		} catch (NumberFormatException e){
			System.out.println("Net Dividend is "+tempText+" and it is unknown whether this is valid");
		}
		/** headers */
		//symbol
		
		//companyName
		
		//classType
		
		//reportingType
		
		//tier
		
		//lawFirm
		
		//tradeDate
		
		System.out.println("Test 3 is now ending");
		System.out.println();
	}

	
	
}
