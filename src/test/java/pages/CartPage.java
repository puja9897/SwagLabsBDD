package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

	WebDriver driver;
	@FindBy(className = "app_logo")
	WebElement CartAppLogo;
	@FindBy(className = "cart_item")
	List<WebElement> cartItem;

	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void itemInCart() {
		Assert.assertTrue(cartItem.size() > 0, "No items in the cart.");
	}
}
