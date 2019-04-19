package com.nopCommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By lnkCustomermenu = By.linkText("Customers");
	By lnkCustomermenu_item = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a");
	By btnAddnew = By.xpath("/html/body/div[3]/div[3]/div/form[1]/div[1]/div/a");
	
	By txtEmail = By.id("Email");
	By txtpassword = By.id("Password");
	
	By txtcustomerRole = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstitemRegister = By.xpath("//span[contains(text(),'Registered')]");
	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpVendorMgr = By.id("VendorId");
	
	By rdGenderMale = By.id("Gender_Male");
	By rdGenderFemale = By.id("Gender_Female");
	
	By txtfirstname = By.id("FirstName");
	By txtlastname = By.id("LastName");
	
	By txtDOB = By.id("DateOfBirth");
	//By btstrpDOBpicker = By.id("//span[@class='k-select']");
	
	By txtCompanyname = By.id("Company");
	By txtAdmincomment = By.id("AdminComment");
	
	/*By rdTaxExempt = By.id("IsTaxExempt");
	By rdNewsletter1 = By.xpath("//input[@value='1']");
	By rdNewsletter2 = By.xpath("//input[@value='2']");
	By rdActiveStatus = By.xpath("//input[@id='Active']");*/
	
	By btnSave = By.xpath("//button[@name='save']");
	
	public void clkCustomermenu()
	{
		ldriver.findElement(lnkCustomermenu).click();
	}
	public void clkCustomermenuItem()
	{
		ldriver.findElement(lnkCustomermenu_item).click();
	}
	public void clkAddCustomer()
	{
		ldriver.findElement(btnAddnew).click();
	}
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setpassword(String pwd)
	{
		ldriver.findElement(txtpassword).sendKeys(pwd);
	}
	public void setcustomerRole(String role) throws InterruptedException
	{
		ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		
		ldriver.findElement(txtcustomerRole).click();
		WebElement listitem;
		
		Thread.sleep(3000);
		
		if(role.equals("Administrators"))
		{
			listitem = ldriver.findElement(lstitemAdministrators);
		}
		else if(role.equals("Forum Moderators"))
		{
			listitem = ldriver.findElement(lstitemModerators);
		}
		else if(role.equals("Guests"))
		{
			listitem = ldriver.findElement(lstitemGuests);
		}
		else if(role.equals("Vendors"))
		{
			listitem = ldriver.findElement(lstitemVendors);
		}
		else
		{
			listitem = ldriver.findElement(lstitemRegister);
		}
		
		listitem.click();
	}
	
	public void setVendorMgr(String vendor)
	{
		Select sel_vendor = new Select(ldriver.findElement(drpVendorMgr));
		sel_vendor.selectByVisibleText(vendor);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdGenderMale).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdGenderFemale).click();
		}
		else 
		{
			ldriver.findElement(rdGenderMale).click();      //Default value
		}
	}
	
	public void setfirstname(String fname)
	{
		ldriver.findElement(txtfirstname).sendKeys(fname);
	}
	
	public void setlastname(String lname)
	{
		ldriver.findElement(txtlastname).sendKeys(lname);
	}
	
	public void setDOBmmddyyyy(String dob)
	{
		ldriver.findElement(txtDOB).sendKeys(dob);
	}
	
	public void setCompanyname(String cname)
	{
		ldriver.findElement(txtCompanyname).sendKeys(cname);
	}
	
	public void setAdminComment (String adcomment)
	{
		ldriver.findElement(txtAdmincomment).sendKeys(adcomment);
	}
	/*public void clkTaxexempt()
	{
		ldriver.findElement(rdTaxExempt).click();
	}
	
	public void clkNewsletter(String letter)
	{
		if(letter.contains("Your store name"))
		{
			ldriver.findElement(rdNewsletter1).click();
		}
		else if(letter.contains("Test store 2"))
		{
			ldriver.findElement(rdNewsletter2).click();
		}
	}
	
	public void clkStatus()
	{
		ldriver.findElement(rdActiveStatus).click();
	}
	*/
	
	public void clkSave()
	{
		ldriver.findElement(btnSave).click();
	}
	
	
}
