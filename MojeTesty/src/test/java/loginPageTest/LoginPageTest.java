package loginPageTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import loginPage.LoginHomePage;
import loginPage.PageAfterLogin;

public class LoginPageTest{
	WebDriver driver;
	LoginHomePage homePageTest;
	PageAfterLogin afterLoginTest;
	String baseURL;
	
	//TC steps. 1.Login 2.Assert alert text 3. logout and assert text
	@Before
	public void setUp() {
		driver= new ChromeDriver();
		homePageTest= new LoginHomePage(driver);
		afterLoginTest= new PageAfterLogin(driver);
		baseURL="https://the-internet.herokuapp.com/login";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		
		homePageTest.logInCredentials("tomsmith", "SuperSecretPassword!");//login
		homePageTest.clickLogin();
		 
		
		Thread.sleep(1000);
		Assert.assertTrue(afterLoginTest.returnAlertElementText().contains("You logged into a secure area!"));//sprawdz text po zalogowaniu
		afterLoginTest.clickLogOutBtn();//logout
		
		Thread.sleep(2000);
		Assert.assertTrue(homePageTest.returnAlertElementText().contains("You logged out of the secure area!"));//sprawdz text po wylogowaniu 
		
		
	}
	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}


