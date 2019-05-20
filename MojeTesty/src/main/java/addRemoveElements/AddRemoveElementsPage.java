package addRemoveElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementsPage {
	WebDriver driver;

	public AddRemoveElementsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@onclick='addElement()']")
	WebElement addElement;
	
	@FindBy(xpath="//button[@class='added-manually']")//location of more than 1 element
	List<WebElement> deleteElements;
	

	public void clickAddBtn() {
		addElement.click();
	}
	
	public void clickDeleteElements() {
		for(WebElement elem:deleteElements)
		{
			elem.click();
		}
	}
	
	
	
}
