package dropDownListTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import dropDownList.DropDownListPage;


public class DropDownListSelectionTest {
	//TC steps 1.Go to dropdown list page 2.Select option No2 3.Wait 2 seconds 4.Select option 1
	
	WebDriver driver;
	DropDownListPage test;
	String baseURL;	

	@Before
	public void setUp(){
		driver=new ChromeDriver();
		test = new DropDownListPage(driver);
		baseURL="http://the-internet.herokuapp.com/dropdown";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(1000);
		
		test.selectDropdownListOption(2);//1.select option No 2
		
		Thread.sleep(2000);//2.wait 2 seconds
		test.selectDropdownListOption(1);
		
		
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	
}
