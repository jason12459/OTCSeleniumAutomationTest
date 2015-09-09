/*
 * Created by Jason Nierenburg
 * Purpose: Add an abstraction layer web elements
 */

package framework;

import org.openqa.selenium.WebElement;

public interface IClickableWE {
	
	void click();
	
	public WebElement getWebElement();
	
	

}
