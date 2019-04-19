package com.nopCommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	
	public Readconfig()
	{
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is: " +e.getMessage());
		}
	}

	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserEmail()
	{
		String username = pro.getProperty("useremail");
		return username;
	}
	public String getPassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	public String getChromepath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFireFoxpath()
	{
		String ffpath = pro.getProperty("firefoxpath");
		return ffpath;
	}
	public String getIEpath()
	{
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	
}
