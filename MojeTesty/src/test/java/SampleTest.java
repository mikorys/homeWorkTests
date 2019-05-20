///////////////Do not LOOK at this Class I used this class for Learn things\\\\\\\\\\\\\\\\

import java.util.concurrent.TimeUnit;


import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import junit.framework.TestCase;
import testCase1.BaseLoginPage;

public class SampleTest extends TestCase {

	WebDriver driver;
	String baseUrl;
	BaseLoginPage base;
	
	//testowe slowa ssss
	

	@Before
	protected void setUp() throws Exception {
		//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumPlugins\\chromedriver.exe");
		driver=new ChromeDriver();
		base= new BaseLoginPage(driver);
		//baseUrl="http://the-internet.herokuapp.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://demo.totaralearning.com");
		 Thread.sleep(1000);
		 
		 base.loginAdmin();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[@id='action-menu-toggle-6']")).click();
		 driver.findElement(By.xpath("//li[31]//a[1]")).click();
		 /*
		 * Select sel = new Select(dropDown); sel.selectByIndex(30);
		 */
		
		 
		 
		 
		
		//driver.findElement(By.xpath("//div[@id='checkbox']")).click();
		 

}
	


}