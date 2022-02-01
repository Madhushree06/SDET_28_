package genericUtility;

import java.io.OutputStream;
import java.io.File;
import java.util.Iterator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.google.protobuf.GeneratedMessageV3.Builder;
/**
 * 
 * @author Ammu
 *
 */

public class WebDriverUtility {
	/**
	 * 
	 * it will wait for 20 seconds till the element load in DOM
	 * @param driver
	 */
	
	 public void waitForPageLoad(WebDriver driver)
	 {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 
	 }
	 /**
	  * 
	  * This method will wait till element is vissible
	  * @param driver
	  * @param element
	  */
	 public void waitForVisibilityOfElelment(WebDriver driver, WebElement element)
	 {
		 WebDriverWait wait=new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 
/**
 * 
 * This is element will wait till element to be clickable
 * @param driver
 * @param element
 */
	 public void waitForElementToBeClick(WebDriver driver, WebElement element)
	 {
		 WebDriverWait wait=new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.visibilityOf(element));
		 element.click();
		 	 }
	 
	 /**
	  * This is method is used to wait  for the element and do click operation
	  * @param element
	  * @throws Throwable
	  */
	 public void waitandClick(WebElement element) throws Throwable
	 {
		 int count=0;
		 while(count<50)
		 {
			 try {
				 element.click();
				 
			 }catch(Throwable e) {
				 Thread.sleep(1000);
				 count++;
			 }
			 
		 }
		 
	 }

	 /**
	  * This method will select the element based on index
	  * @param driver
	  * @param string
	  */
  public void selectOption(WebElement ele,int string)
  {
	  Select select=new Select(ele);
	  select.selectByIndex(string);
	  
  }
  
  /**
   * 
   * This method will select the element based on value
   * @param element
   * @param value
   */
  public void selectOption(WebElement element,String value)
  {
	  Select select=new Select(element);
	  select.selectByValue(value);
	  
  }
  /**
   * 
   * This method will select the element based on visible text
   * @param element
   * @param text
   */
  
  public void selectOption(String text,WebElement element)
  {
	  Select select=new Select(element);
	  select.selectByVisibleText(text);
}
  /**
   * This method will verify whether the expected option is present in dropdown list or not
   * @param element
   * @param expectedOptions
   * @return
   */
  
  public WebElement verifyTheDropDownList(WebElement element, String expectedOptions) 
  {
	  Select select=new Select(element);
	  List<WebElement> options = select.getOptions();
	  for(WebElement ele:options)
	  if(ele.equals(expectedOptions))
	  {
		  System.out.println("value is present in dropdown");
	  }else {
		  System.out.println("value is not present");
		  return ele;
	  }
	  
  
  return null;
}
  /**
   * This method performs right click action
   * @param driver
   * @param element
   */
  public void mouseOver(WebDriver driver,WebElement element)
  {
	  Actions action=new Actions(driver);
	  action.moveToElement(element).perform();
  }
  /**
   * 
   * this menthod performs the right click actions
   * @param driver
   * @param element
   */
  public void rightClick(WebDriver driver,WebElement element)
  {
	  Actions action=new Actions(driver);
	  action.contextClick(element).perform();
  }
  /**
   * 
   * used to perform mjavascript click on webelement 
   * @param driver
   * @param element
   */
  public void jsClick(WebDriver driver,WebElement element)
  {
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click",element);
	  
  }
  /**
   * method is used to send the value using javascript executor
   * @param driver
   * @param valueToEnter
   * @param element
   */
  public void enterDataUsingJs(WebDriver driver,String valueToEnter, WebElement element)
  {
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].value='"+valueToEnter+"'", element);

  }
  /**
   * This method will swtich to different windows using partial title
   * @param driver
   * @param partialEindowTitle
   */
  public void switchWindow(WebDriver driver, String partialEindowTitle)
  {
	  Set<String> winIds = driver.getWindowHandles();
	  Iterator<String> it = winIds.iterator();
	  while(it.hasNext())
	  {
		  String winId = it.next();
		  String title = driver.switchTo().window(winId).getTitle();
		  if(title.contains(partialEindowTitle))
		  {
			  break;
			  
		  }
		  
	  }
  }
  
  /**
   * this method is used to take screenshot
   * @param driver
   * @param testCaseNmae
   * @return
   */
public String screenShot(WebDriver driver,String testCaseName)throws Throwable {
	 JavaUtility jUtil = new JavaUtility();
	String filePath = "./errorshot/"+testCaseName+jUtil.systemDateandTime()+".png";
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File destination = new File(filePath);
	FileUtils.copyFile(source,destination);
	//source.renameTo(destination);
	return filePath;
	}



/**
 * This method will switch the frames based on index passed
 * @param driver
 * @param index
 */
public void swtichFrames(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}

/**
 * This method will switch the frames based on name or id
 */
public void swtichFrames(WebDriver driver,String nameOrId) {
	driver.switchTo().frame(nameOrId);
}
/**
 * This method will switch frames based on the webelelmet passed
 * @param driver
 * @param element
 */
public void swtichFrames(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * Method will accept the alert
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * This method will dismiss the alert
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
}
