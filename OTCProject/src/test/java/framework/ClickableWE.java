/*Created by Jason Nierenburg
 * Purpose: Split up web element into different types and create abstraction layer for web elements via an interface
 */

package framework;



import org.openqa.selenium.WebElement;

//button, radio button, link
public class ClickableWE implements IClickableWE{

	
	
	private WebElement we;
	
	public ClickableWE(final WebElement element){
		we = element;
	}
	
	



	public void click() {
		System.out.println("zztest interface / clickable");
		we.click();

	}


	
	public WebElement getWebElement() {
		return we;
		// TODO Auto-generated method stub
		
	}
		
	

}
