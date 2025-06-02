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

	@FindBy(css = "button.btn_inventory")
	List<WebElement> buttons; // Add to cart and Remove share same class
	@FindBy(className = "shopping_cart_link")
	private WebElement cart;

	public void addProduct(int index) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfAllElements(productTitle));
	    buttons.get(index).click();
	    wait.until(ExpectedConditions.textToBePresentInElement(buttons.get(index), "Remove"));
	}

	public void removeProduct(int index) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfAllElements(productTitle));
	    buttons.get(index).click();
	    wait.until(ExpectedConditions.textToBePresentInElement(buttons.get(index), "Add to cart"));
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

	public void clickOnCart() {
		cart.click();
	}
}
