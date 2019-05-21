package testCase3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainerDashboardPage {
	WebDriver driver;
	public TrainerDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	  //@FindBy(xpath="//td[@id='yui_3_17_2_1_1558376482442_66']")
	  @FindBy(linkText="15")
	  WebElement dayNo15field;
	 
	
	  @FindBy(linkText="Resuscitation training")
	  WebElement resuscitationTrainingLink;
	
	
	
	  public void hoverMouseoOver15thDayField() { 
		  Actions hover = new Actions(driver);
	  hover.moveToElement(dayNo15field).build().perform();
	  
	  }
	 
	  
	  public void clickResuscitationTrainingLink() throws InterruptedException
	  {	
		  
		hoverMouseoOver15thDayField();
		
		Thread.sleep(1000);
		resuscitationTrainingLink.click();
	  }
	
	
	
	
	
	
	
}
