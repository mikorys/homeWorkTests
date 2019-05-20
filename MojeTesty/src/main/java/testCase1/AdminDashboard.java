package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboard extends BaseLoginPage {
	WebDriver driver;

	public AdminDashboard(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Manage organisations')]")
	WebElement organisationsBookmark;
	
	public void selectOrganisationsBookmark()
	{
		organisationsBookmark.click();
		
	}
	
	
	
	
	
	
	
}
