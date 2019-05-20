package dataTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataTablesPage {
	WebDriver driver;

	public DataTablesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table[@id='table2']//tbody//tr")
	List<WebElement>table2Rows;
	@FindBy(xpath="//table[@id='table1']//tbody//tr")
	List<WebElement>table1Rows;

	
	public WebElement returnCellElement(String tableNo, String row, String column)
	{	
		WebElement cellElement;
		
		cellElement=driver.findElement(By.xpath("//*[@id=\"table"+tableNo+"\"]/tbody/tr["+row+"]/td["+column+"]"));
		
		return cellElement;
		
	}
	
	public void logCellsText(String tableNo, String row, String column) {
		System.out.println(returnCellElement(tableNo,row,column).getText());
	}
	
	
	public void countAllDue(String tableNo) {
		double totalDue=0;

		for(int row=1; row<=table2Rows.size();row++) {
			String rowNo=Integer.toString(row);//into to string because retunr cell element takes String only
			totalDue+=Double.parseDouble(returnCellElement(tableNo,rowNo,"4").getText().substring(1));
		}
		
		System.out.println("Total Due for table No:"+tableNo+"= "+totalDue);
	}

	
}
