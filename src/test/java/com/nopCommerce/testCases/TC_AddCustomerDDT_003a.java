package com.nopCommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.nopCommerce.pageObjects.AddCustDDTPage;
import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.utilities.XLUtils;

public class TC_AddCustomerDDT_003a extends BaseClass {

	@Test(priority=1)
	public void login()
	{
		logger.info("***************Started TC_AddCustomerDDT_003a***************");
		driver.get(baseURL);
		logger.info("*************** Opened URL***************");
		LoginPage lp = new LoginPage(driver);
		logger.info("***************Providing Login Details***************");
		lp.setUsername(useremail);
		lp.setPassword(password);
		lp.setLogin();
		logger.info("***************Logged in ***************");
	}
	
		
	@Test(priority=3, dataProvider = "addcustdata")
	public void addcustDDT(String userid, String pwd, String custrole, String vendor, String gndr, String frstname, String lstname, String dob, String cname, String adminCom, 
			String taxexempt, String news, String actStat) throws InterruptedException, IOException
	{
		logger.info("*************** Starting Add New Customer ***************");
		
		AddCustDDTPage addnew = new AddCustDDTPage(driver);
		addnew.clkCustomerItem();
		addnew.clkCustomerMenu();
		addnew.clkCustomerSubMenu();
		addnew.clkAddNew();
		logger.info("**********Provide customer details******************");
		
		AddCustDDTPage addcust = new AddCustDDTPage(driver);
		addcust.setEmail(userid);
		addcust.setPassword(pwd);
		addcust.setCustRole(custrole);
		addcust.setVendorId(vendor);
		addcust.setgender(gndr);
		addcust.setFirstname(frstname);
		addcust.setLastname(lstname);
		addcust.setDOB(dob);
		addcust.setcompanyname(cname);
		addcust.setadminComment(adminCom);
		addcust.setTax(taxexempt);
		addcust.setnewsletter(news);
		addcust.setActive(actStat);
		
		Thread.sleep(3000);
		
		addcust.clkSave();
		
		Thread.sleep(3000);
		
		logger.info("***************Details Saved*********************");
		
		//Validation
		
		logger.info("****************Validation begins******************");
		
		String txt = driver.findElement(By.tagName("body")).getText();
		System.out.println(txt);
		
		if(txt.contains("The new customer has been added successfully"))
		{
			logger.info("*************** Customer added successfully ***************");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("***************  Customer NOT added ***************");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		logger.info("***************  Completed TC_AddCustomerDDT_003a ***************");

		
		
		
		addcust.clkAddNew();
		
		
			
		
	}
	
	
	@DataProvider(name = "addcustdata")
	public String[][] addcustdata() throws IOException
	{
		String path = System.getProperty("user.dir")+"/TestData/TestData.xlsx";
		
		int rows = XLUtils.getRowCount(path, "AddNewCustomerData");
		logger.info("*************Print rows*****************");
		System.out.println("Rows= " +rows);
		int cols = XLUtils.getCellCount(path, "AddNewCustomerData", 0);
		logger.info("*************Print columns*****************");
		System.out.println("Columns= " +cols);
		
		String addcust[][] = new String[rows][cols];
		
		for(int i=1; i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				addcust[i-1][j] = XLUtils.getCellData(path, "AddNewCustomerData", i, j) ;
			}
		}
		
		return addcust;
		
	}
	

}
