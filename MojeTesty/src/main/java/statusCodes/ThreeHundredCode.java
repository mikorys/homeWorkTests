package statusCodes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThreeHundredCode {
	WebDriver driver;

	public ThreeHundredCode(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[contains(text(),'This page returned a 301 status code.')]")
	WebElement statusCodeText;
	
	
	public String returnElementsText() {
		return statusCodeText.getText();
	}

}