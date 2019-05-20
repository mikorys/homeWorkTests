package testCase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCase1.BaseLoginPage;

public class ManageDashboard extends BaseLoginPage{
	WebDriver driver;
	
	public ManageDashboard(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='page']//li[1]//a[1]")
	WebElement certificationCompletion;
	
	public void clickctificationCompletion() {
		certificationCompletion.click();
	}
	
	
	

}
