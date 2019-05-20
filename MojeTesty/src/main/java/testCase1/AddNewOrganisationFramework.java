package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewOrganisationFramework extends OrganisationFrameworks {
	WebDriver driver;
	
	public AddNewOrganisationFramework(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="id_fullname")
	WebElement nameField;
	
	@FindBy(id="id_idnumber")
	WebElement idNumberField;
	
	@FindBy(id="id_description_editoreditable")
	WebElement descriptionField;
	
	@FindBy(id="id_submitbutton")
	WebElement saveChangesBtn;
	
	
	
	public void insertTextToName(String organisationFrameworkName){
		nameField.sendKeys(organisationFrameworkName);
	}
	
	public void insertTextToIDNumber(String idNumber){
		idNumberField.sendKeys(idNumber);
	}
	
	public void insertTextToDescription(String descriptionText){
		descriptionField.sendKeys(descriptionText);
	}
	
	public void clickSaveBtn() {
		saveChangesBtn.click();
	}
	
	
	
	

}
