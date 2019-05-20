package testCasesZadania;



import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testCase1.AddNewOrganisation;
import testCase1.AddNewOrganisationFramework;
import testCase1.AdminDashboard;

import testCase1.NewlyCreatedOrganisation;
import testCase1.OrganisationFrameworks;

public class testCase1Test {

	WebDriver driver;
	Random rand;
	AdminDashboard dashboard;
	OrganisationFrameworks orgFramw;
	AddNewOrganisationFramework addOrgFram;
	AddNewOrganisation addNewOrg;
	NewlyCreatedOrganisation newCreatedOrg;
	
	String baseURL;
	//organisationFramework
	String organisationFrameworkName;
	String organisationFrameworkId;
	String frameworkDescription;
	//newOrganisation
	String organisationName;
	String organisationId;
	String organisationDescription;
	

	@Before
	public void setUp(){
		driver=new ChromeDriver();
		rand= new Random();
		dashboard= new AdminDashboard(driver);
		orgFramw= new OrganisationFrameworks(driver);
		addOrgFram= new AddNewOrganisationFramework(driver);
		addNewOrg= new AddNewOrganisation(driver);
		newCreatedOrg= new NewlyCreatedOrganisation(driver);
		baseURL="https://demo.totaralearning.com/";
		
		//new organisation framework data
		organisationFrameworkName="New Test atuomation"+(Integer.toString(rand.nextInt(100)+1));
		organisationFrameworkId=Integer.toString(rand.nextInt(1000)+1);
		frameworkDescription="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna"
				+ " aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute "
				+ "irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non "
				+ "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		
		//new organisation data
		organisationName="Automation"+Integer.toString(rand.nextInt(100)+1);
		organisationId=Integer.toString(rand.nextInt(100)+1);//number betwen 1 100
		organisationDescription="Morbi luctus, nisi eget tempus faucibus, justo massa iaculis odio, "
				+ "eget sollicitudin lectus justo ut neque. Aliquam ornare urna sed vestibulum vestibulum. "
				+ "Donec at enim arcu. Aenean volutpat aliquam maximus. Aenean id scelerisque dolor, eget congue eros. "
				+ "Integer a mi non velit cursus aliquam vitae eu libero. Aliquam rutrum lorem eu vehicula feugiat. In hac"
				+ " habitasse platea dictumst. Aliquam erat volutpat.";
			
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(1000);
		dashboard.loginAdmin();//login as admirn
		Thread.sleep(1000);
		dashboard.selectOrganisationsBookmark();
		Thread.sleep(1000);
		orgFramw.clickAddNewOrganisationFramework();//click add organisation framework
		//fillName ID and Description
		Thread.sleep(1000);
		addOrgFram.insertTextToName(organisationFrameworkName);
		Thread.sleep(1000);
		addOrgFram.insertTextToIDNumber(organisationFrameworkId);
		Thread.sleep(1000);
		addOrgFram.insertTextToDescription(frameworkDescription);
		
		//click save Btn
		Thread.sleep(1000);
		addOrgFram.clickSaveBtn();
		//checkTextAssertion of added text
		Assert.assertTrue(orgFramw.returnAlertText().contains("The organisation framework \""+organisationFrameworkName+"\" has been added"));
		//pick newly created organisation frameowork name
		addOrgFram.pickNewlyGeneratedOrganisation(organisationFrameworkName);
		
		//clickAddNewOrganisation
		Thread.sleep(1000);
		addNewOrg.clickAddNewOrganisationBtn();
		
		//Fill NAME ID and Description
		addNewOrg.insertTextToName(organisationName);
		addNewOrg.insertTextToIDNumber(organisationId);
		addNewOrg.insertTextToDescription(organisationDescription);
		addNewOrg.clickSaveBtn();
		//Assert newlycreatedOrganisation
		Assert.assertTrue(newCreatedOrg.returnAlertText().contains("The organisation \""+organisationName+"\" has been added"));
		
		//clickAddGoalBtn
		newCreatedOrg.clickAddGoal();
		//click option
		Thread.sleep(1000);
		newCreatedOrg.clickCreateTrainingManual();
		//click save
		Thread.sleep(1000);
		
		
		
		newCreatedOrg.clickSaveBtn();//click save BTN
		
		
		//Rest works....go back to organisationFramework
		Thread.sleep(1000);
		newCreatedOrg.returnToOrgFramework();///it works when there is no popup window
		//logout
		orgFramw.logOut();
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}

}
