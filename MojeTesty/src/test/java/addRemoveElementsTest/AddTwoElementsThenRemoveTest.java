package addRemoveElementsTest;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import addRemoveElements.AddRemoveElementsPage;

public class AddTwoElementsThenRemoveTest {
	/*
	 TC:1.Pick add element twice 2.Wait 2 seconds 3.Delete all emlements
	 */
	WebDriver driver;
	AddRemoveElementsPage test;
	String baseURL;
	
	@Before
	public void setUp(){
		driver=new ChromeDriver();
		test= new AddRemoveElementsPage(driver);
		baseURL="http://the-internet.herokuapp.com/add_remove_elements/";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(1000);
		test.clickAddBtn();
		
		Thread.sleep(1000);
		test.clickAddBtn();
		
		//wait 2 seconds
		Thread.sleep(2000);
		test.clickDeleteElements();
		
		
	}

	@After
	public void tearDown() throws InterruptedException  {
		Thread.sleep(2000);
		driver.quit();
	}
}
