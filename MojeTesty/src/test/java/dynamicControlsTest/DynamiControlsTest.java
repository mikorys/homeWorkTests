package dynamicControlsTest;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dynamicControls.DynamicControlsPage;


public class DynamiControlsTest {

	WebDriver driver;
	DynamicControlsPage dynamicTest;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver= new ChromeDriver();
		dynamicTest= new DynamicControlsPage(driver);
		baseUrl="http://the-internet.herokuapp.com/dynamic_controls";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			
		
	}
	//TC steps: 1.Click Enable Btn	 2.Enter in activated field sample text		 3.Select A checkbox 	4.Remove checkBox	5.Select Disable Btn   6.Click Add btn 
	//7.Assert text "its back"
	
	//!!!!!!!!!!!!!!!!!!!!!!!DONT know why sending text to text field and cliking checkbox is not working!!!!!!!!!!!!!!!!

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		//dynamicTest.clickEnableBtn();
		
		dynamicTest.enableAndProvideText("This is sample text");//click enable and provide text
		Thread.sleep(2000);		//<---lol without this sleep test fails
		
		dynamicTest.clickCheckBox();//selectcheckbox 
		  Thread.sleep(2000);
		  
		
		dynamicTest.clickRemoveBtn();//remove checkbox 
		  Thread.sleep(3000);
		  
		dynamicTest.clickDisableBtn();//disable textField 
		  Thread.sleep(3000);
		  
		  Assert.assertTrue(dynamicTest.returnHiddenText().contains("It's back!"));//clicks add btn and checks for assertion
		 
	}
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
		
	}

}
