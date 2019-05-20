package notificationMessage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage {
	WebDriver driver;

	public NotificationMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Click here')]")
	WebElement clickBtn;
	
	@FindBy(id="flash")
	WebElement notificationWindow;
	
	public void clickOnBtn()
	{
		clickBtn.click();
	}
	
	public String getNotificationText()
	{
		return notificationWindow.getText();
	}
	
	public void clickUntilSuccess(String expectedText) throws InterruptedException
	{	
		
		do
		{
			clickOnBtn();
			Thread.sleep(2000);
			
			System.out.println(getNotificationText());
			if(getNotificationText().contains(expectedText))
				System.out.println("Text is ok, End of test");
			else
				System.out.println("Text is not ok, test will continue");		
			
			
		}
		while(getNotificationText().contains(expectedText)==false);
	}
	
	
	
	

}
