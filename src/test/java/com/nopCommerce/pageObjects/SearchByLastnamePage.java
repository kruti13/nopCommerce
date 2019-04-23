package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchByLastnamePage {

	WebDriver ldriver;
	
	public SearchByLastnamePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="SearchLastName") WebElement txtLastName;
	
	@FindBy(id="search-customers") WebElement btnSearch;
	
	By tblLnamedata = By.xpath("//table[@role='grid']/tbody/tr/td[3]"); 
	
	
	public void setLastname(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void clkSearch()
	{
		btnSearch.click();
	}
	
	public String getlnamedata()
	{
		String lnamedata = ldriver.findElement(tblLnamedata).getText();
		return lnamedata;
	}
	
}
