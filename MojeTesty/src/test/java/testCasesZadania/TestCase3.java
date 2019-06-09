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
	
	String date;
	String timeAndTimeZone;
	String room;
	
	
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
		trainDashObj.clickResuscitationTrainingLink();//hover mouse over 12th dday field and click resuscitation link from calendar
		
		dateAndTimeFieldText=calPageObj.returnDateAndTimeText();//fetch data from following fields date/time, duration and room
		durationFieldText=calPageObj.returnDurationText();
		roomFieldFieldText=calPageObj.returnRoomText();
		
		
		calPageObj.clickSingForSeminarEventBtn();//sign int for Seminar event
		Assert.assertTrue(rescTrainPageObj.getAlertsText().contains("The signup user has conflicting signups"));//Assert Alert text msg
		
		rescTrainPageObj.clickRescutitatioTrainingLink();//click rescutitatioTrainingLink
		List<String> eventDetails=rescTrainPageObj.fetchEventDetails();//save eventData To List	
		//add data to strings
		date=eventDetails.get(0);
		timeAndTimeZone=eventDetails.get(1);
		room=eventDetails.get(2);
		
		rescTrainPageObj.clickAddANewEventBtn();//add new event
		
		addRescTrainObj.clickRemoveSessionBtn();//remove session
		
		addRescTrainObj.clickSingUpOpenCheckBox();//click start checkbox
		
		addRescTrainObj.setStartDateAndTimeWithCurrentTime(timeZone);//pick start date and time base on current time
		
		addRescTrainObj.clickSignUpCloseCheckBox();//click finish checkbox
		
		addRescTrainObj.setFinishDateAndTime(day, month, year, hour, minute, timeZone);//pick finish date
		
		addRescTrainObj.insertTextToMaximumBookingsField("9");//set maximum bookings
		
		addRescTrainObj.clickEnableWaitListCheckBox();//select enable waitlist
		
		addRescTrainObj.selectAllowCancelationRadioBtn(1);//select at any timie which is 1st radio btn
		
		addRescTrainObj.insertTextToMinimumBookings("2");//set minimum bookings to 2
		
		addRescTrainObj.insertTextToNormalCostField("200z³");//set normal cost to 200z³
		
		addRescTrainObj.insertTextToDiscounCostField("150z³");//set discount cost
		
		addRescTrainObj.insertTextToDetailsField("This is a simple test to add new events.");//add description
		
		addRescTrainObj.selectEditTrainerSallyCheckbox();//select edit trainer checkbox
		//
		addRescTrainObj.selectTrainerCarlCheckbox();//select trainer checkbox
		
		addRescTrainObj.clickSaveBtn();//click save
		Thread.sleep(10000);//wait 10 seconds
		rescTrainPageObj.clickLogOutBtn();//logout
		
		
		System.out.println("### Resuscitation training ###");
		System.out.println("Event date/time: "+date);
		System.out.println("Duration: "+timeAndTimeZone);
		System.out.println("Room: "+room);
		System.out.println("\n### December Event ###");
		System.out.println("The event will be on "+date+" at "+timeAndTimeZone+" in "+room);
		
		
		
		
		
		
		
	
		
		
		
		
		
	}

	
	@After
	public void tearDown() throws InterruptedException{
		Thread.sleep(1000);
		driver.quit();
	}
}
