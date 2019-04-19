package com.nopCommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
	@Test(dataProvider = "LoginData")
	public void logintest(String testusername, String testpassword) throws IOException
	{
		logger.info("************* Started TC_LoginDDT_002******************");
		driver.get(baseURL);
		logger.info("*************Opened URL*************************");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("***************Providing login details********************");
		lp.setUsername(testusername);
		lp.setPassword(testpassword);
		lp.setLogin();
				
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
		logger.info("**************Completed TC_LoginDDT_002*****************");
	}
	
	@DataProvider(name ="LoginData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/TestData/TestData.xlsx";
		
		int rowcount = XLUtils.getRowCount(path, "LoginTestData");
		int colcount = XLUtils.getCellCount(path, "LoginTestData", 1);
		
		String logindata[][] = new String[rowcount][colcount];
		for(int i=1; i<=rowcount;i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "LoginTestData", i, j);
			}
		}
		return logindata;
		
	}

	
	
	
	
}
