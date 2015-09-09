package framework;

import static org.testng.Assert.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyFile {
	
	private Properties properties;
	
	public PropertyFile(){
		
	}
	
	//read property file
	public void readPropertyFile(final String filePath){
		try{
			InputStream propStream = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(propStream);
		} catch (IOException e){
			fail("File loading problem: " + e.getMessage());
		}
		
	}
	
	//get web app url
	public String getWebAppURL(){
		return properties.getProperty("webAppURL");
	}
	
	//get timeout in ms
	public int getTimeoutInMillis(){
		return (Integer.parseInt(properties.getProperty("timeoutInSeconds"))* 1000);
	}
	
	//get browser driver
	public String getBrowserDriver(){
		return properties.getProperty("browserDriver");
	}
	

}
