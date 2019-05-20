package dynamicLoading;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {
	WebDriver driver;
	WebDriverWait wait;

	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[contains(text(),'Example 1: Element on page that is hidden')]")
	WebElement exampleOne;
	
	@FindBy(xpath="//button[contains(text(),'Start')]")
	WebElement hiddenStart;
	
	@FindBy(xpath="//h4[contains(text(),'Hello World!')]")
	WebElement hiddenText;
	
	
	
	public void clickExampleOne()
	{
		exampleOne.click();
	}
	
	public void clickStart()
	{
		if(hiddenStart.isEnabled())
			hiddenStart.click();
		else
			System.out.println("Element not enabled");
	}
	
	
	public String returnHiddenText()
	{
		this.wait= new WebDriverWait(driver,8);//wait 8 seconds
		WebElement hiddenTextField=wait.until(ExpectedConditions.visibilityOf(hiddenText));
		
		return hiddenTextField.getText();
		
	}
	
	
	
	
	

}
