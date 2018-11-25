package Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import PageObject_RandomDataGenaration.POM.HomePage;
import PageObject_RandomDataGenaration.POM.Login;
import PageObject_RandomDataGenaration.POM.NewCustomer;

//need to extent file
import ExtentReport.ExtentReport;

public class Test {
	 WebDriver driver;
	 
	    Login objLogin;
	    HomePage objHomePage;
	    NewCustomer objNewCustomer;

	    //crreate object
	    ExtentReport extRpt = new ExtentReport();

	    @BeforeTest
	    public void setup(){

	    	System.setProperty("webdriver.chrome.driver","D:\\se\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("http://demo.guru99.com/V4/");
	   
	    }

	    /**

	     * This test go to http://demo.guru99.com/V4/

	     * Verify login page title as guru99 bank

	     * Login to application

	     * Verify the home page using Dashboard message

	     */

	    @org.testng.annotations.Test(priority=0)
	    public void test_Home_Page_Appear_Correct(){

	    //Create Login Page object
	    extRpt.setUpReport();   // setup tp report 
	    objLogin = new Login(driver);
	    
	    //Login start test case
	    extRpt.startTestCase("User Login");
	   

	    //Verify login page title
	    String loginPageTitle = objLogin.getLoginTitle();
	    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
	    
	    //login to application
	    objLogin.loginToGuru99("mgr123", "mgr!23");
	    
	    //Test case pass or fail
	    extRpt.logEventsPass("pass");
	    
	    // go the next page
	    objHomePage = new HomePage(driver);

	    //Verify home page
	    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	    
	    }

	    @org.testng.annotations.Test(priority=1)
	    public void customer () {
	    	objNewCustomer = new NewCustomer(driver);
	    	
	    	 //Navigation  start test case
		    extRpt.startTestCase("Navigation");
	    	objNewCustomer.navigateNewCustomer(driver);    	  
	    	objNewCustomer.createNewCustomer();
	    	
	    	 //Navigation Test case pass or fail
		    extRpt.logEventsPass("Created ");
		    
	    		  
	    	  driver.close();
	    	  extRpt.createFinalReport();
	    	  
	    }
	    
	   
	    
	    
	   
	    
}
