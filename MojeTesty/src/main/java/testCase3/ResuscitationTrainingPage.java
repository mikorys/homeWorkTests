package testCase3;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResuscitationTrainingPage {
	WebDriver driver;

	public ResuscitationTrainingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".alert-message")
	WebElement alertText;
	
	@FindBy(xpath="//span[@class='item-content-wrap'][contains(text(),'Resuscitation training')]")
	WebElement rescutitatioTrainingLink;
	
	@FindBy(xpath="//div[@class='upcomingsessionlist']//tbody//tr")
	List<WebElement>  upcomingEventsTableRows;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement addANewEventBtn;
	
	@FindBy(linkText = "Log out")
	WebElement logOutLink;
	
	
	public String getAlertsText() {
		
		return alertText.getText();
	}
	
	public void clickRescutitatioTrainingLink() {
		rescutitatioTrainingLink.click();
	}
	
	
	public void clickLogOutBtn() {
		logOutLink.click();
	}
	
	
	public List<String> fetchEventDetails(){
		
		//create  list which will contain data
		List<String> eventDetailsData = new ArrayList<String>();
		
			for (WebElement tableRow : upcomingEventsTableRows) {
				String date = tableRow.findElement(By.cssSelector(".cell.c0")).getText();
				
				if (date.contains("December")) {
					eventDetailsData.add(date);
					eventDetailsData.add(tableRow.findElement(By.xpath("//td[@class=\"cell c1\"]")).getText());
					eventDetailsData.add(tableRow.findElement(By.xpath("//td[@class=\"cell c2\"]")).getText());
								  
				  }
				  
			 }		
			
		return eventDetailsData;
		
	}
	
	public void clickAddANewEventBtn() {
		addANewEventBtn.click();
	}
	

}
