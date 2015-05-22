/**
 * Author: Jason Nierenburg
 * Created Date: May 20 2015
 * Overview: This page script covers all items in the top portion of the "http://www.otcmarkets.com/stock/OTCM/quote"
 * This includes methods used to get the values from the webelements
 */
package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotePage {
	//WebDriver driver;

	
	/** left most column */
	@FindBy(className="lastPriceChg")
	WebElement lastPriceChg;
	@FindBy(className="price")
	WebElement curPrice;
	@FindBy(className="bboPrice")
	WebElement bboPrice;
	@FindBy(className="bboSize")
	WebElement bboSize;
	
	/** column 2*/
	@FindBy(className="value")
	WebElement prevClose;
	@FindBy(css="div.panel:nth-child(1) > span:nth-child(4)")
	WebElement curOpen;
	
	/** column 3*/
	@FindBy(css="div.panel:nth-child(2) > span:nth-child(2)")
	WebElement dailyRange;
	@FindBy(css="div.panel:nth-child(2) > span:nth-child(4)")
	WebElement yearRange;
	
	/** column 4*/
	@FindBy(css="div.panel:nth-child(3) > span:nth-child(2)")
	WebElement volume;
	@FindBy(css="div.panel:nth-child(3) > span:nth-child(4) > span:nth-child(1)")
	WebElement dividend;
	
	/** column 5*/
	@FindBy(css="div.panel:nth-child(4) > span:nth-child(2)")
	WebElement averageVolume;
	@FindBy(css="div.panel:nth-child(4) > span:nth-child(4)")
	WebElement netDividend;
	
	
	
	
	
	/* Headers */
	//symbol
	@FindBy(css=".quote-symbol > h3:nth-child(1)")
	WebElement symbol;
	
	//companyName
	@FindBy(css="#xcompanyInfo > h3:nth-child(1)")
	WebElement companyName;
	
	//class type
	@FindBy(css=".shareType")
	WebElement classType;
	
	//reporting type
	@FindBy(css="#reportingStandard")
	WebElement reportingType;
	
	//tier
	@FindBy(css=".tier")
	WebElement tier;
	
	//lawfirm
	@FindBy(css=".dadPal")
	WebElement lawFirm;
	
	//Trade date / time
	@FindBy(css="#tradeTime")
	WebElement tradeDate;
	
	public QuotePage(WebDriver driver){
//		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	/* METHODS */
	//Get objects from QuotePage
	/** left most column */
	public String getLastPriceChg(){
		return lastPriceChg.getText();
	}
	public String getCurPrice(){
		return curPrice.getText();
	}
	public String getbboPrice(){
		return bboPrice.getText();
	}
	public String getbboSize(){
		return bboSize.getText();
	}
	
	/** column 2*/
	public String getPrevClose(){
		return prevClose.getText();
	}
	public String getCurOpen(){
		return curOpen.getText();
	}
	
	/** column 3*/
	public String getDailyRange(){
		return dailyRange.getText();
	}
	public String getYearRange(){
		return yearRange.getText();
	}
	
	/** column 4*/
	public String getVolume(){
		return volume.getText();
	}
	public String getDividend(){
		return dividend.getText();
	}
	
	/** column 5*/
	public String getAverageVolume(){
		return averageVolume.getText();
	}
	public String getNetDividend(){
		return netDividend.getText();
	}
	
	/** headers */
	//symbol
	public String getSymbol(){
		return symbol.getText();
	}
	
	//companyName
	public String getCompanyName(){
		return companyName.getText();
	}
	
	//class type
	public String getClassType(){
		return classType.getText();
	}
	//reporting type
	public String getReportingType(){
		return reportingType.getText();
	}
	//tier
	public String getTier(){
		return tier.getText();
	}
	//lawfirm
	public String getLawFirm(){
		return lawFirm.getText();
	}
	//Trade date / time
	public String getTradeDate(){
		return tradeDate.getText();
	}
}
