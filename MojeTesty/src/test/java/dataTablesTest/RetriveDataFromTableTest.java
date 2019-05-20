package dataTablesTest;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataTables.DataTablesPage;

public class RetriveDataFromTableTest {
	WebDriver driver;
	DataTablesPage tableTest;
	String baseUrl;
	
	@Before
	public void setUp()  {
		driver= new ChromeDriver();
		tableTest= new DataTablesPage(driver);
		baseUrl="http://the-internet.herokuapp.com/tables";
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	//TC steps 1.Get 1stName, LastName,Email TABLE 1, row3
	//2.WWW addresses Table 1, row 1 and 4
	//3.Count total due of table 2

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		
		 tableTest.logCellsText("1", "3", "2");//Log FirstName Thread.sleep(2000);
		 tableTest.logCellsText("1", "3", "1");//Log Last Name Thread.sleep(2000);
		 tableTest.logCellsText("1", "3", "3");//Log Email System.out.println("\n\n");
		 System.out.println("\n");
		 tableTest.logCellsText("1", "1", "5");//WWW from 1st row Thread.sleep(2000);
		 tableTest.logCellsText("1", "4", "5");//WWW from 2nd row
		 
		
		 Thread.sleep(2000);
		 tableTest.logCellsText("2", "1", "4");//WWW from 2nd row
			
		tableTest.countAllDue("2");//totaldue for table 2
	
		
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
