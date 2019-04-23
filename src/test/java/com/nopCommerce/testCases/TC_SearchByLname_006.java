package com.nopCommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddCustomerPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.SearchByEmailPage;
import com.nopCommerce.pageObjects.SearchByLastnamePage;

public class TC_SearchByLname_006 extends BaseClass {
	
	@Test
	public void searchBylname() throws InterruptedException, IOException
	{
		logger.info("************* Started TC_SearchByLname_006******************");
		driver.get(baseURL);
		logger.info("*************Opened URL*************************");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("***************Providing login details********************");
		lp.setUsername(useremail);
		lp.setPassword(password);
		lp.setLogin();
		logger.info("*************** Logged in ********************");
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clkCustomermenu();
		addcust.clkCustomermenuItem();
		
		
		logger.info("*************** Last name search ********************");
		SearchByLastnamePage srchlname = new SearchByLastnamePage(driver);
		srchlname.setLastname("Terces");
		srchlname.clkSearch();
		
		Thread.sleep(3000);
		
				
		//Validation
		logger.info("*************** Last name search Validation ********************");
	
		SearchByEmailPage srchemail = new SearchByEmailPage(driver);
		int rows = srchemail.getrowscount();
		logger.info("**********Print rows*****************");
		System.out.println("Rows="+rows);
		
		int cols = srchemail.getcolcount();
		logger.info("**********Print columns*****************");
		System.out.println("Cols="+cols);
		
		String lname = srchlname.getlnamedata();
		boolean flag = false;
		
		for(int i=1;i<=rows;i++)
		{
			if(lname.contains("Terces"))
			{
				logger.info("*************Match found*************");
				Assert.assertTrue(true);
				flag = true;
			}
			if(flag==false)
			{
				logger.error("*************No Match found*************");
				captureScreen(driver,"searchBylname");
				Assert.assertTrue(false);
				
			}
			
		}
		logger.info("************* Completed TC_SearchByLname_006******************");
		
		
		
	}
	
	

}
