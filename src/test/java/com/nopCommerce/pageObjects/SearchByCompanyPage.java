package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchByCompanyPage {

	WebDriver ldriver;
	
	public SearchByCompanyPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="SearchCompany") WebElement txtCname;
	
	@FindBy(xpath="//button[@id='search-customers']") WebElement btnSearch;
	
	By tblcnamedata = By.xpath("//table[@role='grid']/tbody/tr/td[5]");
	
	public void setcompanyname(String cname)
	{
		txtCname.sendKeys(cname);
	}
	
    public void clkSearch()
    {
    	btnSearch.click();
    }
    public void gettblcname()
    {
    	ldriver.findElement(tblcnamedata).getText();
    }
}
