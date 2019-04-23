package com.nopCommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.AddCustomerPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.pageObjects.SearchByCustomerRolesPage;
import com.nopCommerce.pageObjects.SearchByEmailPage;

public class TC_SearchByCustRole_008 extends BaseClass {
	
	@Test
	public void searchBycustrole() throws IOException, InterruptedException
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
		
		logger.info("***************Search By Customer roles************************");
		SearchByCustomerRolesPage srchrole = new SearchByCustomerRolesPage(driver);
		srchrole.clkdefaultrole();
		srchrole.clkcustrole();
		Thread.sleep(3000);
		srchrole.setCustrole("Registered");
		srchrole.clkSearch();
		Thread.sleep(3000);
		
		SearchByEmailPage srchemail = new SearchByEmailPage(driver);
		int rows = srchemail.getrowscount();
		logger.info("***************Print rows************************");
		System.out.println("Rows=" +rows);
		
		int cols = srchemail.getcolcount();
		logger.info("***************Print columns************************");
		System.out.println("Columns= "+cols);
		
		String role = srchrole.setroledata();
		boolean flag = false;
		//Validation
		logger.info("***********Search validation*****************");
		for(int i=1;i<=rows;i++)
		{
			if(role.equalsIgnoreCase("Registered"))
			{
				logger.info("***********Match found******************");
				Assert.assertTrue(true);
				flag = true;
			}
			if (flag == false)
			{
				logger.info("***********No Match found******************");
				captureScreen(driver,"searchBycustrole");
				Assert.assertTrue(false);
			}
		}
		
		
		
		
	}
	
	

}
