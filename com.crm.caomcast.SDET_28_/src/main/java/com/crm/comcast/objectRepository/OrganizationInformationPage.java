package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Organization information pom class
 * @author Ammu
 *
 */

public class OrganizationInformationPage {
	public OrganizationInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgInfoText;
	
	
	
	//getters method
	public WebElement getOrgInfoText() {
		return orgInfoText;
	}
	
	public String getOrgInformationText() {
		return orgInfoText.getText();
	}
	

}
