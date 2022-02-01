package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class SearchProductPage extends WebDriverUtility {
	@FindBy(name="search_text")
	private WebElement searchTextField;
	
	@FindBy(id="bas_searchfield")
	private WebElement searcDropDown;
	
	@FindBy(xpath=" //input[@value=\" Search Now \"]")
	private WebElement searchButton;
	
	public SearchProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearcDropDown() {
		return searcDropDown;
	}

	public void searchTextField(String commisionRate) {
		searchTextField.sendKeys(commisionRate);
	}
	
	public void searchDropDown( ) {
		selectOption(searcDropDown, "commissionrate");
		selectOption(searcDropDown, 6);
		selectOption(searcDropDown,"qty_per_unit");
		selectOption(searcDropDown,"qtyinstock");
	}
		public void searchNow() {
			searchButton.click();

		}
	
}




