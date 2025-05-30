package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="user-name") WebElement uname;
	@FindBy(id="password") WebElement pwd;
	@FindBy(id="login-button") WebElement loginBtn;

	@FindBy(xpath="//h3[@data-test='error']") WebElement error;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterLoginCredentials(String username,String password) {
		uname.sendKeys(username);
		pwd.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	

	public boolean isLoginFailed() {
		return error.isDisplayed();
	}
}
