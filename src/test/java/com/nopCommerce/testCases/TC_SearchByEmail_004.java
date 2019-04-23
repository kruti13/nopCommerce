package com.nopCommerce.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopCommerce.pageObjects.AddCustomerPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.SearchByEmailPage;

public class TC_SearchByEmail_004 extends BaseClass{
	
	@Test
	public void searchbymail() throws IOException
	{
		logger.info("************* Started TC_SearchByEmail_004******************");
		driver.get(baseURL);
		logger.info("*************Opened URL*************************");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("***************Providing login details********************");
		lp.setUsername(useremail);
		lp.setPassword(password);
		lp.setLogin();
		logger.info("***************Logged in********************");
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.setCustomerItem();
		addcust.clkCustomermenu();
		addcust.clkCustomermenuItem();
		
		logger.info("************* Search by Customer email ***********************");
		SearchByEmailPage userid = new SearchByEmailPage(driver);
		userid.setemailid("victoria_victoria@nopCommerce.com");
		
		userid.clkSearch();
		
				
		
		//Validation
		
		logger.info("************* Search validation begins***********************");
		int rows = userid.getrowscount();
		logger.info("*****************Print rows*******************");
		System.out.println("Rows= " +rows);
		int cols = userid.getcolcount();
		logger.info("*****************Print columns*******************");
		System.out.println("Columns= " +cols);
		boolean flag = false;
		for(int i=1; i<rows;i++)
		{
			String mail = userid.getmaildata();
			
			if(mail.contains("victoria_victoria@nopCommerce.com"))
					{
					logger.info("***************Match found*****************");
					Assert.assertTrue(true);
					flag = true;
					break;
					}
			if (flag == false)
			{
				logger.error("***************No Matches found*****************");
				captureScreen(driver,"searchbymail");
				Assert.assertTrue(false);
			}
			
		}
		
		
		logger.info("************* Completed TC_SearchByEmail_004******************");
		
	}
	
	

}
