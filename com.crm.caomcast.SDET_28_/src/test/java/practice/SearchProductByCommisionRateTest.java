package practice;
import java.io.FileInputStream;
import com.crm.comcast.objectRepository.SearchProductPage;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.objectRepository.CreateOrganizationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganizationInformationPage;
import com.crm.comcast.objectRepository.OrganizationPage;
import com.crm.comcast.objectRepository.SearchProductPage;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.IpathConstants;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
/**
 * 
 * @author Ammu
 *
 */

public class SearchProductByCommisionRateTest extends BaseClass {
@Test(groups= {"smokeTest"})
public void productByCommisionRate() throws Throwable
{
	
		
		
		HomePage homePage=new HomePage(driver);
		homePage.clickProductsLink();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickCreateOrgImg();
		
		CreateOrganizationPage createOrgPage =new CreateOrganizationPage(driver);
		 String productNames = eUtil.getStringCellData("Sheet1",1,0);

		//String productNames;
		createOrgPage.createProductName(productNames);
		 String commisionRate=eUtil.getStringCellData("Sheet1", 1,1);

		createOrgPage.createProductNames(commisionRate);
		homePage.clickProductsLink();
		SearchProductPage serchPro=new SearchProductPage(driver);
		 serchPro.searchTextField(commisionRate);
		 System.out.println(commisionRate);
		 serchPro.searchDropDown();
		 serchPro.searchNow();
		 
	
		 //verification*/
		 OrganizationInformationPage orgInfoPage =new OrganizationInformationPage(driver);
		 String actualProductName="Micromax";
		 String expectedProductName=eUtil.getStringCellData("Sheet1",1,0);

		 /*if(actualProductName.contains(expectedProductName))
		 {
	        	System.out.println("product is created");

		 }
		 else{
			 System.out.println("Product is not created");
			 
		 }*/
		 
		 Assert.assertEquals(expectedProductName,actualProductName);
   
	}	
}
