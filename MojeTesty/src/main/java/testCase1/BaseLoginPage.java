package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseLoginPage {
	WebDriver driver;

	public BaseLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='Administrator']")
	WebElement adminLogin;
	
	@FindBy(xpath="//input[@value='Manager']")
	WebElement managerLogin;
	
	@FindBy(xpath="//input[@value='Course Creator']")
	WebElement courseCreatorLogin;

	@FindBy(xpath="//input[@value='Learner']")
	WebElement learnerLogin;
	
	public void loginAdmin()
	{
		adminLogin.click();
	}
	
	public void loginManager()
	{
		managerLogin.click();
	}
	
	public void loginCourseCreator()
	{
		courseCreatorLogin.click();
	}
	
	
	public void loginLearner()
	{
		learnerLogin.click();
	}
	
	
	
	
	
}
