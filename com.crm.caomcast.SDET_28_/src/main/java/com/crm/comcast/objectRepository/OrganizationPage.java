package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
@FindBy(xpath="//img[@alt=\"Create Product...\"]")
private WebElement createPlusImages;

//getters method
public WebElement getCreatePlusImages() {
	return createPlusImages;
}

//bussiness logic
/**
 * This method will click on create organization plus img
 */
public void clickCreateOrgImg() {
	createPlusImages.click();
}
}
