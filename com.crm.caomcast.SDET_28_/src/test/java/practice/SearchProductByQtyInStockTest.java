package practice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class SearchProductByQtyInStockTest extends BaseClass {
	@Test(groups={"regressionTest"})
	public void productByQtyInStock() throws Throwable {
		
	
	
	HomePage homePage=new HomePage(driver);
	homePage.clickProductsLink();
	
	OrganizationPage orgPage=new OrganizationPage(driver);
	orgPage.clickCreateOrgImg();
	
	CreateOrganizationPage createOrgPage =new CreateOrganizationPage(driver);
	 String productNames = eUtil.getStringCellData("Sheet1",1,0);
	 createOrgPage.createProductName(productNames);
	 String qtyInStock = eUtil.getStringCellData("Sheet1",1,2);

	createOrgPage.productQtyInStock(qtyInStock);
	homePage.clickProductsLink();
	SearchProductPage serchPro=new SearchProductPage(driver);
	 serchPro.searchTextField(qtyInStock);
	 serchPro.searchDropDown();
	 serchPro.searchNow();
	
	
	 //verification
	 String actualProductName="Micromax";
	 String expectedProductName=eUtil.getStringCellData("Sheet1",1,0);

	 Assert.assertEquals(expectedProductName,actualProductName);

	 
	 	
	 
}
}
