package testCase2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CertificationCompletion {
	WebDriver driver;
	List<WebElement> userData=new ArrayList<WebElement>();

	public CertificationCompletion(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="id_user-fullname_op")
	WebElement dropDown;
	@FindBy(id="id_certcompletion-status_op")
	WebElement firstStatusDropDown;
	@FindBy(id="id_certcompletion-status")
	WebElement secondStatusDropDown;	
	@FindBy(id="id_user-fullname")
	WebElement fullNameTextField;
	@FindBy(id="id_submitgroupstandard_addfilter")
	WebElement searchBtn;
	@FindBy(id="report_certification_completion")
	WebElement table;
	@FindBy(xpath="//a[contains(text(),\"User's Position Name(s)\")]")
	WebElement userPositionsNameHeader;
	@FindBy(xpath="/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	WebElement saveThisSearchBtn;
	@FindBy(id="id_submitgroupstandard_clearstandardfilters")
	WebElement clearBtn;
	@FindBy(xpath="//select[@class='custom-select singleselect']")
	WebElement viewAndSearchSelect;
	@FindBy(xpath="//a[@id='action-menu-toggle-0']")
	WebElement dropDownMenuBtn;
	@FindBy(xpath="//li[31]//a[1]")
	WebElement logOutBtn;
	
	
	
	public void fullNameDropdownStartsWithOption(int option) {
		Select sel = new Select(dropDown);
		sel.selectByIndex(option);//select starts with
	}
	
	public void selectFirstStatusDropDownOption(int option) {
		Select sel = new Select(firstStatusDropDown);
		sel.selectByIndex(option);//select starts with
	}
	
	public void selectSecondStatusDropDownOption(int option) {
			
			Select sel = new Select(secondStatusDropDown);
			sel.selectByIndex(option);//select starts with
		
	}
	
	public void selectViewAndSearch(String optionsText) {
		Select sel= new Select(viewAndSearchSelect);
		sel.selectByVisibleText(optionsText);
	}
	
	public void insertTextToFullNameTextField(String fullNameText) {
		fullNameTextField.sendKeys(fullNameText);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public void clickUserPositionNameHeader() {
		userPositionsNameHeader.click();
	}
	public void clickSaveThisSearchBtn() {
		if(saveThisSearchBtn.isDisplayed())
			saveThisSearchBtn.click();
		else
			System.out.println("Save this search Btn is not diplayed");
	}
	
	public void clickClearBtn() {
		if(clearBtn.isDisplayed())
			clearBtn.click();
	}
	
	public String retriveColumnDataFromTable(int columnNo){
		WebElement columnData = null;
		List<WebElement>tableRows=table.findElements(By.xpath("//table[@id='report_certification_completion']//tbody//tr"));
		//System.out.println("Iloœæ wierszy: "+tableRows.size());
		for(WebElement rowElem:tableRows)
		{	
			List<WebElement>tableColumns=rowElem.findElements(By.tagName("td"));
			
			columnData=tableColumns.get(columnNo-1);
			
		}
		return columnData.getText();
	}
	
	public List<WebElement> getFirstColumnValues(int columnNo){
		
		List<WebElement>tableRows=table.findElements(By.xpath("//table[@id='report_certification_completion']//tbody//tr"));
		for(WebElement rowElem:tableRows)
		{   
			List<WebElement>tableColumns=rowElem.findElements(By.tagName("td"));
			
			userData.add(tableColumns.get(columnNo-1));
			
		}
		
		return userData;
		
	}
	
	public void printList(List<String> lista) {//print list //print list 
		for(String elem:lista) {
			System.out.println(elem);
			
		}
		
	}
	

	public void copyTextToAnotherList(List<WebElement> lista,List<String> targetList ) {
		for(WebElement elem:lista) {
			targetList.add(elem.getText());
			
		}
		
	}
	
	public void logOut() throws InterruptedException {
		dropDownMenuBtn.click();
		Thread.sleep(1000);
		logOutBtn.click();
	}

}
