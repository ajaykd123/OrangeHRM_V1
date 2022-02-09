package com.OrangeHRM.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PIM_Objects {

WebDriver driver;
	
	public PIM_Objects(WebDriver driver) {
		 this.driver = driver;
	}

	By PIM_Nav = By.xpath("//a[@id='menu_pim_viewPimModule']");
	public WebElement getPIM_Nav() {
		return driver.findElement(PIM_Nav);
	}
	By PIM_EmployementList_Nav = By.xpath("//a[@id='menu_pim_viewEmployeeList']");
	public WebElement getPIM_EmployementList_Nav() {
		return driver.findElement(PIM_EmployementList_Nav);
	}

	By Admin_UserManagement_Users_Nav = By.xpath("//a[@id='menu_admin_viewSystemUsers']");
	public WebElement getAdmin_UserManagement_Users_Nav() {
		return driver.findElement(Admin_UserManagement_Users_Nav);
	}

	By AddUserBtn = By.xpath("//input[@id='btnAdd']");
	public WebElement getAddUserBtn() {
		return driver.findElement(AddUserBtn);		
	}
	
	By AddUser_UserRole = By.xpath("//select[@id='systemUser_userType']");
	public WebElement getAddUser_UserRole() {
		return driver.findElement(AddUser_UserRole);		
	}
	
	By AddUser_EmployeeName = By.xpath("//input[@id='systemUser_employeeName_empName']");
	public WebElement getAddUser_EmployeeName() {
		return driver.findElement(AddUser_EmployeeName);		
	}

	By Table_EmpNameSuggestive_WebElements= By.xpath("//div[@class='ac_results']//ul//li");
	public List<WebElement> getTable_EmpNameSuggestive_WebElements() {
		return driver.findElements(Table_EmpNameSuggestive_WebElements);		
	}
	
	By AddUser_userName = By.xpath("//input[@id='systemUser_userName']");
	public WebElement getAddUser_userName () {
		return driver.findElement(AddUser_userName );		
	}
	
	By AddUser_Password = By.xpath("//input[@id='systemUser_password']");
	public WebElement getAddUser_Password() {
		return driver.findElement(AddUser_Password);		
	}
	
	By AddUser_Status = By.xpath("//select[@id='systemUser_status']");
	public WebElement getAddUser_Status() {
		return driver.findElement(AddUser_Status);		
	}
	
	By AddUser_ConfirmPwd = By.xpath("//input[@id='systemUser_confirmPassword']");
	public WebElement getAddUser_ConfirmPwd() {
		return driver.findElement(AddUser_ConfirmPwd);		
	}
	
	By AddUser_SaveBtn = By.xpath("//input[@id='btnSave']");
	public WebElement getAddUser_SaveBtn() {
		return driver.findElement(AddUser_SaveBtn);		
	}
	
	By AddUser_passwordStrength= By.xpath("//span[@id='systemUser_password_strength_meter']");
	public WebElement getAddUser_passwordStrength() {
		return driver.findElement(AddUser_passwordStrength);		
	}
	
	By Table_userNameCol_element= By.xpath("//table[@id='resultTable']//thead//tr//th[2]");
	public WebElement getTable_userNameCol_element() {
		return driver.findElement(Table_userNameCol_element);		
	}
	
	By Table_userNameCol_WebElements= By.xpath("//table[@id='resultTable']//tbody//tr//td[2]");
	public List<WebElement> getTable_userNameCol_WebElements() {
		return driver.findElements(Table_userNameCol_WebElements);		
	}

}
