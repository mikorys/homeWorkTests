package testCase3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {
	WebDriver driver;

	public CalendarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//dd[1]")
	WebElement eventDateAndTimeText;
	
	@FindBy(xpath="//dd[2]")
	WebElement durationText;
	
	@FindBy(xpath="//dd[3]")
	WebElement roomText;
	
	@FindBy(xpath="//a[contains(text(),'Sign-up for this seminar event')]")
	WebElement signUpForSeminarEvent;
	
	
	
	public String returnDateAndTimeText(){
		
		return eventDateAndTimeText.getText();
	}
	
	public String returnDurationText(){
		
		return durationText.getText();
	}
	
	public String returnRoomText(){
		
		return eventDateAndTimeText.getText();
	}
	
	
	public void clickSingForSeminarEventBtn() {
		
		signUpForSeminarEvent.click();
	}

	
	
	
	
	
	

}
