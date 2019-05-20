package statusCodesTest;




import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import statusCodes.FiveHundredCode;
import statusCodes.FourHundredCode;
import statusCodes.StatusCodesMainPage;
import statusCodes.ThreeHundredCode;
import statusCodes.TwoHundredCode;

public class StatusCodePickerTest {
	WebDriver driver;
	StatusCodesMainPage mainPage;
	TwoHundredCode twoCode;
	ThreeHundredCode threeCode;
	FourHundredCode fourCode;
	FiveHundredCode fiveCode;
	String baseUrl;
	
	//TC Steps 1.Click for each status code page 2.assert text for eac of them
	
	
	@Before
	public void setUp() {
		driver= new ChromeDriver();
		mainPage= new StatusCodesMainPage(driver);
		twoCode= new TwoHundredCode(driver);
		threeCode=new ThreeHundredCode(driver);
		fourCode= new FourHundredCode(driver);
		fiveCode= new FiveHundredCode(driver);
		baseUrl="http://the-internet.herokuapp.com/status_codes";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		//code 200
		mainPage.clickOnElement("200");//click on element
		Thread.sleep(1000);
		Assert.assertTrue(twoCode.returnElementsText().contains("This page returned a 200 status code."));//asercja tekstu
		driver.navigate().back();//go back
		
		//code 301
		Thread.sleep(1000);
		mainPage.clickOnElement("301");//click on element
		Thread.sleep(1000);
		Assert.assertTrue(threeCode.returnElementsText().contains("This page returned a 301 status code."));//asercja tekstu
		driver.navigate().back();//go back
		
		//code 404
		Thread.sleep(1000);
		mainPage.clickOnElement("404");//click on element
		Thread.sleep(1000);
		Assert.assertTrue(fourCode.returnElementsText().contains("This page returned a 404 status code."));//asercja tekstu
		driver.navigate().back();//go back
		
		//code 500
		Thread.sleep(1000);
		mainPage.clickOnElement("500");//click on element
		Thread.sleep(1000);
		Assert.assertTrue(fiveCode.returnElementsText().contains("This page returned a 500 status code."));//asercja tekstu
		driver.navigate().back();//go back
		
		
		
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	

}
