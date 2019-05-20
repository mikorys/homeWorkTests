package basicAuth;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicAuthPage {
	WebDriver driver;
	
	public BasicAuthPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[contains(text(),'Congratulations! You must have the proper credenti')]")
	WebElement text;
	
		
	public String returnElementsText() {
		
		return text.getText();
	}
	
}
