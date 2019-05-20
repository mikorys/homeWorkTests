package basicAuthTest;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import basicAuth.BasicAuthPage;




public class CheckTextAfterLoginTest {
	
	WebDriver driver;
	BasicAuthPage test;
	String baseURL;
	

	@Before
	public void setUp(){
		driver=new ChromeDriver();
		test = new BasicAuthPage(driver);
		baseURL="https://admin:admin@the-internet.herokuapp.com/basic_auth";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(1000);
		Assert.assertEquals( "Congratulations! You must have the proper credentials.", test.returnElementsText());
		
	}
		@After
		public void close() {
			driver.quit();
		}
	}
