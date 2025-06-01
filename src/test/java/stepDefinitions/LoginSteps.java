package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryProductListing;
import pages.LoginPage;

public class LoginSteps {

	WebDriver driver;
	LoginPage login;
	InventoryProductListing inventory;

	@Given("User is in Swag Labs login page")
	public void user_is_in_swag_labs_login_page() {
		this.driver = Hooks.driver;
	    if (driver == null) {
	        throw new IllegalStateException("Driver is not initialized in Hook.");
	    }
		login = new LoginPage(driver);

	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String password) {

		login.enterLoginCredentials(username, password);
	}

	@And("Click on Login Button")
	public void click_on_login_button() {
		login.clickLoginBtn();
	}

	@Then("User should be able to login successfully")
	public void user_should_be_able_to_login_successfully() {

		inventory=new InventoryProductListing(driver);
	    if (!inventory.isLoginSuccessful()) {
	        throw new AssertionError("Login failed! Inventory page not displayed.");
	}}

	@Then("User should see an error message")
	public void user_should_see_an_error_message() {
		 if (!login.isLoginFailed()) {
		        throw new AssertionError("Login error message not displayed!");
		    }
	}
}
