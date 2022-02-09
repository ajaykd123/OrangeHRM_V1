package com.OrangeHRM.testCases;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import com.OrangeHRM.appModules.SignIn_Action;
import com.OrangeHRM.pageObjects.Admin_Objects;
import com.OrangeHRM.testData.Constant;
import com.OrangeHRM.utilities.BaseClass;
import com.Selenium.Utilities.DropDownHandling;
import com.Selenium.Utilities.TableHandling;


public class Admin_AddUser_SortingCol_FetchParticularEmpName extends BaseClass {

	private static Logger log = LogManager.getLogger(LoginPageTest.class.getName());
	

	@Test(priority=3)
	public void TC04_AddUser() throws InterruptedException {
		
		Admin_Objects ad = new Admin_Objects(driver);

		ad.getAddUserBtn().click();		
		log.info("Add user button clicked successfully");
		
		Select sc = new Select(ad.getAddUser_UserRole());
		if(!sc.getFirstSelectedOption().getText().equals("Admin")) {
			sc.selectByVisibleText(Constant.AddUser_userRole);
			log.info("By default 'ESS' was selected, clicked 'Admin'.");
		}else {
			log.info("By default 'Admin' selected.");
		}
		
		ad.getAddUser_EmployeeName().sendKeys(Constant.AddUser_EmpName_Input);
		log.info("Input text in EmployeeName serch box.");
		
		List<WebElement> suggestiveOptions = ad.getTable_EmpNameSuggestive_WebElements();
		DropDownHandling.selectOptionFromAutoSuggestiveDropdown(suggestiveOptions, Constant.AddUser_EmpName_Desired);	
		log.info("Employee name selected");
		
		String randomString = randomestring();
		ad.getAddUser_userName().sendKeys(randomString);
		log.info("user name entered");
		
		Select select_status = new Select(ad.getAddUser_Status());
		if(!select_status.getFirstSelectedOption().getText().equals("Enabled")) {
			select_status.selectByVisibleText("Enabled");
			log.info("By default 'Disabled' was selected, clicked 'Enabled'.");
		}else {
			log.info("By default 'Enabled' selected.");
		}
		
		ad.getAddUser_Password().sendKeys(Constant.AddUser_password);//CdErFv123@456
		log.info("password entered");
		ad.getAddUser_ConfirmPwd().sendKeys(Constant.AddUser_confirmPassword);
		log.info("confirm password entered");
		if(ad.getAddUser_passwordStrength().getText().equals("Very Weak")) {
			log.warn("password strength is very weak, unale to create user");
		}else {
			log.info("password strength is Strongest,");
		}
		
		Thread.sleep(2000);
		ad.getAddUser_SaveBtn().click();
		log.info("confirm password entered");
		
		//check added user in WebTable
		List<String> addedUser = ad.getTable_userNameCol_WebElements().stream()
				.filter(s -> s.getText().contains(randomString)).map(s -> s.getText()).collect(Collectors.toList());
		if(addedUser.size()>=1) {
			System.out.println(addedUser.get(0));
			log.info("user added successfully");
		}
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void TC03_Fetch_EmpName_Of_Particular_User() throws Exception {
		//SignIn_Action.Execute(driver, userName, password);
		Admin_Objects ad = new Admin_Objects(driver);
		List<String> empName = ad.getTable_userNameCol_WebElements().stream()
				.filter(s -> s.getText().contains(Constant.Fetch_EmpName)).map(s -> getUsernames(s)).collect(Collectors.toList());
		empName.forEach(a->System.out.println(a));
		log.info("Emp name fetched for "+Constant.Fetch_EmpName+" Successfully");
		
	}
	
	private static String getUsernames(WebElement s) {
		String empName = s.findElement(By.xpath("following-sibling::td[2]")).getText();
		return empName;
	}
	
	@Test(priority=1)
	public void TC02_TableSorting() throws Exception {
		SignIn_Action.Execute(driver, userName, password);
		Admin_Objects ad = new Admin_Objects(driver);
		ad.getAdminNav().click();
		log.info("Admin on navigation clicked");
		Actions act = new Actions(driver);
		act.moveToElement(ad.getAdmin_UserManagement_Nav()).moveToElement(ad.getAdmin_UserManagement_Users_Nav()).click().perform();
		log.info("Successfully hover over on 'Admin_UserManagement' and 'Admin_Users'");
		TableHandling.sortingColumn(driver, ad.getTable_userNameCol_element(),ad.getTable_userNameCol_WebElements(), "header headerSortUp");
		log.info("Column 'username sorted Successfully");
		
	}
}
