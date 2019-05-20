package dynamicLoading;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicLoadingTest {
	WebDriver driver;
	DynamicLoadingPage dynamicTest;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver= new ChromeDriver();
		dynamicTest= new DynamicLoadingPage(driver);
		baseUrl="http://the-internet.herokuapp.com/dynamic_loading";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			
		
	}

	//TC 1.Click Example; 2.Click start 3.Wait until text to be displayed 4.Assert of Hello World

	@Test
	public void test() {
		driver.get(baseUrl);
		
		dynamicTest.clickExampleOne();//navigate to Example1
		dynamicTest.clickStart();//click start
		Assert.assertTrue(dynamicTest.returnHiddenText().contains("Hello World!"));//assertion of hello world
		
		
		
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		
	}
}
