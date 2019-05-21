package testCase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationFrameworksPage extends AdminDashboardPage {
	WebDriver driver;
	
	public OrganisationFrameworksPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='Add new organisation framework']")
	WebElement addNewOrganisationFrameworBtn;
	
	@FindBy(xpath="//div[@class='alert-message']")
	WebElement alertMessage;
	@FindBy(xpath="//a[@class=\"toggle-display textmenu\"]")
	WebElement dropDownMenuBtn;
	@FindBy(xpath="//li[31]//a[1]")
	WebElement logOutBtn;
	
	public void clickAddNewOrganisationFramework() {
		addNewOrganisationFrameworBtn.click();
	}
	
	public String returnAlertText() {
		if(alertMessage.isDisplayed())
			return alertMessage.getText();		
		else
			return null;
	}
	
	
	public void pickNewlyGeneratedOrganisation(String organisationFrameworkName) {//finds newly created organisation and clicks it
		WebElement temp=driver.findElement(By.xpath("//a[contains(text(),'"+organisationFrameworkName+"')]"));
		if(temp.isDisplayed())
			temp.click();
	}

	public void logOut() throws InterruptedException {
		dropDownMenuBtn.click();
		Thread.sleep(1000);
		logOutBtn.click();
	}
}
