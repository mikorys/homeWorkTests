package testCase3;


import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewEventInResuscitationPage {
	WebDriver driver;
	

	public AddNewEventInResuscitationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class, 'dateremove')]")
	WebElement removeSessionBtn;	
	//WebElement removeSessionBtn=;
	//sign up Opens elements
	@FindBy(id="id_registrationtimestart_enabled")
	WebElement signUpOpenCheckBox;
	@FindBy(id="id_registrationtimestart_day")
	WebElement signOpenDaySelect;
	@FindBy(id="id_registrationtimestart_month")
	WebElement signOpenMonthSelect;
	@FindBy(id="id_registrationtimestart_year")
	WebElement signOpenYearSelect;
	@FindBy(id="id_registrationtimestart_hour")
	WebElement signOpenHourSelect;
	@FindBy(id="id_registrationtimestart_minute")
	WebElement signOpenMinuteSelect;
	@FindBy(id="id_registrationtimestart_timezone")
	WebElement signOpenTimeZoneSelect;
	//sign up Closes date elements
	@FindBy(id="id_registrationtimefinish_enabled")
	WebElement signUpCloseCheckBox;
	@FindBy(id="id_registrationtimefinish_day")
	WebElement signCloseDaySelect;
	@FindBy(id="id_registrationtimefinish_month")
	WebElement signCloseMonthSelect;
	@FindBy(id="id_registrationtimefinish_year")
	WebElement signCloseYearSelect;
	@FindBy(id="id_registrationtimefinish_hour")
	WebElement signCloseHourSelect;
	@FindBy(id="id_registrationtimefinish_minute")
	WebElement signCloseMinuteSelect;
	@FindBy(id="id_registrationtimefinish_timezone")
	WebElement signCloseTimeZoneSelect;
	//rest of elements
	@FindBy(id="id_capacity")
	WebElement maximumBookingsField;
	@FindBy(id="id_allowoverbook")
	WebElement enableWaitListCheckBox;
	@FindBy(xpath="//div[@id='fgroup_id_allowcancellations']//div[@class='felement']//span//input")
	List<WebElement> allowCancelationRadioBtns;
	@FindBy(id="id_mincapacity")
	WebElement minimumBookingsField;
	@FindBy(id="id_normalcost")
	WebElement normalCostField;
	@FindBy(id="id_discountcost")
	WebElement discoutCostField;
	@FindBy(id="id_details_editoreditable")
	WebElement detailsField;
	@FindBy(id="id_trainerrole_3_13")
	WebElement editTrainerSallyCheckbox;
	@FindBy(id="id_trainerrole_4_4")
	WebElement trainerCarlCheckbox;
	@FindBy(id="id_submitbutton")
	WebElement saveChangesBtn;
	
	
	public void clickRemoveSessionBtn() {
		
		removeSessionBtn.click();
	}
	
	public void clickSingUpOpenCheckBox() {
		signUpOpenCheckBox.click();
	}
	
	public void clickSignUpCloseCheckBox() {
		signUpCloseCheckBox.click();
	}
			
	public void insertTextToMaximumBookingsField(String maximumCost)
	{
		maximumBookingsField.clear();
		maximumBookingsField.sendKeys(maximumCost);
	}
	
	public void clickEnableWaitListCheckBox() {
		enableWaitListCheckBox.click();
	}
	
	public void selectAllowCancelationRadioBtn(int radioBtnNo)
	{	int radioIndex=radioBtnNo-1;
		boolean bValue=false;
		bValue=allowCancelationRadioBtns.get(radioIndex).isSelected();
		
		if(bValue==false)
			allowCancelationRadioBtns.get(radioIndex).click();
		
	}
	
	public void insertTextToMinimumBookings(String minimumBookings) {
		minimumBookingsField.clear();
		minimumBookingsField.sendKeys(minimumBookings);
	}
	
	public void insertTextToNormalCostField(String normalCost) {
		normalCostField.sendKeys(normalCost);
	}

	public void insertTextToDiscounCostField(String discountCost)
	{
		
		discoutCostField.sendKeys(discountCost);
	}
	
	public void insertTextToDetailsField(String detailsFieldText)
	{
		detailsField.sendKeys(detailsFieldText);
	}
	
	public void selectEditTrainerSallyCheckbox() {
		if(editTrainerSallyCheckbox.isSelected()==false)
			editTrainerSallyCheckbox.click();
	}
	
	public void selectTrainerCarlCheckbox() {
		if(trainerCarlCheckbox.isSelected()==false)
			trainerCarlCheckbox.click();
	}
	
	public void clickSaveBtn() {
		saveChangesBtn.click();
	}
	

	public void setStartDateAndTimeWithCurrentTime(String timeZone) {//sets all chechkboxes based on current time
		
		selectDateTime(signOpenDaySelect, getDateTime("day"));
		selectDateTime(signOpenMonthSelect, changeMonthNumberToString(getDateTime("month")));
		selectDateTime(signOpenYearSelect, getDateTime("year"));
		selectDateTime(signOpenHourSelect, oneToTwoDigitFormat(getDateTime("hour")));
		selectDateTime(signOpenMinuteSelect, oneToTwoDigitFormat(returnClosestMinute(getDateTime("minute"))));
		selectDateTime(signOpenTimeZoneSelect, timeZone);
			
			
		}
	
	public void setFinishDateAndTime(String day, String month, String year, String hour, String minute, String timeZone){//pick proper elements base on choice
		selectDateTime(signCloseDaySelect, day);
		selectDateTime(signCloseMonthSelect, month);
		selectDateTime(signCloseYearSelect, year);
		selectDateTime(signCloseHourSelect, hour);
		selectDateTime(signCloseMinuteSelect, minute);
		selectDateTime(signCloseTimeZoneSelect, timeZone);		
		
	}
	




///methods required fo seT start date and Time with current time method
public static String getDateTime(String elementOfDateAndTime) {
		String resultElement = null;
		Calendar calendar = Calendar.getInstance();
			switch( elementOfDateAndTime) {
			case "day":
				resultElement=Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
					break;
			case "month":
				resultElement=Integer.toString(calendar.get(Calendar.MONTH)+1);
				break;
			case "year": 
				resultElement=Integer.toString(calendar.get(Calendar.YEAR));
				break;
			case "hour": 
				resultElement=Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
				break;
			case "minute": 
				resultElement=Integer.toString(calendar.get(Calendar.MINUTE));
				break;
			
			default:
				break;
			
			}
		return resultElement;	
		
		
		
		}

public void selectDateTime(WebElement element, String dateTimeElement) {
		Select selectDrop = new Select(element);
		selectDrop.selectByVisibleText(dateTimeElement);
	}
	
public String changeMonthNumberToString(String monthNo)//calendars returns moths as int but in calendar selection only full month names are visible

	{
		String month=null;
		
		switch(monthNo) {
		case "1":
			month="January";
			break;
		case "2":
			month="February";
			break;
		case "3":
			month="March";
			break;
		case "4":
			month="April";
			break;
		case "5":
			month="May";
			break;
		case "6":
			month="June";
			break;
		case "7":
			month="July";
			break;
		case "8":
			month="August";
			break;
		case "9":
			month="September";
			break;
		case "10":
			month="October";
			break;
		case "11":
			month="November";
			break;
		case "12":
			month="December";
			break;
		default:
			break;
		
		}
		
		
		
		
		
				
		
		return month;
	}

public String oneToTwoDigitFormat(String oneDigitFormatNo)//calendar in case o hours from 0 to 1 returns only 1 digit so  i have to chage to return 2 digits
	{	String twoDigitFormat=oneDigitFormatNo;
		
		int number=Integer.parseInt(oneDigitFormatNo);
		if(number<10)
			twoDigitFormat="0"+oneDigitFormatNo;
		
		return  twoDigitFormat;
	}
	
public String returnClosestMinute(String minute)//because 5 minutes options minutes will round up 
	{
		int finalMin=0;
		int numMin=Integer.parseInt(minute);
		
		if(numMin>0 && numMin<=5)
			finalMin=5;
		else if(numMin>5 && numMin<=10)
			finalMin=10;
		else if(numMin>10 && numMin<=15)
			finalMin=15;
		else if(numMin>15 && numMin<=20)
			finalMin=20;
		else if(numMin>20 && numMin<=25)
			finalMin=25;
		else if(numMin>25 && numMin<=30)
			finalMin=30;
		else if(numMin>30 && numMin<=35)
			finalMin=35;
		else if(numMin>35 && numMin<=40)
			finalMin=40;
		else if(numMin>40 && numMin<=45)
			finalMin=45;
		else if(numMin>45 && numMin<=50)
			finalMin=50;
		else if(numMin>50 && numMin<=55)
			finalMin=55;
		else if(numMin>55 && numMin<=59)
			finalMin=0;		
		return Integer.toString(finalMin);
	}
	//onetoTwoDigt(closestMin(getDate)))
	
	
	
	
	
	
	
	}

	







