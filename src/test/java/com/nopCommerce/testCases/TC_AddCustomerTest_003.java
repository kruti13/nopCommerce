package com.nopCommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopCommerce.pageObjects.AddCustomerPage;
import com.nopCommerce.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
	
	logger.info("************* Started TC_AddCustomerTest_003******************");
	driver.get(baseURL);
	logger.info("*************Opened URL*************************");
	
	LoginPage lp = new LoginPage(driver);
	logger.info("***************Providing login details********************");
	lp.setUsername(useremail);
	lp.setPassword(password);
	lp.setLogin();
	logger.info("*************** Logged in ********************");
	
	logger.info("************* Add New Customer Test begins***********************");
	AddCustomerPage addcust = new AddCustomerPage(driver);
	
	addcust.clkCustomermenu();
	addcust.clkCustomermenuItem();
	addcust.clkAddCustomer();
	
	logger.info("*************** Adding customer details ********************");
	String mailid = randomString()+"@gmail.com";
	addcust.setEmail(mailid);
	addcust.setpassword("AnyaRaj");
	addcust.setcustomerRole("Guests");
	addcust.setVendorMgr("Not a vendor");
	addcust.setGender("Female");
	addcust.setfirstname("Anya");
	addcust.setlastname("Raj");
	addcust.setDOBmmddyyyy("01/16/2000");
	addcust.setCompanyname("Anya Tech Ltd.");
	addcust.setAdminComment("This is for testing purposes!!!");
	/*addcust.clkTaxexempt();
	addcust.clkNewsletter("Your store name");
	addcust.clkStatus();*/
	
	//Thread.sleep(3000);
	
	addcust.clkSave();
	
	logger.info("*************** Customer details saved********************");
	
		
	//Validation
	logger.info("***********Add New Customer Page validation test **************************************");
	String msg = driver.findElement(By.tagName("body")).getText();
	if(msg.contains("The new customer has been added successfully"))
	{
		logger.info("********Customer added successfully***************");
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("********Customer NOT added ***************");
		captureScreen(driver, "addNewCustomer");
		Assert.assertTrue(false);
	}
	
	logger.info("************* Completed TC_AddCustomerTest_003******************");
	
	
	
	
	}
	
	
	

}
