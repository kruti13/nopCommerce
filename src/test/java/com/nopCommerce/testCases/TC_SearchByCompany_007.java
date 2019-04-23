package com.nopCommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddCustomerPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.SearchByCompanyPage;
import com.nopCommerce.pageObjects.SearchByEmailPage;

public class TC_SearchByCompany_007 extends BaseClass{
	
	@Test
	public void searchbycname() throws IOException, InterruptedException
	{
	logger.info("**********Started TC_SearchByCompany_007*************");
	driver.get(baseURL);
	LoginPage lp = new LoginPage(driver);
	lp.setUsername(useremail);
	lp.setPassword(password);
	lp.setLogin();
	logger.info("***************Logged in************************");
	
	AddCustomerPage addcust = new AddCustomerPage(driver);
	logger.info("***************Click on Customer menu************************");
	addcust.setCustomerItem();
	addcust.clkCustomermenu();
	addcust.clkCustomermenuItem();
	
	logger.info("***************Search By company************************");
	SearchByCompanyPage srchcname = new SearchByCompanyPage(driver);
	srchcname.setcompanyname("AliceInWonderland Corp");
	srchcname.clkSearch();
	
	Thread.sleep(3000);
	
	//Validation
	logger.info("**********Search Validation*************");
	
	SearchByEmailPage srchemail = new SearchByEmailPage(driver);
	int rows = srchemail.getrowscount();
	logger.info("**********Print rows*************");
	System.out.println("Rows = " +rows);
	
	int cols = srchemail.getcolcount();
	logger.info("**********Print columns*************");
	System.out.println("Columns = " +cols);
	
	String cnamedata = srchemail.getmaildata();
	boolean flag = false;
	for(int i=1;i<=rows;i++)
	{
		if(cnamedata.equalsIgnoreCase("AliceInWonderland Corp"))
		{
			logger.info("**********Match found************");
			Assert.assertTrue(true);
			flag = true;
		}
		if(flag == false)
		{
			logger.error("************No match found************");
			captureScreen(driver,"searchbycname");
			Assert.assertTrue(false);
		}
	}
	
	
		
		
	}
	

}
