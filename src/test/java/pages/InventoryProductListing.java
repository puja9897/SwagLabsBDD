package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	
	@FindBy(className="inventory_item_name") List<WebElement> products;
	
	public void isAllProductsDisplayed() {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(products));
		
		System.out.println("Total products found" + products.size());
		for(WebElement item:products) {
			Assert.assertEquals(item.isDisplayed(),"Product not displayed : "+item.getText());
		}	
		
	}
}

