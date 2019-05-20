package statusCodes;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatusCodesMainPage {
	WebDriver driver;

	public StatusCodesMainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'200')]")
	WebElement statusCode200;
	@FindBy(xpath="//a[contains(text(),'301')]")
	WebElement statusCode301;
	@FindBy(xpath="//a[contains(text(),'404')]")
	WebElement statusCode404;
	@FindBy(xpath="//a[contains(text(),'500')]")
	WebElement statusCode500;
	
	public void clickOnElement(String statusCode) {
		switch (statusCode) {
		case "200":
			statusCode200.click();
			break;
		case "301":
			statusCode301.click();
			break;
		case "404":
			statusCode404.click();
			break;
		case "500":
			statusCode500.click();
			break;
		default:
			System.out.println("Wrong Index");
		}
	}
	

}
