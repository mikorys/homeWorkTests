package testCasesZadania;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testCase1.BaseLoginPage;
import testCase3.AddNewEventInResuscitationPage;
import testCase3.CalendarPage;
import testCase3.ResuscitationTrainingPage;
import testCase3.TrainerDashboardPage;

public class TestCase3 {
	WebDriver driver;
	BaseLoginPage base;
	TrainerDashboardPage trainDashObj;
	CalendarPage calPageObj;
	ResuscitationTrainingPage rescTrainPageObj;
	AddNewEventInResuscitationPage addRescTrainObj;
	String baseUrl;
	String dateAndTimeFieldText;
	String durationFieldText;
	String roomFieldFieldText;
	
	String day;
	String month;
	String year;
	String hour;
	String minute;
	String timeZone;
	
	
	@Before
	public void setUp() {
		driver= new ChromeDriver();
		base= new BaseLoginPage(driver);
		trainDashObj= new TrainerDashboardPage(driver);
		calPageObj= new CalendarPage(driver);
		rescTrainPageObj= new ResuscitationTrainingPage(driver);
		addRescTrainObj= new AddNewEventInResuscitationPage(driver);
		baseUrl="https://demo.totaralearning.com";
		day="29";
		month="June";
		year="2019";
		hour="14";
		minute="00";		
		timeZone="Europe/Warsaw";
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		
		base.loginCourseCreator();//login as course creator
		trainDashObj.clickResuscitationTrainingLink();//hover mouse over 15th dday field and click resuscitation link from calendar
		
		dateAndTimeFieldText=calPageObj.returnDateAndTimeText();//fetch data from following fields date/time, duration and room
		durationFieldText=calPageObj.returnDurationText();
		roomFieldFieldText=calPageObj.returnRoomText();
		
		Thread.sleep(1000);
		calPageObj.clickSingForSeminarEventBtn();//sign int for Seminar event
		Assert.assertTrue(rescTrainPageObj.getAlertsText().contains("The signup user has conflicting signups"));//Assert Alert text msg
		Thread.sleep(1000);
		rescTrainPageObj.clickRescutitatioTrainingLink();//click rescutitatioTrainingLink
		List<String> eventDetails=rescTrainPageObj.fetchEventDetails();//save eventData To List		
		Thread.sleep(1000);
		rescTrainPageObj.clickAddANewEventBtn();//add new event
		Thread.sleep(1000);
		addRescTrainObj.clickRemoveSessionBtn();//remove session
		Thread.sleep(2000);
		addRescTrainObj.clickSingUpOpenCheckBox();//click start checkbox
		Thread.sleep(1000);
		addRescTrainObj.setStartDateAndTimeWithCurrentTime(timeZone);//pick start date and time base on current time
		Thread.sleep(2000);
		addRescTrainObj.clickSignUpCloseCheckBox();//click finish checkbox
		Thread.sleep(1000);
		addRescTrainObj.setFinishDateAndTime(day, month, year, hour, minute, timeZone);//pick finish date
		Thread.sleep(1000);
		addRescTrainObj.insertTextToMaximumBookingsField("9");//set maximum bookings
		Thread.sleep(1000);
		addRescTrainObj.clickEnableWaitListCheckBox();//select enable waitlist
		Thread.sleep(1000);
		addRescTrainObj.selectAllowCancelationRadioBtn(1);//select at any timie which is 1st radio btn
		Thread.sleep(1000);
		addRescTrainObj.insertTextToMinimumBookings("2");//set minimum bookings to 2
		Thread.sleep(1000);
		addRescTrainObj.insertTextToNormalCostField("200z³");//set normal cost to 200z³
		Thread.sleep(1000);
		addRescTrainObj.insertTextToDiscounCostField("150z³");//set discount cost
		Thread.sleep(1000);
		addRescTrainObj.insertTextToDetailsField("This is a simple test to add new events.");//add description
		Thread.sleep(1000);
		addRescTrainObj.selectEditTrainerSallyCheckbox();//select edit trainer checkbox
		Thread.sleep(1000);
		addRescTrainObj.selectTrainerCarlCheckbox();//select trainer checkbox
		Thread.sleep(1000);
		addRescTrainObj.clickSaveBtn();//click save
		Thread.sleep(10000);//wait 10 seconds
		rescTrainPageObj.clickLogOutBtn();//logout
		
		
		
		
		
		
		
		
	
		
		
		
		
		
	}

	
	@After
	public void tearDown() throws InterruptedException{
		Thread.sleep(1000);
		driver.quit();
	}
}
