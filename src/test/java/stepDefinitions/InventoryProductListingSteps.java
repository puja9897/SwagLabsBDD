package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryProductListing;
import pages.LoginPage;
import utility.ConfigDataProvider;

public class InventoryProductListingSteps {

	WebDriver driver;
	LoginPage login;
	ConfigDataProvider config;
	InventoryProductListing inventory;
	

	public InventoryProductListingSteps() {
		this.driver = Hooks.driver; // driver initialized in @Before
	}

	@Given("User is in Swag labs website")
	public void user_is_in_swag_labs_website() {
		login=new LoginPage(driver);
		config=new ConfigDataProvider();
		inventory=new InventoryProductListing(driver);
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		
		
		login.enterLoginCredentials(config.getProperty("username"),config.getProperty("password"));
		login.clickLoginBtn();
	}

	@Then("User should be navigated to inventory page")
	public void user_should_be_navigated_to_inventory_page() {
		
		Assert.assertTrue(inventory.isLoginSuccessful(), "Login failed");
	}

	@Then("All products should be displayed")
	public void all_products_should_be_displayed() {
		inventory.isAllProductsDisplayed();
	}

	@When("User clicks on product image")
	public void user_clicks_on_product_image() {
		inventory.clickOnProductImage(0);
	}

	@Then("Product details should be displayed")
	public void product_details_should_be_displayed() {
		Assert.assertTrue(inventory.isProductDisplayed(), "Product not displayed");
	}

	@When("User clicks on product title")
	public void user_clicks_on_product_title() {
		inventory.clickOnProductTitle(0);
	}


}
