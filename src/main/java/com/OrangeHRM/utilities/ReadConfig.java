package com.OrangeHRM.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() {
		File src = new File("./Configurations\\config.properties"); // Create instance of File and provide String pathname and converts in to Abstract pathname
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();			
				prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	public String getUserName() {		
		String uName = prop.getProperty("userName");
		return uName;		
	}
	public String getPassword() {		
		String pwd = prop.getProperty("password");
		return pwd;		
	}
	public String getChromePath() {		
		String pwd = prop.getProperty("chromePath");
		return pwd;		
	}
	public String getMsEdgePath() {		
		String pwd = prop.getProperty("msEdgePath");
		return pwd;		
	}
	public String getFirefoxPath() {		
		String pwd = prop.getProperty("firefoxPath");
		return pwd;		
	}
}
