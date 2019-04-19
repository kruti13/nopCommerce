package com.nopCommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopCommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
		
		@Test
		public void logintest() throws IOException
		{
			logger.info("************* Started TC_LoginTest_001******************");
			driver.get(baseURL);
			logger.info("*************Opened URL*************************");
			
			LoginPage lp = new LoginPage(driver);
			logger.info("***************Providing login details********************");
			lp.setUsername(useremail);
			lp.setPassword(password);
			lp.setLogin();
			logger.info("***************Logged in********************");
			
			//Validation
			System.out.println(driver.getTitle());
			logger.info("***************Login page validation********************");
			
			if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
			{
				logger.info("***************Login successful********************");
				Assert.assertTrue(true);
				
			}
			else
			{
				logger.error("***************Login failed********************");
				captureScreen(driver,"logintest");
				Assert.assertTrue(false);

			}
			logger.info("**************Completed TC_LoginTest_001*****************");
		}
		
		
		
		
		
		
	}


