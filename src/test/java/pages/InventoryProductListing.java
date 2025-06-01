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

	@FindBy(id = "inventory_container")
	WebElement inventory;
	@FindBy(className = "inventory_item_name")
	List<WebElement> products;
	@FindBy(css = ".inventory_item_img")
	List<WebElement> productimages;
	@FindBy(className = "inventory_details_name")
	WebElement productDetailsTitle;
	@FindBy(className = "inventory_item_name")
	List<WebElement> productTitle;
	@FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
	private List<WebElement> AddtoCartBtn;
	@FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory ")
	private List<WebElement> RemoveBtn;

	public void addProduct(int index) {
		AddtoCartBtn.get(index).click();
	}

	public void removeProduct(int index) {
		RemoveBtn.get(index).click();
	}

	public InventoryProductListing(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	public boolean isLoginSuccessful() {
		return inventory.isDisplayed();
	}

	public void isAllProductsDisplayed() {

		wait.until(ExpectedConditions.visibilityOfAllElements(products));

		System.out.println("Total products found" + products.size());
		for (WebElement item : products) {
			Assert.assertTrue(item.isDisplayed(), "Product not displayed : " + item.getText());
		}

	}

	public void clickOnProductImage(int index) {
		productimages.get(index).click();
	}

	public boolean isProductDisplayed() {

		wait.until(ExpectedConditions.visibilityOf(productDetailsTitle));

		return productDetailsTitle.isDisplayed();
	}

	public void clickOnProductTitle(int index) {
		productTitle.get(index).click();
	}
}
