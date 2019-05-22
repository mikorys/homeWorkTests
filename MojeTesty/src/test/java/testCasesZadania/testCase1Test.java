package testCasesZadania;



import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testCase1.AddNewOrganisationPage;
import testCase1.AddNewOrganisationFrameworkPage;
import testCase1.AdminDashboardPage;

import testCase1.NewlyCreatedOrganisationPage;
import testCase1.OrganisationFrameworksPage;

public class testCase1Test {

	WebDriver driver;
	Random rand;
	AdminDashboardPage dashboard;
	OrganisationFrameworksPage orgFramw;
	AddNewOrganisationFrameworkPage addOrgFram;
	AddNewOrganisationPage addNewOrg;
	NewlyCreatedOrganisationPage newCreatedOrg;
	
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
		dashboard= new AdminDashboardPage(driver);
		orgFramw= new OrganisationFrameworksPage(driver);
		addOrgFram= new AddNewOrganisationFrameworkPage(driver);
		addNewOrg= new AddNewOrganisationPage(driver);
		newCreatedOrg= new NewlyCreatedOrganisationPage(driver);
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
		dashboard.loginAdmin();//login as admin
		dashboard.selectOrganisationsBookmark();
		orgFramw.clickAddNewOrganisationFramework();//click add organisation framework
		addOrgFram.insertTextToName(organisationFrameworkName);//fillName ID and Description
		addOrgFram.insertTextToIDNumber(organisationFrameworkId);
		addOrgFram.insertTextToDescription(frameworkDescription);
		addOrgFram.clickSaveBtn();//click save Btn
		Assert.assertTrue(orgFramw.returnAlertText().contains("The organisation framework \""+organisationFrameworkName+"\" has been added"));//checkTextAssertion of added text	
		addOrgFram.pickNewlyGeneratedOrganisation(organisationFrameworkName);//pick newly created organisation frameowork name
		addNewOrg.clickAddNewOrganisationBtn();//clickAddNewOrganisation		
		addNewOrg.insertTextToName(organisationName);//Fill NAME ID and Description
		addNewOrg.insertTextToIDNumber(organisationId);
		addNewOrg.insertTextToDescription(organisationDescription);
		addNewOrg.clickSaveBtn();
		Assert.assertTrue(newCreatedOrg.returnAlertText().contains("The organisation \""+organisationName+"\" has been added"));//Assert newlycreatedOrganisation
		newCreatedOrg.clickAddGoal();//clickAddGoalBtn
		newCreatedOrg.clickCreateTrainingManual();//click option		
		newCreatedOrg.clickSaveBtn();//click save BTN
		Thread.sleep(1000);
		newCreatedOrg.returnToOrgFramework();
		orgFramw.logOut();
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}

}
