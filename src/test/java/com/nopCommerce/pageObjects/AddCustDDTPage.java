package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustDDTPage {

WebDriver ldriver;
	
	public AddCustDDTPage(WebDriver rdriver)
	{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user']") WebElement clkCustomeritem;
	@FindBy(xpath="//a[@href='#']//span[contains(text(),'Customers')]") WebElement clkCustomersMenu;
	@FindBy(xpath="//span[@class='menu-item-title'][contains(text(),'Customers')]") WebElement clkCustomersSubMenu;
	@FindBy(xpath="//a[@class='btn bg-blue']") WebElement clkAddNew;
		
	@FindBy(id="Email") WebElement txtEmail;
	@FindBy(id="Password") WebElement txtpassword;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']") WebElement txtCustRole;
	@FindBy(xpath="//span[@class='k-icon k-delete']") WebElement clkClose;
	@FindBy(xpath="//li[contains(text(),'Administrators')]") WebElement clkAdmin;
	@FindBy(xpath="//li[contains(text(),'Forum Moderators')]") WebElement clkForMod;
	@FindBy(xpath="//li[contains(text(),'Guests')]") WebElement clkGuests;
	@FindBy(xpath="//li[contains(text(),'Registered')]") WebElement clkRegistered;
	@FindBy(xpath="//li[contains(text(),'Vendors')]") WebElement clkVendors;
	
	
	@FindBy(id="VendorId") WebElement selVendor;
	
	@FindBy(id="Gender_Male") WebElement clkMale;
	@FindBy(id="Gender_Female") WebElement clkFemale;
	
	@FindBy(id="FirstName") WebElement txtFirstname;
	@FindBy(name="LastName") WebElement txtLastname;
	@FindBy(id="DateOfBirth") WebElement txtDobddmmyyyy;
	
	@FindBy(xpath="//span[@class='k-select']") WebElement btstpDob;
	By btstpdobmmyyy = By.xpath("//a[@class='k-link k-nav-fast']");
	By btstptbldate = By.xpath("//table[@role='grid']/tbody/tr/td");
	By btstpLeftarrow = By.xpath("//span[@class='k-icon k-i-arrow-w']");
	
	@FindBy(id="Company") WebElement txtCompname;
	@FindBy(id="AdminComment") WebElement txtAdCom;
	
	@FindBy(id="IsTaxExempt") WebElement clkTax;
	
	@FindBy(xpath="//*[@id=\"tab-info\"]/div/div/div/div[12]/div[2]/div[1]/label/input") WebElement clkUrStore;
	@FindBy(xpath="//*[@id=\"tab-info\"]/div/div/div/div[12]/div[2]/div[2]/label/input") WebElement clkTestStore;
 	
	@FindBy(id="Active") WebElement clkStatus;
	
	@FindBy(xpath="//button[@name='save']") WebElement btnSave;
	
	public void clkCustomerItem()
	{
		clkCustomeritem.click();
	}
	public void clkCustomerMenu()
	{
		clkCustomersMenu.click();
	}
	public void clkCustomerSubMenu()
	{
		clkCustomersSubMenu.click();
	}
	public void clkAddNew()
	{
		clkAddNew.click();
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPassword(String paswd)
	{
		txtpassword.sendKeys(paswd);
	}
	
	public void setCustRole(String role)
	{
				
	if(role.equals("Administrators"))
	{
		clkClose.click();
		txtCustRole.click();
		clkAdmin.click();
	}
	else if(role.equals("Forum Moderators"))
	{
		clkClose.click();
		txtCustRole.click();
		clkForMod.click();
	}
	else if(role.equals("Guests"))
	{
		clkClose.click();
		txtCustRole.click();
		clkGuests.click();
	}
	else if(role.equals("Vendors"))
	{
		//clkClose.click();
		txtCustRole.click();
		clkVendors.click();		
	}
	}
	
	public void setVendorId(String vid)
	{
		
		
		Select vendorid = new Select(selVendor);
		vendorid.selectByVisibleText(vid);
	}
	
	public void setgender(String gender)
	{
		if(gender.equals("Male"))
		{
			clkMale.click();
		}
		else if(gender.equals("Female"))
		{
			clkFemale.click();
		}
	}
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	public void setDOB(String dob)
	{
		txtDobddmmyyyy.sendKeys(dob);
	}
	public void setDOBpicker(String dd, String mmyyyy) throws InterruptedException
	{
		while (true)
			
		{
			String monthyr = ldriver.findElement(btstpdobmmyyy).getText();
			if(monthyr == mmyyyy)
			{
				break;
			}
			else
			{
				ldriver.findElement(btstpLeftarrow).click();
			}
			
		}
		Thread.sleep(2000);
		
		ldriver.findElement(By.xpath("//table[@role='grid']/tbody/tr/td/a[contains(text(),'dd')]")).click();
		
		
	}
	
	public void setcompanyname(String cname)
	{
		txtCompname.sendKeys(cname);
	}
	
	public void setadminComment(String adcom)
	{
		txtAdCom.sendKeys(adcom);
	}
	
	public void setTax(String tax)
	{
		if(tax.equals("Y"))
		{
			clkTax.click();
		}
	}
	public void setnewsletter(String letter)
	{
		if (letter.equalsIgnoreCase("Your store"))
		{
			clkUrStore.click();
		}
		else if(letter.equalsIgnoreCase("Test Store"))
		{
			clkTestStore.click();
		}
	}
	public void setActive(String stat)
	{
		if(stat.equalsIgnoreCase("N"))
		{
			clkStatus.click();
		}
	}
	
	public void clkSave() {
		
		btnSave.click();
		
	}
}
