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
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.visibilityOfAllElements(cartItem));
		Assert.assertTrue(cartItem.size() > 0, "No items in the cart.");
	}
	public void itemNotInCart() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.invisibilityOfAllElements(cartItem));
	    Assert.assertTrue(cartItem.size() == 0, "Item is still present in the cart.");
	}
}
