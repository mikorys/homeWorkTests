package testCase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveThisSearchPage {
	WebDriver driver;

	public SaveThisSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="id_name")
	WebElement searchTextField;
	
	@FindBy(id="id_submitbutton")
	WebElement saveChangesBtn;
	
	public void insertSearchedNameToNameField(String searchedName) {
		searchTextField.sendKeys(searchedName);
	}
	
	public void clickSaveChangesBtn() {
		saveChangesBtn.click();
	}
	
	

}
