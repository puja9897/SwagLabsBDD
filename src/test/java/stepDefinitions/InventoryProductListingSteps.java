package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utility.ConfigDataProvider;

public class InventoryProductListingSteps {

	WebDriver driver;
	LoginPage login;
	ConfigDataProvider config;
	
	@Given("User is in Swag labs website")
	public void user_is_in_swag_labs_website() {
		driver=Hooks.driver;
		login=new LoginPage(driver);
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		config=new ConfigDataProvider();
		login.enterLoginCredentials(config.getProperty("username"),config.getProperty("password"));
		login.clickLoginBtn();
	}

	@Then("User should be navigated to inventory page")
	public void user_should_be_navigated_to_inventory_page() {

	}

	@Then("All products should be displayed")
	public void all_products_should_be_displayed() {

	}

	@When("User clicks on product image")
	public void user_clicks_on_product_image() {

	}

	@Then("Product details should be displayed")
	public void product_details_should_be_displayed() {

	}

	@When("User clicks on product title")
	public void user_clicks_on_product_title() {

	}


}
