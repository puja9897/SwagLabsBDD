package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.InventoryProductListing;
import pages.LoginPage;
import utility.ConfigDataProvider;

public class CartSteps {

	WebDriver driver;
	InventoryProductListing inventory;
	CartPage cart;
	LoginPage login;
	ConfigDataProvider config;
	
	@Given("User is logged into Swag Labs")
	public void user_is_logged_into_swag_labs() {
		driver=Hooks.driver;
		login=new LoginPage(driver);
		config=new ConfigDataProvider();
		inventory=new InventoryProductListing(driver);
		login.enterLoginCredentials(config.getProperty("username"),config.getProperty("password"));
		login.clickLoginBtn();
	}

	@When("User clicks on add to cart for a product")
	public void user_clicks_on_add_to_cart_for_a_product() {
		
	
		inventory.addProduct(0);
	}

	@Then("Product should be added to the cart")
	public void product_should_be_added_to_the_cart() {
		cart=new CartPage(driver);
		cart.itemInCart();
	}

	@When("User clicks on remove for a product")
	public void user_clicks_on_remove_for_a_product() {

	}

	@Then("Product should be remove from the cart")
	public void product_should_be_remove_from_the_cart() {

	}

}
