package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchByFirstNamePage {
	
	WebDriver ldriver;
	
	public SearchByFirstNamePage(WebDriver rdriver)
	{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	
	}
	
	@FindBy(id="SearchFirstName") WebElement txtFirstname;
	
	@FindBy(id="search-customers") WebElement btnSearch;
	
	@FindBy(xpath="//table[@role='grid']/tbody/tr/td[3]") WebElement tblfnamedata;
	
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}

	public void clkSearch()
	{
		btnSearch.click();
	}
	
	public String getfnamedata()
	{
		String fnamedata = tblfnamedata.getText();
		return fnamedata;
	}
	
}
