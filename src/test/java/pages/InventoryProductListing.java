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
	WebDriverWait wait;
	
	public InventoryProductListing(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="inventory_container") WebElement inventory;
	
	public boolean isLoginSuccessful() {
		return inventory.isDisplayed();
	}
	
	@FindBy(className="inventory_item_name") List<WebElement> products;
	
	public void isAllProductsDisplayed() {
		
		
		wait.until(ExpectedConditions.visibilityOfAllElements(products));
		
		System.out.println("Total products found" + products.size());
		for(WebElement item:products) {
			Assert.assertTrue(item.isDisplayed(),"Product not displayed : "+item.getText());
		}	
		
	}
	
	@FindBy(css = ".inventory_item_img") List<WebElement> productimages;
	
	public void clickOnProductImage(int index) {
		productimages.get(index).click();
	}
	
	@FindBy(className="inventory_details_name") WebElement productDetailsTitle;
	
	public boolean isProductDisplayed() {
		
		wait.until(ExpectedConditions.visibilityOf(productDetailsTitle));

		return productDetailsTitle.isDisplayed();
	}
	
	@FindBy(className="inventory_item_name") List<WebElement> productTitle;
	
	public void clickOnProductTitle(int index) {
		productTitle.get(index).click();
	}
}

