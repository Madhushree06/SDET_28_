package genericUtility;	

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
/**
 * this class includes all the annotations
 * @author Ammu
 *
 */
	public class BaseClass {
		//object creation
		public WebDriver driver;
		public static WebDriver sdriver;
		public FileUtility fUtil=new FileUtility();
		public JavaUtility jUtil=new JavaUtility();
		public WebDriverUtility wUtil= new WebDriverUtility();
		public ExcelUtility eUtil = new ExcelUtility();
		
		
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBs() {
		//connection to db
		System.out.println("Connect to DB");
		
	}
	
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBc() throws Throwable {
		//launching the browser
		 String browser = fUtil.getPropertFileData("browser");
		 String url = fUtil.getPropertFileData("url");
		 
		 if(browser.equals("chrome"))
			{
				System.setProperty(IpathConstants.CHROME_KEY, IpathConstants.CHROME_PATH);
				driver=new ChromeDriver();
				
				
			}
			else if(browser.equals("firefox"))
			{
				driver=new FirefoxDriver();
				System.setProperty(IpathConstants.FIREFOX_KEY,IpathConstants.FIREFOX_PATH);
				
			}
			else
			{
			
				System.out.println("browser is not supported");
			}
			
			sdriver=driver;
			driver.manage().window().maximize();
			wUtil.waitForPageLoad(driver);
			driver.get(url);
		
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	
	public void configBm() throws Throwable
	{
		//getting the data from property files
		String username = fUtil.getPropertFileData("username");
		String password = fUtil.getPropertFileData("password");
		//Login to the application
		LoginPage login =new LoginPage(driver);
		login.loginToApplication(username, password);

		
	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAm() {
		//logout
		HomePage homePage=new HomePage(driver);
		homePage.logout();

	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAc() {
		//closing or quiting the browser
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAs() {
		//closing the database connection
		System.out.println("Database connection is closed");
		
	}
	
	}



