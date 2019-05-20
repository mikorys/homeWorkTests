package loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAfterLogin {
	WebDriver driver;

	public PageAfterLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	@FindBy(xpath="//div[@id='flash']")
	WebElement alert;
	
	@FindBy(xpath="//a[@class='button secondary radius']")
	WebElement logOutBtn;
	
	
	
	public String returnAlertElementText() {
		
		return alert.getText();
	}
	
	public void clickLogOutBtn() {
		logOutBtn.click();
	}	
	
	
	 
}
