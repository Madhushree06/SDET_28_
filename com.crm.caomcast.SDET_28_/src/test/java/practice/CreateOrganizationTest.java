package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		// java object representation of physical property file
				FileInputStream fis=new FileInputStream("./src/test/resources/data1.properties");
				
				//create an object for properties class
				
				Properties property = new Properties();
				 // load the key and values from property object
				
				property.load(fis);
				
				//fetch the values using respective keys
				
				String url = property.getProperty("url");
				String username = property.getProperty("username");
				String password = property.getProperty("password");
				String browserName=property.getProperty("browser");
				
				//how to use browser values and launch the browser
				WebDriver driver=null;
				if(browserName.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
					driver=new ChromeDriver();
					
					
				}
				else if(browserName.equals("firefox"))
				{
					driver=new FirefoxDriver();
					System.setProperty("webdriver.gecko.driver","/src/main/resources/geckodriver.exe");
					
				}
				else
				{
				
					System.out.println("browser is not supported");
				}
				
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.get(url);
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]"));
				driver.findElement(By.name("accountname")).sendKeys("Test yantra");
		        driver.findElement(By.name("button")).click();		
				//organization name verification
		        String actualOrgName=driver.findElement(By.xpath("//span[@class='dvHeader Text']")).getText();
		        if(actualOrgName.contains("Test yantra"))
		        {
		        	System.out.println("organization is created");
		        }
		        else {
		        	System.out.println("Organization is not created");
		        }
		        WebElement profileImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        Actions action = new Actions(driver);
		        action.moveToElement(profileImg).perform();
		        driver.findElement(By.linkText("Sign Out")).click();			
				driver.quit();	

	}

}
