package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewlyCreatedOrganisationFramework extends OrganisationFrameworks{
	WebDriver driver;
	
	public NewlyCreatedOrganisationFramework(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='hierarchy-buttons']//input[1]")
	WebElement addNewOrganisationBtn;
	
	
	//@FindBy
	
	public void clickAddNewOrganisationBtn() {
		addNewOrganisationBtn.click();
	}
	

}
