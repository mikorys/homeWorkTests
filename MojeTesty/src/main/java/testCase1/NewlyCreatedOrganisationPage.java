package testCase1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewlyCreatedOrganisationPage extends NewlyCreatedOrganisationFrameworkPage {
	WebDriver driver;

	public NewlyCreatedOrganisationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='alert-message']")
	WebElement alertMessage;
	
	@FindBy(xpath="//input[@id='show-assignedgoals-dialog']")
	WebElement addGoalBtn;
	
	@FindBy(xpath="//input[@value='Return to organisation framework']")
	WebElement returnToOrganisation;
	
	@FindBy(xpath="/html[1]/body[1]/div[8]/div[3]/div[1]/button[1]/span[1]")//had to use ABS xpath because relxpath did not work
	WebElement goalSaveBtn;
	
	@FindBy(xpath="//a[contains(text(),'Create training manuals for new staff induction')]")
	WebElement createTrainingOption;
	
	
	
	@Override
	public String returnAlertText() {
		if(alertMessage.isDisplayed())
			return alertMessage.getText();		
		else
			return null;
	}
	
	public void clickAddGoal()
	{
		addGoalBtn.click();
	}
	
	public void returnToOrgFramework()
	{
		returnToOrganisation.click();
	}
	
	public void clickCreateTrainingManual()
	{
		if(createTrainingOption.isDisplayed())
			createTrainingOption.click();
	}
	
	public void clickSaveBtn()
	{
		if(goalSaveBtn.isDisplayed())
		goalSaveBtn.click();
		
	}
	
	
	

}