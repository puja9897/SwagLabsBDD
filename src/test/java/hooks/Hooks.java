package hooks;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.Browser;
import utility.ConfigDataProvider;

public class Hooks {

	public static WebDriver driver;
	ConfigDataProvider config;
	Browser browser;
	
	@Before
	public void launchSwagLabs() {

		try {
			if(driver==null) {
			config = new ConfigDataProvider();
			browser = new Browser();
			 System.out.println("Browser selected: " + config.getBrowser());
			 
			driver = browser.openBrowser(config.getBrowser());
            System.out.println("Driver launched: " + driver); // Debug log

			driver.get(config.getURL());
			System.out.println("Navigated to: " + config.getURL());
		}} catch (Exception e) {
            System.out.println("Exception in launchSwagLabs: " + e.getMessage());
            e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
			driver=null;
            System.out.println("Driver closed.");

		}
	}
}