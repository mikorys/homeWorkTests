package checkBoxes;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxesPage {
	WebDriver driver;

	public CheckBoxesPage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//body//input[1]")
	WebElement firstCheckBox;
	
	@FindBy(xpath="//body//input[2]")
	WebElement secondCheckBox;
	
	
	boolean isChecked=false; //check checkbox selection
	
	private static boolean checkIfSelected(WebElement element) {
		if(element.isSelected())
			return true;
		else
			return false;
	}
	
	
	public void selctCheckbox1() {   //if checkbox is not selected pick it 
		
		if(CheckBoxesPage.checkIfSelected(firstCheckBox)==false);
			firstCheckBox.click();
	}
	
	public void deSelctCheckbox1() {//if checkbox is selected click it
		
		if(CheckBoxesPage.checkIfSelected(firstCheckBox));
			firstCheckBox.click();
	}
	
	
	
	public void selctCheckbox2() {
		
		if(CheckBoxesPage.checkIfSelected(secondCheckBox)==false);
		secondCheckBox.click();
	}
	
	public void deSelctCheckbox2() {
		
		if(CheckBoxesPage.checkIfSelected(secondCheckBox));
			secondCheckBox.click();
	}
	
	
	
	
	
	
}
