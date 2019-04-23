package com.nopCommerce.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchByEmailPage {
	
	WebDriver ldriver;
	
	public SearchByEmailPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@id='SearchEmail']") WebElement email;
	
	
	By tblcustrow = By.xpath("//table[@role='grid']/tbody/tr");
	
	By tblcustcol = By.xpath("//table[@role='grid']/tbody/tr[1]/td");
	
	By tblemaildata = By.xpath("//table[@role='grid']/tbody/tr/td[2]");
	
	@FindBy(xpath="//*[@id='search-customers']") WebElement btnSearch;
	
	/* By pglinks = By.xpath("//div[@class='k-pager-wrap k-grid-pager k-widget']");
	By pgprev = By.xpath("//span[@class='k-icon k-i-arrow-w']");
	By pgfirst = By.xpath("//span[@class='k-icon k-i-seek-w']");
	By pgnext = By.xpath("//span[@class='k-icon k-i-arrow-e']");
	By pglast = By.xpath("//span[@class='k-icon k-i-seek-e']"); */
	
	
	
	
	
	public void setemailid(String mailid)
	{
		email.sendKeys(mailid);
	}
	
	public int getrowscount()
	{
		int rowcount = ldriver.findElements(tblcustrow).size();
		return rowcount;
	}

	public int getcolcount()
	{
		int colcount = ldriver.findElements(tblcustcol).size();
		return colcount;
	}

	public String getmaildata()
	{
		String mail = ldriver.findElement(tblemaildata).getText();
		return mail;
		
	}
	
	public void clkSearch()
	{
		btnSearch.click();
	}
	
/*	public int setpglink()
	{
		List<WebElement> links = ldriver.findElements(pglinks);
		return links.size();
	}
	
	public void clkpgprev()
	{
		ldriver.findElement(pgprev).click();
	}
	public void clkpgfirst()
	{
		ldriver.findElement(pgfirst).click();
	}
	
	public void clkpgnext()
	{
		ldriver.findElement(pgnext).click();
	}
	
	public void clkpglast()
	{
		ldriver.findElement(pglast).click();
	}*/
	
	
	
	
}
