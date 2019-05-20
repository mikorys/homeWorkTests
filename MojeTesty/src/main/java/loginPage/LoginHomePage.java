package loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginHomePage {
	WebDriver driver;

	public LoginHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement usernameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(xpath="//i[@class='fa fa-2x fa-sign-in']")
	WebElement loginBtn;
	
	@FindBy(id="flash")
	WebElement loggedOutAlert;
	
	
	public void logInCredentials(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public String returnAlertElementText() {
		
		return loggedOutAlert.getText();
	}

}
