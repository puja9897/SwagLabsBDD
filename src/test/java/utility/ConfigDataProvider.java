package utility;

import java.io.InputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		try {
			InputStream fis = getClass().getClassLoader().getResourceAsStream("config.properties");
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Not able to load config file: " + e.getMessage());
		}
	}

	public String getURL() {
		return pro.getProperty("url");
	}

	public String getBrowser() {
		return pro.getProperty("browser");
	}
	
	public String getProperty(String key) {
		return pro.getProperty(key);
		
	}
}
