package dropDownList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownListPage {
	WebDriver driver;

	public DropDownListPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dropdown")
	WebElement dropDown;
	
	public void selectDropdownListOption(int index) {
		Select sel = new Select(dropDown);
		sel.selectByIndex(index);
	}
	
	
}


