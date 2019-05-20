package testCasesZadania;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import testCase2.CertificationCompletion;
import testCase2.ManageDashboard;
import testCase2.SaveThisSearch;

public class TestCase2 {
	WebDriver driver;
	Random rand;
	ManageDashboard manageDash;
	CertificationCompletion certCompletion;
	SaveThisSearch thisSearch;
	String baseUrl;
	String saveNameSearch;
	List<WebElement> objectiveUserNameList;
	List<String> strngUserNameList;
	
	@Before
	public void setUp() {
		objectiveUserNameList=null;
		strngUserNameList=new ArrayList<String>();
		driver= new ChromeDriver();
		manageDash= new ManageDashboard(driver);
		certCompletion= new CertificationCompletion(driver);
		thisSearch= new SaveThisSearch(driver);
		rand= new Random();
		baseUrl="https://demo.totaralearning.com";
		saveNameSearch="Search Jason"+(Integer.toString(rand.nextInt(1000)+1));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		
		manageDash.loginManager();//login as manager
		
		Thread.sleep(1000);
		manageDash.clickctificationCompletion();//pick certification completion
		
		Thread.sleep(1000);
		certCompletion.fullNameDropdownStartsWithOption(3);//select starts with option
		
		Thread.sleep(1000);
		certCompletion.insertTextToFullNameTextField("Jason");//insert Jason to text field
		
		Thread.sleep(1000);
		certCompletion.clickSearchBtn();//click search Btn
		
		//AssertDueDate
		Assert.assertTrue(certCompletion.retriveColumnDataFromTable(3).contains("27 Jul 2018 at 09:55"));
		//click UserPositions Name
		Thread.sleep(1000);
		certCompletion.clickUserPositionNameHeader();
		//AssertUserOrganisationName 
		Assert.assertTrue(certCompletion.retriveColumnDataFromTable(7).contains("Internal Helpdesk"));
		
		//click Save this serarch btn
		Thread.sleep(1000);
		certCompletion.clickSaveThisSearchBtn();
		
		//provide searched Name
		Thread.sleep(1000);
		thisSearch.insertSearchedNameToNameField(saveNameSearch);
		
		//save changes
		Thread.sleep(1000);
		thisSearch.clickSaveChangesBtn();
		
		//Click Clear btn
		Thread.sleep(1000);
		certCompletion.clickClearBtn();
		
		//Set Status to is equal
		Thread.sleep(1000);
		certCompletion.selectFirstStatusDropDownOption(1);
		
		//SetSecond Status to Expired
		Thread.sleep(1000);
		certCompletion.selectSecondStatusDropDownOption(4);
		
		//Click Search
		Thread.sleep(1000);
		certCompletion.clickSearchBtn();
		
		//retrive user Name into list
		objectiveUserNameList=certCompletion.getFirstColumnValues(1);
		// add text elements from web element list to string list
		certCompletion.copyTextToAnotherList(objectiveUserNameList, strngUserNameList);
				
		
		//from Select and View saved result
		Thread.sleep(1000);
		certCompletion.selectViewAndSearch(saveNameSearch);
		
		//assert 1st coulumn name is JasonConarch
		Assert.assertTrue(certCompletion.retriveColumnDataFromTable(1).contains("Jason Cochran"));

		//logout from the page
		Thread.sleep(1000);
		certCompletion.logOut();
		
		System.out.println("List Content: ");
		certCompletion.printList(strngUserNameList);
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
		
		
	}
}
