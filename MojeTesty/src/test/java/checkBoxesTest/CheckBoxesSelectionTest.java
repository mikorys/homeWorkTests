package checkBoxesTest;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import checkBoxes.CheckBoxesPage;

public class CheckBoxesSelectionTest {
	
	WebDriver driver;
	CheckBoxesPage test;
	String baseURL;
	

	@Before
	public void setUp(){
		driver=new ChromeDriver();
		test = new CheckBoxesPage(driver);
		baseURL="http://the-internet.herokuapp.com/checkboxes";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(1000);
		
		test.deSelctCheckbox2();
		
		Thread.sleep(2000);
		test.selctCheckbox1();
		
		
	}
	
	
	@After
	public void tearDown() throws InterruptedException  {
		Thread.sleep(1000);

		driver.quit();
		
	}

}
