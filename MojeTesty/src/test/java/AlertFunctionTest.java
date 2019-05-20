import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import loginPage.LoginHomePage;
///////////////Do not LOOK at this Class I used this class for Learn things\\\\\\\\\\\\\\\\\\
public class AlertFunctionTest {
	WebDriver driver;
	LoginHomePage homePageTest;
	String baseURL;
	@Before
	public void setUp() {
		driver =new ChromeDriver();
		homePageTest=new LoginHomePage(driver);
		baseURL="https://the-internet.herokuapp.com/login";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		homePageTest.logInCredentials("tomsmith", "SuperSecretPassword!");
		homePageTest.clickLogin();
		
		Thread.sleep(3000);
		
		WebElement dupa=driver.findElement(By.xpath("//div[@id='flash']"));
		
		
		
		System.out.println("To jest text alertu"+ dupa.getText()+"AAAAAA");
		Assert.assertTrue(dupa.getText().contains("You logged into a secure area!"));
	}
	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}


