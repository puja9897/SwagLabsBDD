package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryProductListing {

	WebDriver driver;
	
	public InventoryProductListing(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="inventory_container") WebElement inventory;
	
	public boolean isLoginSuccessful() {
		return inventory.isDisplayed();
	}
}
