package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebTest {
	
	public WebDriver driver;

	
	public WebTest(){

		
	}
	
	@BeforeClass
	public void setup(){
		PropertyFile properties = new PropertyFile();
		properties.readPropertyFile("src//main//resources//config.properties");
		
		String url = properties.getWebAppURL();
		int timeOut = properties.getTimeoutInMillis();
		String browser = properties.getBrowserDriver().intern();

		System.out.println("URL: "+url);
		System.out.println("Timeout in ms: "+timeOut);
		System.out.println("browser type: "+browser);
		
		if (properties.getBrowserDriver().intern()=="IE"){
				
				System.setProperty("webdriver.ie.driver", "src//main//resources//IEDriverServer32.exe"); 
				driver = new InternetExplorerDriver();
		}
		else if(properties.getBrowserDriver().intern()=="Chrome"){
				System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe"); 
				driver = new ChromeDriver();			
		}
		else if(properties.getBrowserDriver().intern()=="Firefox"){
			driver = new FirefoxDriver();
		}
		else{
			System.out.println("Unable to determine the type of browser please check config.properties file");
			driver.quit();
		}
		
		
        
		System.out.println("starting before Class");

        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        
        System.out.println("Finished with before Class");
        System.out.println();
	}
	

	@AfterClass
	public void shutdown() {
		driver.close();
		System.out.println("Webdriver is closing");
	}

}
