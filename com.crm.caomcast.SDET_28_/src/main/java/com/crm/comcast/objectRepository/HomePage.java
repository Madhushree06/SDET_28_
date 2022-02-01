package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility  {
	
	//initialization of elements
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//declaration of elements
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	public WebElement getProductsLink() {
		return productsLink;
	}
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement logoutImg;
	
	@FindBy(xpath="//a[text()=\"Sign Out\"]")
	private WebElement signOutLink;
	public WebDriver getDriver() {
		return driver;
	}
//getter methods
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//business logics
	/**
	 * This method will click on organization link
	 */
	
	public void clickOrganizationLink() {
		organizationLink.click();
	}
	
	public void clickProductsLink() {
		productsLink.click();
	}
	/**
	 * this method will perform logout actions
	 */
public void logout() {
	mouseOver(driver, logoutImg);
	signOutLink.click();
}
}
