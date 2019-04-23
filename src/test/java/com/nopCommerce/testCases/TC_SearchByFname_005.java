package com.nopCommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddCustomerPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.SearchByEmailPage;
import com.nopCommerce.pageObjects.SearchByFirstNamePage;

public class TC_SearchByFname_005 extends BaseClass{
	
	@Test
	public void searchByfname() throws IOException, InterruptedException
	{
		logger.info("************Started TC_SearchByFname_005************");
		driver.get(baseURL);
		logger.info("*************Opened URL*************************");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("***************Providing login details********************");
		lp.setUsername(useremail);
		lp.setPassword(password);
		lp.setLogin();
		logger.info("***************Logged in********************");
		
		logger.info("***************Search by First name********************");
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.setCustomerItem();
		addcust.clkCustomermenu();
		addcust.clkCustomermenuItem();		
		
		SearchByFirstNamePage srchfname = new SearchByFirstNamePage(driver);
		srchfname.setFirstname("Brenda");
		srchfname.clkSearch();
		
		Thread.sleep(3000);
		
		//Validation
		logger.info("***************Search validation********************");
		
		SearchByEmailPage srchemail = new SearchByEmailPage(driver);
		int rows = srchemail.getrowscount();
		logger.info("**************Print rows***********");
		System.out.println("Rows=" +rows);
		
		int cols = srchemail.getcolcount();
		logger.info("**************Print columns***********");
		System.out.println("Columns=" +cols);
		
		String firstname = srchfname.getfnamedata();
		
		boolean flag = false;
		for(int i=1; i<=rows;i++)
		if(firstname.contains("Brenda"))
		{
		logger.info("*****************Match found***************");
		Assert.assertTrue(true);
		flag = true;
		}
		if(flag == false)
		{
		logger.error("*****************No Matches found***************");
		captureScreen(driver,"searchByfname");
		Assert.assertTrue(false);
		}
		
		logger.info("************Completed TC_SearchByFname_005************");
		
	}
	
	

}
