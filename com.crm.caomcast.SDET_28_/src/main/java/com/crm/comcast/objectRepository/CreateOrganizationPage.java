package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Create organization POM class
 * @author Ammu
 *
 */
public class CreateOrganizationPage {
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="qtyinstock")
	private WebElement qtyInstockTextField;
	
	public WebElement getQtyInstockTextField() {
		return qtyInstockTextField;
	}
	@FindBy(id="qty_per_unit")
	private WebElement qtyPerUnitTextField;
	
	public WebElement getQtyPerUnitTextField() {
		return qtyPerUnitTextField;
	}
	@FindBy(id="unit_price")
	private WebElement unitPriceTextField;
	
	public WebElement getUnitPriceTextField() {
		return unitPriceTextField;
	}
	@FindBy(name="accountname")
	private WebElement organizationTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getCommisionrteTextField() {
		return commisionrteTextField;
	}
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(name="commissionrate")
	private WebElement commisionrteTextField;
	
	//getter method
	public WebElement getOrganizationTextField() {
		return organizationTextField;

	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * this method will create an organization
	 * @param orgName
	 */
	 
	public void createOrganization(String orgName) {
		organizationTextField.sendKeys(orgName);
		saveButton.click();
	}
	public void createProductName(String productNames)
	{
		productNameTextField.sendKeys(productNames);

	}
	
	public void createProductNames( String commisionRate )
	{
		//productNameTextField.sendKeys(productName);
		//unitPriceTextField.sendKeys(unitPrice);
		commisionrteTextField.sendKeys(commisionRate);
		saveButton.click();
	}
	
	public void productUnitPrice(String unitPrice)
	{
		unitPriceTextField.clear();
		unitPriceTextField.sendKeys(unitPrice);
		

	}
	
	public void productQrtPerUnit(String qtyPerUnit) {
		qtyPerUnitTextField.sendKeys(qtyPerUnit);
	}
	
	public void productQtyInStock(String qtyInStock) {
		qtyInstockTextField.sendKeys(qtyInStock);
	}
	
}

