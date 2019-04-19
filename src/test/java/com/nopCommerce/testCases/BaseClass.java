package com.nopCommerce.testCases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopCommerce.utilities.Readconfig;

public class BaseClass {
	
	Readconfig readconfig = new Readconfig();
	
	public WebDriver driver;
	public String baseURL = readconfig.getApplicationURL();
	public String useremail = readconfig.getUserEmail();
	public String password = readconfig.getPassword();
	public Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		logger = Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");
		//logger.setLevel(Level.DEBUG);
		
		if(br.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
		driver = new ChromeDriver();
		logger.info("***************Launched Chrome Browser********************");
		}
		else if(br.equalsIgnoreCase("ie"))
		{
			
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();
			logger.info("***************Launched IE Browser********************");
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxpath());
			driver = new FirefoxDriver();
			logger.info("***************Launched Firefox Browser********************");
		}
	
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() 
	{
		logger.info("***************Browser closed********************");
		driver.close();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot captured!!");
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}

	public String randomNumber()
	{
		String generatednumber = RandomStringUtils.randomNumeric(5);
		return generatednumber;
	}
	
	
}
