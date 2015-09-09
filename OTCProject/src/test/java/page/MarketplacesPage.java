package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketplacesPage{
	public MarketplacesPage(WebDriver driver) {
//		super(driver);
		// TODO Auto-generated constructor stub
//		PageFactory.initElements(driver, this.getClass());	
		
	}

	//public MarketplacesPage(){
		
		
	//}
	
	@FindBy(id="headerTotalSecurities")
	WebElement headerTotalSecurities;
	
	public String getHeaderTotalSecuritities(){
		return headerTotalSecurities.getText();
	}
	


}
