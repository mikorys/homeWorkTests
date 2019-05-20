package dynamicControls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {
	WebDriver driver;
	WebDriverWait wait;
	WebDriverWait waitV2;
	
	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(text(),'Enable')]")
	WebElement enableBtn;

	@FindBy(xpath="//button[contains(text(),'Disable')]")
	WebElement disableBtn;
	
	@FindBy(xpath="//button[contains(text(),'Remove')]")
	WebElement removeBtn;
	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement addBtn;	
	
	@FindBy(id="checkbox")
	WebElement checkBox;
	
	@FindBy(xpath="//form[@id='input-example']//input")
	WebElement textField;
	
	@FindBy(id="message")
	WebElement textMessage;
	
	
	public void clickEnableBtn() {
		
		if(enableBtn.isDisplayed())
			enableBtn.click();
	}
	
	public void clickDisableBtn() {
		
		if(disableBtn.isDisplayed())
			disableBtn.click();
	}
	
	public void clickRemoveBtn() {
		
		if(removeBtn.isDisplayed())
			removeBtn.click();
	}

	public void clickAddBtn() {
	
		if(addBtn.isDisplayed())
			addBtn.click();
	}	
	
	public void clickCheckBox() {
		
		if(checkBox.isDisplayed())
		{
		
				checkBox.click();
		}
	}
	
	
	
	public void enableAndProvideText(String text)
	{
		clickEnableBtn();		
		
		this.wait= new WebDriverWait(driver,8);//wait 8 seconds WebElement
		  WebElement hiddenTextField=wait.until(ExpectedConditions.visibilityOf(textField));
		 
		if(hiddenTextField.isEnabled())
			hiddenTextField.sendKeys("text");
				
	}
	
	public String returnHiddenText() throws InterruptedException
	{
		clickAddBtn();
		//Thread.sleep(3000);
		this.waitV2= new WebDriverWait(driver,8);//wait 8 seconds
		WebElement hiddenTextField=wait.until(ExpectedConditions.visibilityOf(textMessage));
		
		return hiddenTextField.getText();
		
	}
	
	
	
	
	

}
