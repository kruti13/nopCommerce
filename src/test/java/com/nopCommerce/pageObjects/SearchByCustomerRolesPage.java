package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchByCustomerRolesPage {
	
	WebDriver ldriver;
	
	public SearchByCustomerRolesPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']") WebElement txtCustRole;
	
	@FindBy(xpath="//button[@id='search-customers']") WebElement btnSearch;
	
	By seladmin = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
	By selModerators = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
	By selGuests = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
	By selRegistered = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");
	By selVendors = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");
	
	By defaultcustrole = By.xpath("//span[@class='k-icon k-delete']");
	
	By tblcustrole = By.xpath("//table[@role='grid']/tbody/tr/td[4]");
	
	
	public void setCustrole(String custrole)
	{
		WebElement listitem = null;
		if(custrole.equals("Administrators"))
		{
			listitem = ldriver.findElement(seladmin);
		}
		else if(custrole.equals("Forum Moderators"))
		{
			listitem = ldriver.findElement(selModerators);
		}
		else if(custrole.equals("Guests"))
		{
			listitem = ldriver.findElement(selGuests);
		}
		else if(custrole.equals("Registered"))
		{
			listitem = ldriver.findElement(selRegistered);
		}
		else if(custrole.equals("Vendors"))
		{
			listitem = ldriver.findElement(selVendors);
		}
	
		listitem.click();
	}
	
	public void clkcustrole()
	{
		txtCustRole.click();
	}
	public void clkSearch()
	{
		btnSearch.click();
	}
	
	public void clkdefaultrole()
	{
		ldriver.findElement(defaultcustrole).click();
	}

	public String setroledata()
	{
		String roledata = ldriver.findElement(tblcustrole).getText();
		return roledata;
	}
}
