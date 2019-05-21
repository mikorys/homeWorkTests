package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewOrganisationPage extends NewlyCreatedOrganisationFrameworkPage {
	WebDriver driver;
	public AddNewOrganisationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='id_fullname']")
	WebElement nameField;
	
	@FindBy(xpath="//input[@id='id_idnumber']")
	WebElement ogranisationIdField;
	
	@FindBy(xpath="//div[@id='id_description_editoreditable']")
	WebElement descriptionField;
	
	@FindBy(xpath="//input[@id='id_submitbutton']")
	WebElement saveBtn;
	
	
	public void insertTextToName(String organisationName){
		nameField.sendKeys(organisationName);
	}
	
	public void insertTextToIDNumber(String idNumber){
		ogranisationIdField.sendKeys(idNumber);
	}
	
	public void insertTextToDescription(String descriptionText){
		descriptionField.sendKeys(descriptionText);
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
}
