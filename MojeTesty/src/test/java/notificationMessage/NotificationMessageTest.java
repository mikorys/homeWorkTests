package notificationMessage;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotificationMessageTest {
	WebDriver driver;
	NotificationMessagePage notificationTest;
	String baseUrl;
	
	@Before
	public void setUp() {
		driver= new ChromeDriver();
		notificationTest= new NotificationMessagePage(driver);
		baseUrl="http://the-internet.herokuapp.com/notification_message_rendered";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	//TC steps 1.Go to page 2.Click btn until message apears
	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		notificationTest.clickUntilSuccess("Action unsuccesful, please try again");
		
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}


}
