package com.OrangeHRM.appModules;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.OrangeHRM.pageObjects.LoginPage_Objects;

import com.OrangeHRM.utilities.BaseClass;

public class SignIn_Action extends BaseClass{
	
	private static Logger log = LogManager.getLogger(SignIn_Action.class.getName());
	
	       public static void Execute(WebDriver driver, String userName, String password){
	    	LoginPage_Objects obj = new LoginPage_Objects(driver);
	   		obj.getUserName().sendKeys(userName);
	   		log.info("Username entered");
	   		obj.getPassword().sendKeys(password);
	   		log.info("password entered");
	   		obj.getLoginBtn().click();
	   		log.info("Login btn clicked successfully");
	       }
	   
}
