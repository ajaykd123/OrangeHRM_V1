package com.OrangeHRM.testCases;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.appModules.SignIn_Action;
import com.OrangeHRM.utilities.BaseClass;


public class LoginPageTest extends BaseClass {

	private static Logger log = LogManager.getLogger(LoginPageTest.class.getName());

	@Test
	public void TC01_LoginTest() {

		log.info("Login test started by tester 1 successfully.");

		log.info("Login test started by tester 2 successfully.");

		SignIn_Action.Execute(driver,userName, password);
		try {
			if(driver.getTitle().equals("OrangeHRM")) {
				Assert.assertTrue(true, "Title validated successfully");
				log.info("Title validated successfully.");
			}else {
				Assert.assertTrue(false, "Title not matching");
			}
		}catch(Exception e){
			log.info("Dashboard not displayed,Login Failed");
		}
		
	}

}
