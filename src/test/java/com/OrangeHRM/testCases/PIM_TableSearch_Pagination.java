package com.OrangeHRM.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.appModules.SignIn_Action;
import com.OrangeHRM.utilities.BaseClass;

public class PIM_TableSearch_Pagination extends BaseClass {

	private static Logger log = LogManager.getLogger(LoginPageTest.class.getName());

	@Test
	public void TC05_LoginTest() {
		SignIn_Action.Execute(driver,userName, password);
		
		
	}
}
